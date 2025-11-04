package com.example.profilepracticeapp.data.service
import android.R.attr.start
import android.app.Service
import android.content.Intent
import android.os.IBinder;
import androidx.core.app.NotificationCompat
import com.example.profilepracticeapp.R


class RandomService: Service() {

    // IBinder used to connect multiple apps to this particular service
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


    // Needs an intent to start the service
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()

        }

        return super.onStartCommand(intent, flags, startId)
    }

    // To start, it needs to have persisitent nullification so it can inform the user during work
    private fun start(){

        // The context is now limited to the lifecycle of the service cause it works like an activity
        // Needs a (context, channel id)
        val notification = NotificationCompat.Builder(this, "running_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Run Is Active")
            .setContentText("Timer: XX:XX")
            .build()

        // If you need to update the notification, you will create a new notification each
        // time with new info to update

        startForeground(1, notification)
    }

    // Enum is used to call the actions your service will perform
    enum class Actions{

        START, STOP
    }

}