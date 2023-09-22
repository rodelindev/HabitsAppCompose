package com.rodelindev.habitsappcourse.home.domain.alarm

import com.rodelindev.habitsappcourse.home.domain.models.Habit

interface AlarmHandler {
    fun setRecurringAlarm(habit: Habit)
    fun cancel(habit: Habit)
}