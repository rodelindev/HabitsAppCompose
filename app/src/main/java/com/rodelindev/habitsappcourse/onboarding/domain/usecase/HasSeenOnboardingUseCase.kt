package com.rodelindev.habitsappcourse.onboarding.domain.usecase

import com.rodelindev.habitsappcourse.onboarding.domain.repository.OnboardingRepository

class HasSeenOnboardingUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke(): Boolean {
        return repository.hasSeenOnboarding()
    }
}