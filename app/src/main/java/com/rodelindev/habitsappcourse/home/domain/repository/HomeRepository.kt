package com.rodelindev.habitsappcourse.home.domain.repository


import com.rodelindev.habitsappcourse.home.domain.models.Habit
import kotlinx.coroutines.flow.Flow
import java.time.ZonedDateTime


interface HomeRepository {
    fun getAllHabitsForSelectedDate(date: ZonedDateTime): Flow<List<Habit>>
    suspend fun insertHabit(habit: Habit)
    suspend fun getHabitById(id: String): Habit
    suspend fun syncHabits()
}