package org.example.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import org.example.project.Screens.Auth.LoginPageUI
import org.example.project.Screens.Auth.SignUpPageUI
import org.example.project.Screens.Home.DashboardUI
import org.example.project.Screens.Home.HomePageUI
import org.example.project.Screens.Home.NotificationPageUI
import org.example.project.Screens.Home.ProfilePageUI
import org.example.project.UrlProvider

@Composable
fun AppNavigation(urlProvider: UrlProvider) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SubGraph.Auth) {
        navigation<SubGraph.Auth>(startDestination = Routes.LoginPage) {
            composable<Routes.LoginPage> {
                LoginPageUI(
                    clickLogin = {
                        navController.navigate(Routes.SignUpPage)
                    }
                )
            }
            composable<Routes.SignUpPage> {
                SignUpPageUI(
                    clickLogin = {
                        // Provide default name when navigating to Home
                        navController.navigate(SubGraph.Home)
                    }
                )
            }
        }
        navigation<SubGraph.Home>(startDestination = Routes.Dashboard) {
            composable<Routes.HomePage> {
                val homeData = it.toRoute<Routes.HomePage>()
                HomePageUI(homeData = homeData, urlHandler = urlProvider) {
                    navController.navigate(Routes.Profile(name = homeData.name)) {
                        popUpTo(Routes.HomePage) {
                            inclusive = true
                        }
                    }
                }
            }
            composable<Routes.Dashboard> {
                DashboardUI() {
                    navController.navigate(Routes.Profile(name = "DashboardUser"))
                }
            }
            composable<Routes.Notification> {
                NotificationPageUI()
            }
            composable<Routes.Profile> {
                val profileData = it.toRoute<Routes.Profile>()
                ProfilePageUI(profileData = profileData) {
                    navController.navigate(Routes.HomePage(name = profileData.name)) {
                        popUpTo(SubGraph.Home) {
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            }
        }
    }
}