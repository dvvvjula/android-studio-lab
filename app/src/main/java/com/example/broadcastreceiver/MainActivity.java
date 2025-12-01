package com.example.broadcastreceiver;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_ACTION = "com.example.broadcastreceiver.MY_EVENT";

    private TextView textView;
    private static TextView staticTextView;

    private CustomReceiver customReceiver = new CustomReceiver();
    private SystemReceiver systemReceiver = new SystemReceiver();
    private BatteryReceiver batteryReceiver = new BatteryReceiver();

    private Handler dndHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        staticTextView = textView;

        Button button = findViewById(R.id.buttonSend);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(CUSTOM_ACTION);
            intent.setPackage(getPackageName());
            sendBroadcast(intent);
            Log.d("MainActivity", "Broadcast wysłany!");
        });

        // Custom broadcast
        IntentFilter filter = new IntentFilter(CUSTOM_ACTION);
        registerReceiver(customReceiver, filter, Context.RECEIVER_NOT_EXPORTED);

        // System broadcast (wifi/lte, airplane, ringer)
        IntentFilter systemFilter = new IntentFilter();
        systemFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        systemFilter.addAction("android.media.RINGER_MODE_CHANGED");
        systemFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(systemReceiver, systemFilter, Context.RECEIVER_NOT_EXPORTED);

        // Battery broadcast
        IntentFilter batteryFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, batteryFilter, Context.RECEIVER_NOT_EXPORTED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(customReceiver);
        unregisterReceiver(systemReceiver);
        unregisterReceiver(batteryReceiver);
        dndHandler.removeCallbacksAndMessages(null);
    }

    // Służy do zdalnej zmiany na TextView przez BroadcastReceivery
    public static void updateText(final String msg) {
        if (staticTextView != null) {
            staticTextView.post(() -> staticTextView.setText(msg));
        }
    }
}









