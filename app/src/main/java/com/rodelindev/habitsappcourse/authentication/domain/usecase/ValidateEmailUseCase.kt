package com.rodelindev.habitsappcourse.authentication.domain.usecase

import com.rodelindev.habitsappcourse.authentication.domain.matcher.EmailMatcher

class ValidateEmailUseCase(private val emailMatcher: EmailMatcher) {
    operator fun invoke(email: String): Boolean {
        return emailMatcher.isValid(email)
    }
}