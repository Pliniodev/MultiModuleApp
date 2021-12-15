package feature.network.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT: Long = 60000L

fun provideOkHttpClientAuthDogs(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(interceptor)
        .addInterceptor(interceptor)
        .addInterceptor(DogsInterceptor())

    return client.build()
}

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

fun provideOkHttpClientMarvelApi(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(interceptor)
        .addInterceptor(interceptor)
        .addInterceptor(MarvelApiInterceptor())

    return client.build()
}

fun provideOkHttpClientAuthNewsApi(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(interceptor)
        .addInterceptor(interceptor)
        .addInterceptor(NewsApiInterceptor())

    return client.build()
}
