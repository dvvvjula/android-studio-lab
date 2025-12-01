package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class BatteryReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);

        StringBuilder msg = new StringBuilder();
        if (plugged > 0) {
            msg.append("Telefon podłączony do zasilania, bateria: ").append(level).append("%");
            if (level == 100) {
                msg.append("\nBateria pełna! Możesz odłączyć ładowarkę.");
            }
        } else {
            msg.append("Telefon niepodłączony do zasilania, bateria: ").append(level).append("%");
            if (level < 10) {
                msg.append("\nPodłącz telefon do zasilania - bateria bardzo niska!");
            } else if (level == 100) {
                msg.append("\nBateria pełna.");
            }
        }

        MainActivity.updateText(msg.toString());
    }
}




