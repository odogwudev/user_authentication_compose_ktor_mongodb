package com.odogwudev.user_authentication_compose_ktor_mongodb.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.odogwudev.user_authentication_compose_ktor_mongodb.data.remote.KtorApi
import com.odogwudev.user_authentication_compose_ktor_mongodb.data.repository.DataStoreOperationImpl
import com.odogwudev.user_authentication_compose_ktor_mongodb.data.repository.RepositoryImpl
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository.DataStoreOperation
import com.odogwudev.user_authentication_compose_ktor_mongodb.domain.repository.Repository
import com.odogwudev.user_authentication_compose_ktor_mongodb.util.Constants.PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(PREFERENCES_NAME) }
        )
    }

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperation {
        return DataStoreOperationImpl(dataStore = dataStore)
    }

    @Provides
    @Singleton
    fun provideRepository(
        dataStoreOperations: DataStoreOperation,
        ktorApi: KtorApi
    ): Repository {
        return RepositoryImpl(
            dataStoreOperations = dataStoreOperations,
            ktorApi = ktorApi
        )
    }

}