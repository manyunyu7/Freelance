package com.litziy.kawalcovid.notification_manager;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.litziy.kawalcovid.R;

public class ReminderReceiver extends BroadcastReceiver {

    public static final String EXTRA_MESSAGE = "message";
    public static final int ID_REPEATING = 999;

    @Override
    public void onReceive(Context context, Intent intent) {

    }


    public void setRepeatingAlarm(Context context, String message) {

        String channelId = "Channel_3";
        String channelName = "Litziychannel";

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ReminderReceiver.class);
        intent.putExtra(EXTRA_MESSAGE, message);

        NotificationManager notificationManagerCompat = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_baseline_security_24)
                .setContentTitle("Tips Kesehatan dari Kawal Covid : ")
                .setColor(ContextCompat.getColor(context, android.R.color.transparent))
                .setContentText(message)
                .setSound(alarmSound);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.enableVibration(true);
            builder.setChannelId(channelId);
            notificationManagerCompat.createNotificationChannel(channel);
        }

        Notification notification = builder.build();
        notificationManagerCompat.notify(999, notification);

    }


}
