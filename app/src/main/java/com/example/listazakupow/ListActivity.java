package com.example.listazakupow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Executors;

public class ListActivity extends AppCompatActivity {

    private AppDatabase db;
    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        db = AppDatabase.getDatabase(this);
        productDao = db.productDao();

        TextView textList = findViewById(R.id.textList);
        Button btnBack = findViewById(R.id.btnBack);

        Executors.newSingleThreadExecutor().execute(() -> {
            List<Product> items = productDao.getAll();
            StringBuilder sb = new StringBuilder();
            for (Product p : items) {
                sb.append(p.name).append("\n");
            }
            runOnUiThread(() -> textList.setText(sb.toString()));
        });

        btnBack.setOnClickListener(v -> finish());
    }
}

