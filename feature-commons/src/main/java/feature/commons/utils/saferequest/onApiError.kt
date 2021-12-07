package feature.commons.utils.saferequest

import android.content.Context
import feature.feature_commons.R

fun onApiError(context: Context, error: ErrorResponse?): String {
    return error?.message?.let { error.message } ?: genericApiError(context, error)
}

private fun genericApiError(context: Context, error: ErrorResponse?) =
    when (error?.code) {
        in 400..499 -> context.getString(R.string.error_400)
        else -> context.getString(R.string.error_500)
    }
