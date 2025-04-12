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

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = SubGraph.Auth){
        navigation<SubGraph.Auth>(startDestination = Routes.LoginPage){
            composable<Routes.LoginPage> {
                LoginPageUI(
                    clickLogin = {
                        navController.navigate(Routes.SignUpPage)
                    }
                )
            }
            composable<Routes.SignUpPage>{
                SignUpPageUI (
                    clickLogin = {
                        navController.navigate(SubGraph.Home)
                    }
                )
            }
        }
        navigation<SubGraph.Home>(startDestination = Routes.Dashboard){
            composable<Routes.HomePage> {
                val homeData = it.toRoute<Routes.HomePage>();
                HomePageUI(homeData = homeData) {
                    navController.navigate(Routes.Profile){
                        popUpTo(Routes.HomePage) {
                            inclusive = true
                        }
                    }
                }
            }
            composable<Routes.Dashboard> {
                DashboardUI()
            }
            composable<Routes.Notification> {
                NotificationPageUI()
            }
            composable<Routes.Profile> {
                val profileData = it.toRoute<Routes.Profile>();
                ProfilePageUI(profileData = profileData) {
                    navController.navigate(Routes.Profile)
                }
            }
        }
    }
}