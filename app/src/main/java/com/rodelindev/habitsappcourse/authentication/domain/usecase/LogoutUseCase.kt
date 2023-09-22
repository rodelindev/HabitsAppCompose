package com.rodelindev.habitsappcourse.authentication.domain.usecase

import com.rodelindev.habitsappcourse.authentication.domain.repository.AuthenticationRepository

class LogoutUseCase(private val repository: AuthenticationRepository) {
    suspend operator fun invoke() {
        return repository.logout()
    }
}