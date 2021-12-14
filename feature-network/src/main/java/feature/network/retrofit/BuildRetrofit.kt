package feature.network.retrofit

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BuildRetrofit {
    operator fun invoke(apiBaseUrl: String, okHttpClient: OkHttpClient): Retrofit =
        with(Retrofit.Builder()) {
            baseUrl(apiBaseUrl)
            client(okHttpClient)
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
            build()
        }
}
