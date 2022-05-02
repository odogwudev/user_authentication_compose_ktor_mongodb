package com.odogwudev.user_authentication_compose_ktor_mongodb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.odogwudev.user_authentication_compose_ktor_mongodb.navigation.SetupNavGraph
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.User_authentication_compose_ktor_mongodbTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            User_authentication_compose_ktor_mongodbTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}