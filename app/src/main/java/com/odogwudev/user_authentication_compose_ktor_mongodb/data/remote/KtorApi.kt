package com.odogwudev.user_authentication_compose_ktor_mongodb.data.remote

import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.ApiRequest
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.ApiResponse
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.model.UserUpdate
import retrofit2.http.*

interface KtorApi {

    @POST("/token_verification")// verify tokenid passing api request that contains token id that needs to verified on the server
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ): ApiResponse

    @GET("/get_user_info")
    suspend fun getUserInfo(): ApiResponse

    @PUT("/update_user_info")
    suspend fun updateUser(
        @Body userUpdate: UserUpdate// object contains first name last name
    ): ApiResponse

    @DELETE("/delete_user_info")
    suspend fun deleteUser(): ApiResponse

    @GET("/sign_out")
    suspend fun clearSession(): ApiResponse

}