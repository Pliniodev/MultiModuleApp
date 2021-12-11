package feature.network.retrofit

import feature.network.constants.Authorization
import feature.network.constants.MarvelHeader
import okhttp3.Interceptor
import okhttp3.Response

internal class DogsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", Authorization.dogsAuth)
        return chain.proceed(requestBuilder.build())
    }
}

internal class NewsApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", Authorization.newsApiAuth)
        return chain.proceed(requestBuilder.build())
    }
}

internal class MarvelApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", MarvelHeader.publicKey)
        requestBuilder.addHeader("Authorization", MarvelHeader.ts)
        requestBuilder.addHeader("Authorization", MarvelHeader.hash)
        return chain.proceed(requestBuilder.build())
    }
}
