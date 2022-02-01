package feature.marvelapi.presentation.notification

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import feature.marvelapi.R
import okhttp3.internal.notify
import java.util.*

class MarvelNotificationManager {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationMn: NotificationManager =
                activity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val existingChannel = notificationMn.getNotificationChannel(DEFAULT_CHANNEL_ID)

            if (existingChannel == null) {

                val name = activity.getString(R.string.channel_name)
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val descriptionText = activity.getString(R.string.channel_description)
                val mChannel = NotificationChannel(DEFAULT_CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                notificationMn.createNotificationChannel(mChannel)
            }
        }
    }

    fun createDefaultNotification(context: Context) {
        val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
        builder.setSmallIcon(R.drawable.ic_characters_bottom_nav)
            .setContentTitle("character added")

        val notification = builder.setContentText("The iron man has ...")
            .setStyle(
                NotificationCompat.BigTextStyle().bigText("The iron man has landed on your phone")
            ).setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        val notificationMn = NotificationManagerCompat.from(context)
        val id = Random().nextInt()
        notificationMn.notify(id, notification)

    }

    companion object {
        const val DEFAULT_CHANNEL_ID = "Default marvel notification"
    }
}