package com.bicycleshop.arcticfox.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.bicycleshop.arcticfox.DAO.PartDAO;
import com.bicycleshop.arcticfox.DAO.ProductDAO;
import com.bicycleshop.arcticfox.Entity.Part;
import com.bicycleshop.arcticfox.Entity.Product;

@Database(entities = {Product.class, Part.class}, version = 2)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();

    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BicycleDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    BicycleDatabaseBuilder.class, "mybicycleDatabase.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
