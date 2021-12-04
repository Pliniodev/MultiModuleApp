package feature.commons.utils

data class ErrorResponse(val code: Int, val message: String?) {
    companion object {
        val EMPTY_API_ERROR = ErrorResponse(-1, null)
    }
}
