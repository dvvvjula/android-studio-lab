package com.example.listazakupow;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String name;

    public Product(String name) {
        this.name = name;
    }
}

