package com.bicycleshop.arcticfox.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import kotlinx.coroutines.channels.ActorKt;

@Entity(tableName = "products")
public class Product {

    public Product(int productID, String productName, double productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @PrimaryKey(autoGenerate = true)
    private int productID;

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    private String productName;
    private double productPrice;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
