package com.rodelindev.habitsappcourse.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rodelindev.habitsappcourse.authentication.presentation.login.LoginScreen
import com.rodelindev.habitsappcourse.authentication.presentation.signup.presentation.SignupScreen
import com.rodelindev.habitsappcourse.home.presentation.detail.DetailScreen
import com.rodelindev.habitsappcourse.home.presentation.home.HomeScreen
import com.rodelindev.habitsappcourse.onboarding.presentation.OnboardingScreen
import com.rodelindev.habitsappcourse.settings.presentation.SettingsScreen


@Composable
fun NavigationHost(
    navHostController: NavHostController,
    startDestination: NavigationRoute,
    logout: () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination.route
    ) {

        composable(NavigationRoute.Onboarding.route) {
            OnboardingScreen(
                onFinish = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Login.route)
                }
            )
        }

        composable(NavigationRoute.Login.route) {
            LoginScreen(
                onLogin = {
                    navHostController.popBackStack()
                    navHostController.navigate(NavigationRoute.Home.route)
                },
                onSignUp = {
                    navHostController.navigate(NavigationRoute.Signup.route)
                }
            )
        }

        composable(NavigationRoute.Signup.route) {
            SignupScreen(
                onSignIn = {
                    navHostController.navigate(NavigationRoute.Home.route) {
                        popUpTo(navHostController.graph.id) {
                            inclusive = true
                        }
                    }
                },
                onLogin = {
                    navHostController.popBackStack()
                }
            )
        }

        composable(NavigationRoute.Home.route) {
            HomeScreen(
                onNewHabit = {
                    navHostController.navigate(NavigationRoute.Detail.route)
                },
                onSettings = {
                    navHostController.navigate(NavigationRoute.Settings.route)
                },
                onEditHabit = {
                    navHostController.navigate(NavigationRoute.Detail.route + "?habitId=$it")
                }
            )
        }

        composable(
            route = NavigationRoute.Detail.route + "?habitId={habitId}",
            arguments = listOf(
                navArgument("habitId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            DetailScreen(
                onBack = {
                    navHostController.popBackStack()
                },
                onSave = {
                    navHostController.popBackStack()
                }
            )
        }

        composable(NavigationRoute.Settings.route) {
            SettingsScreen(
                onBack = {
                    navHostController.popBackStack()
                },
                onLogout = {
                    logout()
                    navHostController.navigate(NavigationRoute.Login.route) {
                        popUpTo(navHostController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}