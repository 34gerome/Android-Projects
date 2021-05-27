package com.example.myapplication.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myapplication.R
import com.example.myapplication.ui.main.view.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {

    val abc = "MyFirebaseMessaging"
    private val TAG = "abc"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onNewToken(token: String) {
        super.onNewToken(token)

        FirebaseMessaging.getInstance().token.result
        Log.d(TAG, "onNewToken: NewToken: $token")
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(message: RemoteMessage) {
      /*  if (message.data != null){
            Log.d(abc, "Data: ${message.data.toString()}")
        }

        if (message.notification != null){
            Log.d(abc, "Notification: ${message.notification.toString()}")
        }*/


        val channelName = "location service"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channelId = "serviceeee"
        val channel = NotificationChannel(channelId, channelName, importance)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)

        var intent = Intent(this, MainActivity::class.java)
        var pendingIntent = PendingIntent.getActivity(this, 22, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, channelId)
        val notification: Notification =
            builder
                .setOngoing(true)
              //  .setContentInfo("Background location service is running")
                .setContentTitle(message.data.get("title"))
                .setContentText(message.data.get("body"))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setCategory(Notification.CATEGORY_SERVICE)
                .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
                .build()

        var nMC = NotificationManagerCompat.from(applicationContext)
        nMC.notify(123,notification)

    }

}