plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //Dagger-hilt
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    //Google Service
    id("com.google.gms.google-services")
}

android {
    namespace = "com.rodelindev.habitsappcourse"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.rodelindev.habitsappcourse"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.rodelindev.habitsappcourse.HiltTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
    //Get day of week api 25 or lower
    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:2.0.3")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    //Time Picker
    val timePicker = "1.1.0"
    implementation("com.maxkeppeler.sheets-compose-dialogs:core:$timePicker")
    implementation("com.maxkeppeler.sheets-compose-dialogs:clock:$timePicker")

    //Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:31.2.2"))
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.android.gms:play-services-auth:20.6.0")

    //Dagger Hilt
    val hiltVersion = "2.45"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Pager
    val accompanistVersion = "0.28.0"
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")

    // Permissions
    implementation("com.google.accompanist:accompanist-permissions:$accompanistVersion")

    // Room
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-ktx:$roomVersion")
    //noinspection KaptUsageInsteadOfKsp
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-runtime:$roomVersion")

    // Retrofit
    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    // WorkManager
    val workManagerVersion = "2.8.1"
    implementation("androidx.work:work-runtime-ktx:$workManagerVersion")
    implementation("androidx.hilt:hilt-work:1.0.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.1")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:$hiltVersion")
    testImplementation ("app.cash.turbine:turbine:0.7.0")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:$hiltVersion")
    val mockkVersion = "1.13.4"
    testImplementation ("io.mockk:mockk:$mockkVersion")
    androidTestImplementation ("androidx.work:work-testing:$workManagerVersion")
}