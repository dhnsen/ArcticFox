package com.bicycleshop.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bicycleshop.arcticfox.Database.BicycleRepository;
import com.bicycleshop.arcticfox.Entity.Part;
import com.bicycleshop.arcticfox.Entity.Product;
import com.bicycleshop.arcticfox.R;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EnterHere(View view) {
        Intent intent= new Intent(MainActivity.this, ProductList.class);
        startActivity(intent);
        BicycleRepository repo = new BicycleRepository(getApplication());
        Product product = new Product(1, "unicycle", 10.00);
        repo.insert(product);
        Part part = new Part(1, "wheel", 10.00, 1);
        repo.insert(part);
    }
}