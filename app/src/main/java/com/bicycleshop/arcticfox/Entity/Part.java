package com.bicycleshop.arcticfox.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "parts")
public class Part {
    @PrimaryKey(autoGenerate = true)
    private int partID;
    private int partName;
    private double price;

    public Part(int partID, int partName, double partPrice) {
        this.partID = partID;
        this.partName = partName;
        this.price = partPrice;
    }

    //TODO: this ctor was not in the tutorial
    public Part() {
    }

    @Override
    public String toString() {
        return "Part{" +
                "partID=" + partID +
                ", partName=" + partName +
                ", partPrice=" + price +
                '}';
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public int getPartName() {
        return partName;
    }

    public void setPartName(int partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
