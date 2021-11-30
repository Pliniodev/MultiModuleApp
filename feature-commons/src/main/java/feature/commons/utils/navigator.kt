package feature.commons.utils

import android.app.Activity
import android.content.Intent

inline fun <reified T : Activity> Activity.navigateTo() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Activity.navigateToAndAggregate(intentConfig: Intent.() -> Unit) {
    startActivity(Intent(this, T::class.java).apply(intentConfig))
}
