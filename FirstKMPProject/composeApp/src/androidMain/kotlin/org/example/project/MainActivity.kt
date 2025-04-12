package org.example.project

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val primaryColor = MaterialTheme.colors.primary

            // Change status bar color to match TopAppBar
            val view = LocalView.current
            SideEffect {
                (view.context as? Activity)?.window?.statusBarColor = primaryColor.toArgb()
            }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground,
                topBar = {
                    TopAppBar(
                        title = { Text("Compose App") },
                        backgroundColor = primaryColor,
                        contentColor = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.statusBarsPadding() // Respect safe area
                    )
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    App(UrlProvider())
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(UrlProvider())
}
