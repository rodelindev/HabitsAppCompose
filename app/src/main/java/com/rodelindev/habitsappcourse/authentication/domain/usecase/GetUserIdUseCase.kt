package com.rodelindev.habitsappcourse.authentication.domain.usecase

import com.rodelindev.habitsappcourse.authentication.domain.repository.AuthenticationRepository

class GetUserIdUseCase(private val repository: AuthenticationRepository) {
    operator fun invoke(): String? {
        return repository.getUserId()
    }
}