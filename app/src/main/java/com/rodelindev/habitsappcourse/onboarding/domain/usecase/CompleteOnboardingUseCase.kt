package com.rodelindev.habitsappcourse.onboarding.domain.usecase

import com.rodelindev.habitsappcourse.onboarding.domain.repository.OnboardingRepository

class CompleteOnboardingUseCase(
    private val repository: OnboardingRepository
) {
    operator fun invoke() {
        repository.completeOnboarding()
    }
}