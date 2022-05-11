package com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository

import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.ApiRequest
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.ApiResponse
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.UserUpdate
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
    suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse //request of type api request
    suspend fun getUserInfo(): ApiResponse // no parameter  but return response
    suspend fun updateUser(userUpdate: UserUpdate): ApiResponse//one parameter update user but returns api response object
    suspend fun deleteUser(): ApiResponse
    suspend fun clearSession(): ApiResponse
}
