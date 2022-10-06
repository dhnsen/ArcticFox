package com.bicycleshop.arcticfox.Database;

import android.app.Application;

import com.bicycleshop.arcticfox.DAO.PartDAO;
import com.bicycleshop.arcticfox.DAO.ProductDAO;
import com.bicycleshop.arcticfox.Entity.Part;
import com.bicycleshop.arcticfox.Entity.Product;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BicycleRepository {
    private PartDAO mPartDAO;
    private ProductDAO mProductDAO;
    private ArrayList<Product> mAllProducts;
    private ArrayList<Part> mAllParts;

    private static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public BicycleRepository(Application application) {
        BicycleDatabaseBuilder db = BicycleDatabaseBuilder.getDatabase(application);
        mPartDAO = db.partDAO();
        mProductDAO = db.productDAO();
    }

    public void insert(Product product){
        databaseExecutor.execute(() ->{
            mProductDAO.insert(product);
        });
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void insert(Part part){
        mPartDAO.insert(part);
    }

}
