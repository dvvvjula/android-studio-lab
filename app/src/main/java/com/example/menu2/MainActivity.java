package com.example.menu2;
import android.content.Context;
import android.media.AudioManager;
import android.provider.Settings;
import android.widget.TextView;
import android.Manifest;
import android.app.NotificationManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView autorTextView;
    private static final int ID_MUTE = 1;
    private static final int ID_INFO = 2;
    private static final int ID_EXIT = 3;
    private static final int ID_RUN = 4;
    private static final int ID_RUN_MAPS = 5;
    private static final int ID_RUN_BROWSER = 6;

    private static final int REQUEST_PERMISSION_DO_NOT_DISTURB = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(Menu.NONE, ID_MUTE, Menu.NONE, "Wycisz telefon");
        menu.add(Menu.NONE, ID_INFO, Menu.NONE, "Wyświetl informacje o autorze");
        menu.add(Menu.NONE, ID_EXIT, Menu.NONE, "Wyłącz aplikację");

        SubMenu runSubMenu = menu.addSubMenu(Menu.NONE, ID_RUN, Menu.NONE, "Uruchom");
        runSubMenu.add(Menu.NONE, ID_RUN_MAPS, Menu.NONE, "Google Maps");
        runSubMenu.add(Menu.NONE, ID_RUN_BROWSER, Menu.NONE, "Google Browser");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case ID_MUTE:
                mutePhone();
                return true;

            case ID_INFO:
                showAuthorDialog();
                return true;

            case ID_EXIT:
                finish();
                return true;

            case ID_RUN_MAPS:
                openGoogleMaps();
                return true;

            case ID_RUN_BROWSER:
                openBrowser();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showAuthorDialog() {
        final EditText input = new EditText(this);
        input.setHint("Wpisz informacje o autorze");

        new AlertDialog.Builder(this)
                .setTitle("O autorze")
                .setView(input)
                .setPositiveButton("OK", (dialog, which) -> {
                    String userInput = input.getText().toString();
                    TextView autorTextView = findViewById(R.id.autorTextView);
                    autorTextView.setText("Autorem aplikacji jest " + userInput);
                })
                .setNegativeButton("Anuluj", null)
                .show();
    }

    private void openGoogleMaps() {
        Uri generalMapsUri = Uri.parse("geo:0,0?q=");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, generalMapsUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            String url = "https://www.google.com/maps/";
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(browserIntent);
        }
    }

    private void openBrowser() {
        String url = "https://www.google.com";
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    private void mutePhone() {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (audioManager != null && notificationManager != null) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !notificationManager.isNotificationPolicyAccessGranted()) {

                Toast.makeText(this, "Wymagane uprawnienie 'Nie przeszkadzać'. Nadaj dostęp.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                startActivity(intent);

                return;

            } else {
                audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);

                Toast.makeText(this, "Telefon wyciszony (Tryb Cichy)", Toast.LENGTH_SHORT).show();
            }
        }
    }

}