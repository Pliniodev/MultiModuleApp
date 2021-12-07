package feature.commons.utils.saferequest

data class ErrorResponse(val code: Int, val message: String?) {
    companion object {
        val EMPTY_API_ERROR = ErrorResponse(-1, null)
    }
}
