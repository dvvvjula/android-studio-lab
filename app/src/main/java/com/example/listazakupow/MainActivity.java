package com.example.listazakupow;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private ProductDao productDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(this);
        productDao = db.productDao();

        EditText editProduct = findViewById(R.id.editProduct);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnDeleteAll = findViewById(R.id.btnDeleteAll);
        Button btnShowList = findViewById(R.id.btnShowList);

        btnAdd.setOnClickListener(v -> {
            String name = editProduct.getText().toString();
            if (!name.isEmpty()) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    productDao.insert(new Product(name));
                });
                editProduct.setText("");
            }
        });

        btnDeleteAll.setOnClickListener(v -> {
            String name = editProduct.getText().toString();
            if (!name.isEmpty()) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    productDao.deleteByName(name);
                });
                editProduct.setText("");
            }
        });


        btnShowList.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ListActivity.class));
        });
    }
}