package com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperation {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean> // i didnt use a suspend because i am returning flow which is asynchronous by default
}