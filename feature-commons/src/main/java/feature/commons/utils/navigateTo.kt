package feature.commons.utils

import android.app.Activity
import android.content.Intent
import java.io.Serializable

inline fun <reified T : Activity> Activity.navigateTo() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : Activity> Activity.navigateToAndAggregate(
    dataName: String,
    sendingData: Any
) {
    startActivity(
        Intent(this, T::class.java).putExtra(dataName, Aggregator(sendingData))
    )
}

class Aggregator(
    val data: Any
) : Serializable