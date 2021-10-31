package feature.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECTION_TIMEOUT: Long = 60000L
private const val baseUrl: String = "https://rickandmortyapi.com"
private const val dogsAuth: String = "54985b8c-d100-4b7a-9032-4c4feea147a4"

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

/**
 * On Work
 */
// object BuildRetrofit {
//    operator fun invoke(apiBaseUrl: String, okHttpClient: OkHttpClient): Retrofit =
//        with(Retrofit.Builder()) {
//            baseUrl(apiBaseUrl)
//            client(okHttpClient)
//            addConverterFactory(GsonConverterFactory.create())
//            build()
//        }
// }

private class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", dogsAuth)
        return chain.proceed(requestBuilder.build())
    }
}

fun provideOkHttpClientAuthDogs(): OkHttpClient {
    val interceptor = HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .addNetworkInterceptor(interceptor)
        .addInterceptor(interceptor)
        .addInterceptor(AuthInterceptor())

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

fun provideRetrofitDogs(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://api.thedogapi.com/v1")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
