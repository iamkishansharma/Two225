package com.ks.two225;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import static android.content.ContentValues.TAG;

public class MyJobService extends JobService {

    public static final int notification_ID = 10;
    public static final String myKey = "Remote Key";

    @Override
    public boolean onStartJob(JobParameters params) {
        showNotification("Kishan","Sharma");
        Log.i(TAG,"onStartJob()..................JOB START");
//        Intent intent = new Intent(MyJobService.this, AlarmManagerBroadcast.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(MyJobService.this, 123, intent, 0);
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        Toast.makeText(MyJobService.this, "Alarm Set", Toast.LENGTH_LONG).show();

        return true;
    }


    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "OnStopJob.......................JOB STOP");
        return true;
    }

    private void showNotification(String title, String task){
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(title, task, NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext(),"inducesmile")
                .setContentTitle(title)
                .setContentText(task)
                .setColor(getColor(R.color.colorAccent))
                .setSmallIcon(R.drawable.ic_pan_tool_black_24dp);
        notificationManager.notify(1, notification.build());
    }
}
