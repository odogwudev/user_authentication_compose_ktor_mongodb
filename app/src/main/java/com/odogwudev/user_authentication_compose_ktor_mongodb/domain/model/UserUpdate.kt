package com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserUpdate(
    val firstName: String,
    val lastName: String
)
