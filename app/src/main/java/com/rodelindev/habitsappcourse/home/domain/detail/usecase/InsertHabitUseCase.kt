package com.rodelindev.habitsappcourse.home.domain.detail.usecase

import com.rodelindev.habitsappcourse.home.domain.models.Habit
import com.rodelindev.habitsappcourse.home.domain.repository.HomeRepository

class InsertHabitUseCase(private val repository: HomeRepository) {
    suspend operator fun invoke(habit: Habit) {
        repository.insertHabit(habit)
    }
}