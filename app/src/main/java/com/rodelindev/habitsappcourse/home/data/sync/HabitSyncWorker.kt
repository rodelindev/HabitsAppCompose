package com.rodelindev.habitsappcourse.home.data.sync

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.rodelindev.habitsappcourse.home.data.local.HomeDao
import com.rodelindev.habitsappcourse.home.data.local.entity.HabitSyncEntity
import com.rodelindev.habitsappcourse.home.data.mapper.toDomain
import com.rodelindev.habitsappcourse.home.data.mapper.toDto
import com.rodelindev.habitsappcourse.home.data.remote.HomeApi
import com.rodelindev.habitsappcourse.home.data.remote.util.resultOf
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

@HiltWorker
class HabitSyncWorker @AssistedInject constructor(
    @Assisted val context: Context,
    @Assisted val workerParameters: WorkerParameters,
    private val api: HomeApi,
    private val dao: HomeDao
) : CoroutineWorker(context, workerParameters) {
    
    override suspend fun doWork(): Result {
        if (runAttemptCount >= 3) {
            return Result.failure()
        }

        val items = dao.getAllHabitsSync()

        return try {
            supervisorScope {
                val jobs = items.map { items -> async { sync(items) } }
                jobs.awaitAll()
            }
            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    private suspend fun sync(entity: HabitSyncEntity) {
        val habit = dao.getHabitById(entity.id).toDomain().toDto()
        resultOf {
            api.insertHabit(habit)
        }.onSuccess {
            dao.deleteHabitSync(entity)
        }.onFailure {
            throw it
        }
    }
}