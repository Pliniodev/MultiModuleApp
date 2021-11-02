package feature.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BuildRetrofit {
    operator fun invoke(apiBaseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        with(Retrofit.Builder()) {
            baseUrl(apiBaseUrl)
            client(okHttpClient)
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
}
