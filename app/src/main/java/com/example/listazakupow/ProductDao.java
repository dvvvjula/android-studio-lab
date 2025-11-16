package com.example.listazakupow;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert
    void insert(Product product);

    @Query("DELETE FROM products WHERE name = :name")
    void deleteByName(String name);

    @Query("DELETE FROM products")
    void deleteAll();

    @Query("SELECT * FROM products")
    List<Product> getAll();
}

