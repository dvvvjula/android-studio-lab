package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class CustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (MainActivity.CUSTOM_ACTION.equals(intent.getAction())) {
            MainActivity.updateText("Odebrano własne zdarzenie!");
            Log.d("CustomReceiver", "Broadcast odebrany!");
        }
    }
}




