package com.jingsong.myservicetest.service;


import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyService extends Service {

    private static final String TAG = "ExampleService";
    private int mHour;
    private int mMinuts;
    private String hour;


    @Override
    public void onCreate() {
        Log.e(TAG, "ExampleService-onCreate");


        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        registerReceiver(receiver, filter);

        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "ExampleService-onStartCommand");
        hour = intent.getStringExtra("Hour");
        Log.e(TAG, "hour  = " + hour);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.e(TAG, "ExampleService-onStart");
        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "ExampleService-onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "ExampleService-onDestroy");
        super.onDestroy();
    }

    private final BroadcastReceiver receiver = new BroadcastReceiver() {

        private String tamp_hour;
        private String tamp_minuts;

        @Override
        public void onReceive(final Context context, Intent intent) {

            if (!(TextUtils.isEmpty(hour))) {
                String[] split = hour.split(",");

                tamp_hour = split[0];
                tamp_minuts = split[1];

            }

            String action = intent.getAction();
            if (action.equals(Intent.ACTION_TIME_TICK)) {

                //do what you want to do ...13

                String time1 = new SimpleDateFormat("HH:mm:ss").format(new Date());

                String[] split = time1.split(":");

                mHour = Integer.parseInt(split[0]);
                mMinuts = Integer.parseInt(split[1]);


                if (mHour == Integer.parseInt(tamp_hour) && (mMinuts == Integer.parseInt(tamp_minuts))) {

                    intent = new Intent(context, FileBrowserActivity.class);

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    context.startActivity(intent);


                }

            }
        }
    };

}