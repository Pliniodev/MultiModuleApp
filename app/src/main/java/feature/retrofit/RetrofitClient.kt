package com.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT: Long = 60000L
private const val baseUrl: String = "https://rickandmortyapi.com"


fun provideOkHttpClient(): OkHttpClient {

    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(interceptor)
        .addInterceptor(interceptor)

    return client.build()
}

fun provideRetrofitRAM(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideRetrofitAdviceSlip(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.adviceslip.com/advice")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}