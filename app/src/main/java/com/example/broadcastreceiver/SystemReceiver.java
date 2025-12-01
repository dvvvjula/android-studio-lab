package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;

public class SystemReceiver extends BroadcastReceiver {

    private static final String TAG = "SystemReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        // Tryb samolotowy
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(action)) {
            boolean state = intent.getBooleanExtra("state", false);
            Log.d(TAG, "Status trybu samolotowego: " + (state ? "włączony" : "wyłączony"));
        }

        // Stan sieci: Wi-Fi oraz LTE — loguj zawsze!
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            boolean wifiConnected = false;
            boolean mobileConnected = false;

            if (cm != null) {
                Network[] networks = cm.getAllNetworks();
                for (Network network : networks) {
                    NetworkInfo info = cm.getNetworkInfo(network);
                    if (info != null && info.isConnected()) {
                        if (info.getType() == ConnectivityManager.TYPE_WIFI) wifiConnected = true;
                        if (info.getType() == ConnectivityManager.TYPE_MOBILE) mobileConnected = true;
                    }
                }
            }

            Log.d(TAG, "Status Wi-Fi: " + (wifiConnected ? "połączone" : "rozłączone"));
            Log.d(TAG, "Status LTE: " + (mobileConnected ? "połączone" : "rozłączone"));
        }

        // Można dodać tryb dźwięku jeśli chcesz — zostawiłem przykładowo (nie wykrywa DND!)
        if ("android.media.RINGER_MODE_CHANGED".equals(action)) {
            AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
            int mode = audioManager.getRingerMode();
            String status;
            if (mode == AudioManager.RINGER_MODE_SILENT) status = "Wyciszenie";
            else if (mode == AudioManager.RINGER_MODE_VIBRATE) status = "Wibracje";
            else if (mode == AudioManager.RINGER_MODE_NORMAL) status = "Normalny";
            else status = "Nieznany";
            Log.d(TAG, "Tryb dźwięku: " + status);
        }
    }
}








