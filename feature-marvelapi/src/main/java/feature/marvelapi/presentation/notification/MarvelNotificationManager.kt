package feature.marvelapi.presentation.notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import feature.marvelapi.R
import feature.marvelapi.presentation.activity.MarvelHomeActivity
import okhttp3.internal.notify
import java.util.*

class MarvelNotificationManager  {

    @RequiresApi(Build.VERSION_CODES.O)
    fun createNotificationChannel(activity: Activity) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationMn: NotificationManager =
                activity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val existingChannel = notificationMn.getNotificationChannel(DEFAULT_CHANNEL_ID)

            if (existingChannel == null) {

                val name = activity.getString(R.string.channel_name)
                val importance = NotificationManager.IMPORTANCE_HIGH
                val descriptionText = activity.getString(R.string.channel_description)
                val mChannel = NotificationChannel(DEFAULT_CHANNEL_ID, name, importance).apply {
                    description = descriptionText
                }
                notificationMn.createNotificationChannel(mChannel)
            }
        }
    }

    fun createDefaultNotification(context: Context, characterName : String) {

        val fullScreenIntent = Intent(context, MarvelHomeActivity::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(
            context,
            0,
            fullScreenIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)

        val notification = builder
            .setSmallIcon(R.drawable.ic_characters_bottom_nav)
            .setContentTitle(context.getString(R.string.notification_title))
            .setStyle(
                NotificationCompat.BigTextStyle().bigText("The $characterName has joined to your team")
            )
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setAutoCancel(true)
            .setContentIntent(fullScreenPendingIntent)

            /**
             * This attribute 'setFullScreenIntent' makes the notification appears in
             * the screen while the user don`t dismiss it manually
             */
//            .setFullScreenIntent(fullScreenPendingIntent, true)
            .build()

        val notificationMn = NotificationManagerCompat.from(context)
        val id = Random().nextInt()
        notificationMn.notify(id, notification)
    }

    companion object {
        const val DEFAULT_CHANNEL_ID = "Default marvel notification"
    }
}