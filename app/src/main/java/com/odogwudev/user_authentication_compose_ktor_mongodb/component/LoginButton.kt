package com.odogwudev.user_authentication_compose_ktor_mongodb.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.odogwudev.user_authentication_compose_ktor_mongodb.R
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.LoadingBlue
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.Shapes


@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    loadingState: Boolean = false,
    primaryText: String = "Sign IN with Google",
    secondaryText: String = "Please Wait...",
    icon: Int = R.drawable.ic_google_logo,
    shape: Shape = Shapes.medium,
    border: Color = Color.LightGray,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicator: Color = LoadingBlue,
    onClick: () -> Unit
) {
    var buttonText by remember {
        mutableStateOf(primaryText)
    }
    LaunchedEffect(key1 = loadingState) {
        buttonText = if (loadingState) secondaryText else primaryText
    }


    Surface(
        modifier = modifier
            .clickable(enabled = !loadingState) {
                onClick()
            },
        shape = shape,
        border = BorderStroke(width = 1.dp, color = border),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Logo",
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = buttonText)
            if (loadingState) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier.size(16.dp), strokeWidth = 2.dp, color = progressIndicator
                )
            }
        }

    }
}

@Composable
@Preview
fun buttonPreview(){
    LoginButton {}
}