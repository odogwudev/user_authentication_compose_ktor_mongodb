package com.odogwudev.user_authentication_compose_ktor_mongodb.data.repository

import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository.DataStoreOperation
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperation: DataStoreOperation
) : Repository {
    override suspend fun saveSignedinState(signedIn: Boolean) {
        dataStoreOperation.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedINState(): Flow<Boolean> {
        return dataStoreOperation.readSignedInState()
    }
}