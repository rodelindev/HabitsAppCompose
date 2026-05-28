// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    //KSP
    alias(libs.plugins.ksp) apply false
    //Dagger Hilt
    alias(libs.plugins.hilt.android) apply false
    //Google service
    alias(libs.plugins.google.service) apply false
}