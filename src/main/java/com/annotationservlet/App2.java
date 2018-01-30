package com.annotationservlet;


import com.annotationservlet.entity.Products;
import com.annotationservlet.storage.HibernateProductsStorage;
import com.annotationservlet.storage.ProductStorage;

public class App2 {

    private static final App2 INSTANCE = new App2();

    private ProductStorage manufacturerStorage = new HibernateProductsStorage();

    private App2() {
    }

    public static App2 getInstance() {
        return INSTANCE;
    }


    public ProductStorage getStorage() {
        return manufacturerStorage;
    }

    public static void main(String[] args) {
        HibernateProductsStorage hibernateManufacturerStorage = new HibernateProductsStorage();
        Products products = new Products();
        //System.out.println(hibernateManufacturerStorage.get());

        //System.out.println(manufacturer.getName());
    }
}

