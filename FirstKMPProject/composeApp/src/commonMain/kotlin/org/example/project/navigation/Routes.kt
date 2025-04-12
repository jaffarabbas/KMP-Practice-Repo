package org.example.project.navigation

import kotlinx.serialization.Serializable

sealed class SubGraph{
    @Serializable
    object Auth: SubGraph()
    @Serializable
    object Home: SubGraph()
}

sealed class Routes {
    @Serializable
    object LoginPage: Routes()
    @Serializable
    object SignUpPage: Routes()

    @Serializable
    data class HomePage(val name: String): Routes()
    @Serializable
    object Dashboard: Routes()
    @Serializable
    object Notification: Routes()
    @Serializable
    data class Profile(val name: String): Routes()
}