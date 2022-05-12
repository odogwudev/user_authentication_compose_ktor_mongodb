package com.odogwudev.user_authentication_compose_ktor_mongodb.presentation.screen.profile

import androidx.compose.material.*
import com.odogwudev.user_authentication_compose_ktor_mongodb.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.topAppBarBackgroundColor
import com.odogwudev.user_authentication_compose_ktor_mongodb.ui.theme.topAppBarContentColor

@Composable
fun ProfileTopBar(
    onSave: () -> Unit,
    onDeleteAllConfirmed: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ProfileTopBarActions(
                onSave = onSave,
                onDeleteAllConfirmed = onDeleteAllConfirmed
            )
        }
    )

}

@Composable
fun ProfileTopBarActions(
    onSave: () -> Unit,
    onDeleteAllConfirmed: () -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }



    SaveAction(onSave = onSave)
    DeleteAllAction(onDelete = { openDialog = true })
}

@Composable
fun SaveAction(onSave: () -> Unit) {
    IconButton(onClick = onSave) {
        Icon(
            painter = painterResource(id =  R.drawable.ic_save),
            contentDescription = "Save Icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun DeleteAllAction(onDelete: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = "Vertical Menu",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDelete()
                }
            ) {
                Text(
                    text = "Delete Account",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
fun ProfileTopBarPreview() {
    ProfileTopBar(onSave = {}, onDeleteAllConfirmed = {})
}
