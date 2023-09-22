package com.rodelindev.habitsappcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
        setContent {
            HabitsAppCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavigationHost(
                        navHostController = navController,
                        startDestination = getStartDestination(),
                        logout = {
                            viewModel.logout()
                        }

                    )
                }
            }
        }
    }

    private fun getStartDestination(): NavigationRoute {
        return if (viewModel.isLoggedIn) {
            NavigationRoute.Home
        } else {
            if (viewModel.hasSeenOnboarding) {
                NavigationRoute.Login
            } else {
                NavigationRoute.Onboarding
            }
        }
    }
}

