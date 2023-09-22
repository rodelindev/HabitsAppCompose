package com.rodelindev.habitsappcourse.authentication.domain.usecase

import com.rodelindev.habitsappcourse.authentication.domain.repository.AuthenticationRepository

class LoginWithEmailUseCase(private val repository: AuthenticationRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.login(email, password)
    }
}