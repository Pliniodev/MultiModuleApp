package feature.newsapi.data

import feature.newsapi.data.response.EverythingResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsApiGateway {

    @GET("v2/everything")
    fun getNewsByQuery(
        @Query(
            value = "q",
            encoded = true
        ) query: String
    ): Observable<EverythingResponse>
}
