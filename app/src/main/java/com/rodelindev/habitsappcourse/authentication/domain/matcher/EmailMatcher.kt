package com.rodelindev.habitsappcourse.authentication.domain.matcher

interface EmailMatcher {
    fun isValid(email: String): Boolean
}