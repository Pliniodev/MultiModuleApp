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

data class ErrorResponse(val code: Int, val message: String?) {
    companion object {
        val EMPTY_API_ERROR = ErrorResponse(-1, null)
    }
}
