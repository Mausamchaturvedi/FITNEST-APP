package com.example.fit_nest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class ReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String channelId = "fitnest_reminder_channel";

        NotificationManager notificationManager =
                (NotificationManager)
                        context.getSystemService(Context.NOTIFICATION_SERVICE);

        // 🔥 ALARM SOUND
        Uri soundUri =
                RingtoneManager.getDefaultUri(
                        RingtoneManager.TYPE_RINGTONE
                );

        // OPEN REMINDER ACTIVITY WHEN CLICK
        Intent openIntent =
                new Intent(context, ReminderActivity.class);

        PendingIntent pendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        openIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT |
                                PendingIntent.FLAG_IMMUTABLE
                );

        // ANDROID 8+ CHANNEL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            AudioAttributes audioAttributes =
                    new AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_ALARM)
                            .build();

            NotificationChannel channel =
                    new NotificationChannel(
                            channelId,
                            "Workout Reminder",
                            NotificationManager.IMPORTANCE_HIGH
                    );

            channel.setDescription("Workout Reminder Alerts");

            // SOUND
            channel.setSound(soundUri, audioAttributes);

            // VIBRATION
            channel.enableVibration(true);

            channel.setVibrationPattern(
                    new long[]{
                            1000,
                            1000,
                            1000,
                            1000
                    }
            );

            notificationManager.createNotificationChannel(channel);
        }

        // BUILD NOTIFICATION
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, channelId)

                        .setSmallIcon(R.drawable.ic_launcher_foreground)

                        .setContentTitle("🏋 Workout Reminder")

                        .setContentText(
                                "Time for your workout 💪 Stay consistent!"
                        )

                        .setPriority(NotificationCompat.PRIORITY_MAX)

                        .setCategory(NotificationCompat.CATEGORY_ALARM)

                        .setSound(soundUri)

                        .setVibrate(
                                new long[]{
                                        1000,
                                        1000,
                                        1000,
                                        1000
                                }
                        )

                        .setContentIntent(pendingIntent)

                        .setAutoCancel(true)

                        .setDefaults(NotificationCompat.DEFAULT_ALL);

        // SHOW NOTIFICATION
        notificationManager.notify(100, builder.build());
    }
}