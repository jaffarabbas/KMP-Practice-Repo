package org.example.project.Screens.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.UriHandler
import createNotification
import org.example.project.UrlProvider
import org.example.project.navigation.Routes

@Composable
fun HomePageUI(
    homeData:Routes.HomePage,
    urlHandler: UrlProvider,
    click:() -> Unit,
){
    val urlHandler = LocalUriHandler.current;
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                click.invoke()
            }){
                Text("Click ME")
            }
            Button(onClick = {
                val notification = createNotification(NotificationType.TOAST)
                notification.show("Hello, World!")
            }){
                Text("Toaster")
            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Home Page as ${homeData.name}", modifier = Modifier.clickable(){
                    click.invoke()
                })
            }
        }
}