package com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model

import java.lang.Exception

data class MessageBarState(
    val message: String? = null,
    val error: Exception? = null
)