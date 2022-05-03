package com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveSignedinState(signedIn: Boolean)
    fun readSignedINState(): Flow<Boolean>
}