package com.example.przelicznikwalut;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ilePrzeliczyc;
    private TextView wynik;
    private Button buttonUsd, buttonEur, buttonChf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // podlaczenie widokow
        ilePrzeliczyc = findViewById(R.id.ilePrzeliczyc);
        wynik = findViewById(R.id.wynik);
        buttonUsd = findViewById(R.id.buttonUsd);
        buttonEur = findViewById(R.id.buttonEur);
        buttonChf = findViewById(R.id.buttonChf);

        // klikniecia przyciskow
        buttonUsd.setOnClickListener(v -> przelicz(3.99));
        buttonEur.setOnClickListener(v -> przelicz(4.32));
        buttonChf.setOnClickListener(v -> przelicz(4.53));
    }

    private void przelicz(double kurs) {
        String kwotaStr = ilePrzeliczyc.getText().toString();

        if (kwotaStr.isEmpty()) {
            wynik.setText("Wprowadź kwotę");
            return;
        }

        try {
            double kwota = Double.parseDouble(kwotaStr);
            double wynikPLN = kwota * kurs;
            wynik.setText(String.format("%.2f PLN", wynikPLN));
        } catch (NumberFormatException e) {
            wynik.setText("Nieprawidłowa liczba");
        }
    }
}