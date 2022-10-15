package com.bicycleshop.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bicycleshop.arcticfox.Database.BicycleRepository;
import com.bicycleshop.arcticfox.Entity.Product;
import com.bicycleshop.arcticfox.R;

public class PartList extends AppCompatActivity {
    EditText editName;
    EditText editPrice;
    String name;
    Double price;
    int productID;
    BicycleRepository repo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list);
        editName = findViewById(R.id.editProductName);
        editPrice = findViewById(R.id.editProductPrice);
        productID = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        price = getIntent().getDoubleExtra("price", -1.0);
        editName.setText(name);
        editPrice.setText(Double.toString(price));

    }

    public void saveButton(View view) {
        Product product;
        if (productID == -1) {
            int newID = repo.getAllProducts().get(repo.getAllProducts().size() -1).getProductID() + 1;
            product = new Product(newID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
            repo.insert(product);
        }
        else {
            product = new Product(productID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
            repo.update(product);
        }
    }
}