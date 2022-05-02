package com.odogwudev.user_authentication_compose_ktor_mongodb.presentation.screen.login

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.topAppBarBackgroundColor
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.topAppBarContentColor

@Composable
fun LoginTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Sign in",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
@Preview
fun LoginTopBarPreview() {
    LoginTopBar()
}