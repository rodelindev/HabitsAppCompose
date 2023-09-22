package com.rodelindev.habitsappcourse.authentication.presentation.signup.presentation

sealed interface SignupEvent {
    data class EmailChange(val email: String) : SignupEvent
    data class PasswordChange(val password: String) : SignupEvent
    object LogIn : SignupEvent
    object SignUp : SignupEvent
}