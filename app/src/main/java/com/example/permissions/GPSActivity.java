package com.example.permissions;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class GPSActivity extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_CODE = 2001;

    private TextView latView, lonView, providerView;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        latView = findViewById(R.id.lat);
        lonView = findViewById(R.id.lon);
        providerView = findViewById(R.id.provider);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (checkPermission()) {
            startGPS();
        } else {
            requestPermission();
        }
    }

    private boolean checkPermission() {
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                LOCATION_PERMISSION_CODE
        );
    }

    @SuppressLint("MissingPermission")
    private void startGPS() {
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,      // co 1 sekunda
                0,
                locationListener
        );
    }

    private final LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            latView.setText("Szerokość: " + location.getLatitude());
            lonView.setText("Długość: " + location.getLongitude());
            providerView.setText("Dostawca: " + location.getProvider());
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startGPS();
            } else {
                Toast.makeText(this, "Brak uprawnień GPS", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

