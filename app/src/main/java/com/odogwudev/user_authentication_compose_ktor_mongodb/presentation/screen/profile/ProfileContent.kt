package com.odogwudev.user_authentication_compose_ktor_mongodb.presentation.screen.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.odogwudev.user_authentication_compose_ktor_mongodb.R
import com.odogwudev.user_authentication_compose_ktor_mongodb.component.LoginButton
import com.odogwudev.user_authentication_compose_ktor_mongodb.component.MessageBar
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.ApiResponse
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.MessageBarState
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.LoadingBlue
import com.odogwudev.user_authentication_compose_ktor_mongodb.util.RequestState

@ExperimentalCoilApi
@Composable
fun ProfileContent(
    apiResponse: RequestState<ApiResponse>,
    messageBarState: MessageBarState,
    firstName: String,
    onFirstNameChanged: (String) -> Unit,// this lamda would take a string that would be entered from the screen
    lastName: String,
    onLastNameChanged: (String) -> Unit,
    emailAddress: String?,
    profilePhoto: String?,
    onSignOutClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.weight(1f)) {    //progress indicator
            if (apiResponse is RequestState.Loading) {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth(),
                    color = LoadingBlue
                )
            } else {
                MessageBar(messageBarState = messageBarState)
            }
        }
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CentralContent(
                firstName = firstName,
                onFirstNameChanged = onFirstNameChanged,
                lastName = lastName,
                onLastNameChanged = onLastNameChanged,
                emailAddress = emailAddress,
                profilePhoto = profilePhoto,
                onSignOutClicked = onSignOutClicked
            )
        }
    }
}

@ExperimentalCoilApi
@Composable
private fun CentralContent(
    firstName: String,
    onFirstNameChanged: (String) -> Unit,
    lastName: String,
    onLastNameChanged: (String) -> Unit,
    emailAddress: String?,
    profilePhoto: String?,
    onSignOutClicked: () -> Unit
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = profilePhoto)
            .crossfade(durationMillis = 1000)
            .placeholder(drawableResId = R.drawable.ic_placeholder)
            .transformations(CircleCropTransformation())
            .build(),
        contentDescription = "Profile Photo"
    )
    OutlinedTextField(
        value = firstName,
        onValueChange = { onFirstNameChanged(it) },
        label = { Text(text = "First Name") },
        textStyle = MaterialTheme.typography.body1,
        singleLine = true
    )
    OutlinedTextField(
        value = lastName,
        onValueChange = { onLastNameChanged(it) },
        label = { Text(text = "Last Name") },
        textStyle = MaterialTheme.typography.body1,
        singleLine = true
    )
    OutlinedTextField(
        value = emailAddress.toString(),
        onValueChange = { },
        label = { Text(text = "Email Address") },
        textStyle = MaterialTheme.typography.body1,
        singleLine = true,
        enabled = false
    )
    LoginButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        primaryText = "Sign Out",
        secondaryText = "Sign Out",
        onClick = onSignOutClicked
    )
}