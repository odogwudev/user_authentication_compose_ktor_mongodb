package com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class ApiResponse(
    val success: Boolean,
    val user: User? = null,
    val message: String? = null,
    @Transient
    val error: Exception? = null//marking it invvinsible for the whole serialization process
)