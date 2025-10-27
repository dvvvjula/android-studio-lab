package com.example.programkalkulator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RozszerzoneFunkcjeActivity extends AppCompatActivity {

    EditText pierwszaCyfra, drugaCyfra;
    Button dodawanie, odejmowanie, mnozenie, dzielenie, powrot, pierwiastkowanie, potegowanie, silnia;
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozszerzone_funkcje);

        // podłączenie widoków
        pierwszaCyfra = findViewById(R.id.pierwszaCyfra);
        drugaCyfra = findViewById(R.id.drugaCyfra);
        dodawanie = findViewById(R.id.dodawanie);
        odejmowanie = findViewById(R.id.odejmowanie);
        mnozenie = findViewById(R.id.mnozenie);
        dzielenie = findViewById(R.id.dzielenie);
        powrot = findViewById(R.id.powrot);
        pierwiastkowanie = findViewById(R.id.pierwiastkowanie);
        potegowanie = findViewById(R.id.potegowanie);
        silnia = findViewById(R.id.silnia);
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

        pierwiastkowanie.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            if (a < 0) {
                wynik.setText("Nie można pierwiastkować liczby ujemnej!");
                return;
            }
            wynik.setText(String.valueOf(Math.sqrt(a)));
        });

        potegowanie.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            double b = getNumber(drugaCyfra);
            wynik.setText(String.valueOf(Math.pow(a, b)));
        });

        silnia.setOnClickListener(v -> {
            double a = getNumber(pierwszaCyfra);
            if (a < 0 || a != Math.floor(a)) {
                wynik.setText("Silnia tylko dla liczb całkowitych ≥ 0!");
                return;
            }
            long result = 1;
            for (int i = 1; i <= (int) a; i++) {
                result *= i;
            }
            wynik.setText(String.valueOf(result));
        });

        powrot.setOnClickListener(v -> {
            Intent intent = new Intent(RozszerzoneFunkcjeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private double getNumber(EditText editText) {
        String text = editText.getText().toString();
        if (text.isEmpty()) {
            wynik.setText("Wpisz liczbę!");
            return -1;
        }
        return Double.parseDouble(text);
    }
}
