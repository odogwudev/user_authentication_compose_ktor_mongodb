package com.odogwudev.user_authentication_compose_ktor_mongodb.presentation.screen.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.MessageBarState

@Composable
fun LoginScreen(navController: NavController) {

    Scaffold(
        topBar = {
            LoginTopBar()
        },
        content = {
            LoginContent(
                signedInState = false,
                messageBarState = MessageBarState(),
                onButtonClicked = {}
            )

        }
    )
}