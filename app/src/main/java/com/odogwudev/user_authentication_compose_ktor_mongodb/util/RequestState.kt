package com.odogwudev.user_authentication_compose_ktor_mongodb.util

//wrapper class for our states it helps in reacting to different changes in our class
sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(val t: Throwable) : RequestState<Nothing>()
}