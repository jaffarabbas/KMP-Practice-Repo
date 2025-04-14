package org.example.project

import NotificationType
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import createNotification
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import firstkmpproject.composeapp.generated.resources.Res
import firstkmpproject.composeapp.generated.resources.compose_multiplatform
import org.example.project.navigation.AppNavigation

@Composable
@Preview
fun App(urlProvider:UrlProvider) {
    MaterialTheme {
        AppNavigation(urlProvider)
    }
}