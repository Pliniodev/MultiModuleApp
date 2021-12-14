package feature.commons.utils

import android.app.Activity
import android.content.Intent
import java.io.Serializable

/**
 * To understand the use of these functions, please go to screens navigation example or read the
 * book "Kotlin in action" from the page 317 until 325
 */

// Navigate to other activity
inline fun <reified T : Activity> Activity.navigateTo() {
    startActivity(Intent(this, T::class.java))
}

// Navigate to other activity, and allows the creation of personalized intents config.
inline fun <reified T : Activity> Activity.navigateAndAggregate(intentConfig: Intent.() -> Unit) {
    startActivity(Intent(this, T::class.java).apply(intentConfig))
}

// Navigate to other activity, and allows aggregate an serialized object.
inline fun <reified T : Activity, V> Activity.navigateAndAggregate(intentName: String, send: V) {
    startActivity(
        Intent(this, T::class.java)
            .putExtra(intentName, send as? Serializable)
    )
}
