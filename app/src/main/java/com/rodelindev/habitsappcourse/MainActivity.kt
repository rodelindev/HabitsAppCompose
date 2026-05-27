package com.rodelindev.habitsappcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rodelindev.habitsappcourse.navigation.NavigationHost
import com.rodelindev.habitsappcourse.navigation.NavigationRoute
import com.rodelindev.habitsappcourse.ui.theme.HabitsAppCourseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HabitsAppCourseTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationHost(
                        navHostController = rememberNavController(),
                        startDestination = getStartDestination(),
                        logout = viewModel::logout
                    )
                }
            }
        }
    }

    private fun getStartDestination(): NavigationRoute {
        return when {
            viewModel.isLoggedIn -> NavigationRoute.Home
            viewModel.hasSeenOnboarding -> NavigationRoute.Login
            else -> NavigationRoute.Onboarding
        }
    }
}

