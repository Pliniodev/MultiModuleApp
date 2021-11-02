package feature.retrofit

import feature.constants.Authorization
import okhttp3.Interceptor
import okhttp3.Response

internal class DogsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.addHeader("Authorization", Authorization.dogsAuth)
        return chain.proceed(requestBuilder.build())
    }
}
