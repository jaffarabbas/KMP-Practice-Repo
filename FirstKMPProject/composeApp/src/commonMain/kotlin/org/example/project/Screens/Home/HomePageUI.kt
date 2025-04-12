package org.example.project.Screens.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.example.project.navigation.Routes

@Composable
fun HomePageUI(
    homeData:Routes.HomePage,
    click:() -> Unit,
){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Home Page as ${homeData.name}", modifier = Modifier.clickable(){
           click.invoke()
        })
    }
}