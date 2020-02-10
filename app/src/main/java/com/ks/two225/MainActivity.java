package com.ks.two225;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    JobScheduler jobScheduler;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startJob(View view){
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(this,MyJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(123,componentName);
        builder.setMinimumLatency(1*1000);
        builder.setOverrideDeadline(3*1000);
        builder.setPersisted(true);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        builder.setRequiresCharging(false);
        jobScheduler.schedule(builder.build());
    }

    public void stopJob(View view){
        if(jobScheduler != null){
            jobScheduler.cancel(123);
            jobScheduler = null;
            Toast.makeText(MainActivity.this, ".....Job Called.....", Toast.LENGTH_LONG).show();
        }
    }

    public void suruHoja(View view) {
        startActivity(new Intent(this,DateTimeActivity.class));
    }
}
