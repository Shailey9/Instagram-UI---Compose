package com.example.instaui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun navigation(context:Context) {
    val navigationState = rememberNavController()
    NavHost(navController = navigationState, startDestination = "main_screen"){
        composable("main_screen"){
            Column(modifier = Modifier.fillMaxSize()) {
                ProfileStat()
                posts(list = listOf("one", "two", "three", "four", "one", "two", "three", "four","nine"), onClick = {
                    navigationState.navigate("post_screen/{$it}")
                })
            }
        }
        composable("post_screen"+"/{post_name}", arguments = listOf(navArgument("post_name"){
            type = NavType.StringType
            defaultValue = "enable to load"
        })){
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Toast.makeText(context, ""+it, Toast.LENGTH_LONG).show()
                Image(painter = painterResource(id = R.drawable.ic_launcher_background)
                    , contentDescription = "posts",
                    modifier = Modifier.border(2.dp, Color.White, RectangleShape)
                        .aspectRatio(1f)
                )
            }
        }
    }
}