package feature.commons.utils.saferequest

import com.google.gson.Gson
import retrofit2.HttpException

internal fun convertErrorBody(throwable: HttpException): ErrorResponse? {
    try {
        val errorJsonString = throwable.response()?.errorBody()?.string()
        return Gson().fromJson(errorJsonString, ErrorResponse::class.java)
    } catch (exception: Exception) {
        null
    }
    return ErrorResponse.EMPTY_API_ERROR
}