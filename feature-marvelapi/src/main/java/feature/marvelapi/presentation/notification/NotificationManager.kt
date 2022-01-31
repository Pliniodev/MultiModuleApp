package feature.marvelapi.presentation.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import feature.marvelapi.R
import okhttp3.internal.notify

class NotificationManager(context: Context) {

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(context)
        } else {
            createDefaultNotification(context)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(context: Context) {

        val name = context.getString(R.string.channel_name)
        val descriptionText = context.getString(R.string.channel_description)
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(DEFAULT_CHANNEL_ID, name, importance).apply {
            description = descriptionText
        }

        val notificationMn: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationMn.createNotificationChannel(channel)
        notificationMn.notify()
    }

    private fun createDefaultNotification(context: Context) {
        NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_characters_bottom_nav)
            .setContentTitle("character added")
            .setContentText("The iron man has ...")
            .setStyle(
                NotificationCompat.BigTextStyle().bigText("The iron man has landed on your phone")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
    }

    companion object {
        const val DEFAULT_CHANNEL_ID = "Marvel notification"
    }
}