package feature.commons.utils.saferequest

import feature.feature_commons.R

fun onGenericApiError(result: Int): Int {
    return when (result) {
        400 ->  R.string.error_400
        404 ->  R.string.error_404
        else ->  R.string.generic_error
    }
}