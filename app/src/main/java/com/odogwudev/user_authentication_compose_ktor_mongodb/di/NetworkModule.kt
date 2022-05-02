
package com.odogwudev.user_authentication_compose_ktor_mongodb.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.odogwudev.user_authentication_compose_ktor_mongodb.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.JavaNetCookieJar
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.net.CookieManager
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@OptIn(ExperimentalSerializationApi::class)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideCookiesManager(): CookieManager {// it would be used to attached cookie to each and every request to our backend server
        return CookieManager()
    }

    @Provides
    @Singleton
    fun provideHttpCLient(cookieManager: CookieManager): OkHttpClient {
        return OkHttpClient().newBuilder().readTimeout(15, TimeUnit.SECONDS)
            .cookieJar(JavaNetCookieJar(cookieManager)).build()
    }

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(contentType)).build()
    }
}