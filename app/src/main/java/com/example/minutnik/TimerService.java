package com.example.minutnik;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TimerService extends Service {

    private static final String TAG = "TimerService";
    private boolean running = false;
    private Thread timerThread;
    private int time = 60; // czas startowy w sekundach

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        running = true;

        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running && time > 0) {
                    try {
                        Log.d(TAG, "Pozostało: " + time + " s");
                        Thread.sleep(1000);
                        time--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (time == 0) {
                    Log.d(TAG, "Czas minął!");
                    stopSelf();
                }
            }
        });

        timerThread.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        running = false;
        time = 60;
        Log.d(TAG, "Minutnik wyzerowany");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
