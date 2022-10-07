package com.bicycleshop.arcticfox.DAO;

import androidx.annotation.RequiresPermission;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.bicycleshop.arcticfox.Entity.Product;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ProductDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("SELECT * FROM products ORDER BY productID ASC")
    List<Product> getAllProducts();
}
