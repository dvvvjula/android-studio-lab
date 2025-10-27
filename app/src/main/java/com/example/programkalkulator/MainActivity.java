package com.example.programkalkulator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText pierwszaCyfra, drugaCyfra;
    Button dodawanie, odejmowanie, mnozenie, dzielenie, rozszerzenie;
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // podlaczenie widokow
        pierwszaCyfra = findViewById(R.id.pierwszaCyfra);
        drugaCyfra = findViewById(R.id.drugaCyfra);
        dodawanie = findViewById(R.id.dodawanie);
        odejmowanie = findViewById(R.id.odejmowanie);
        mnozenie = findViewById(R.id.mnozenie);
        dzielenie = findViewById(R.id.dzielenie);
        rozszerzenie = findViewById(R.id.rozszerzenie);
        wynik = findViewById(R.id.wynik);

        dodawanie.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            double b = getNumber(drugaCyfra);
            wynik.setText(String.valueOf(a + b));
        });

        odejmowanie.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            double b = getNumber(drugaCyfra);
            wynik.setText(String.valueOf(a - b));
        });

        mnozenie.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            double b = getNumber(drugaCyfra);
            wynik.setText(String.valueOf(a * b));
        });

        dzielenie.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            double b = getNumber(drugaCyfra);
            if (b == 0) {
                wynik.setText("Nie można dzielić przez 0!");
                return;
            }
            wynik.setText(String.valueOf(a / b));
        });

        // rozszerzone funkcje -> przejscie na nowe activity
        rozszerzenie.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RozszerzoneFunkcjeActivity.class);
            startActivity(intent);
        });

    }

    private double getNumber(EditText editText){
        String text = editText.getText().toString();
        if (text.isEmpty()){
            wynik.setText("Wpisz liczbę!");
            return -1;
        }
        return Double.parseDouble(text);
    }


}