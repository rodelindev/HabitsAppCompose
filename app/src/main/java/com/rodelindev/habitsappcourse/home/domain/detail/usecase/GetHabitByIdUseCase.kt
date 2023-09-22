package com.rodelindev.habitsappcourse.home.domain.detail.usecase

import com.rodelindev.habitsappcourse.home.domain.models.Habit
import com.rodelindev.habitsappcourse.home.domain.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetHabitByIdUseCase(
    private val repository: HomeRepository
) {
    suspend operator fun invoke(id: String): Habit {
        return withContext(Dispatchers.IO) {
            repository.getHabitById(id)
        }
    }
}