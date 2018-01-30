package com.annotationservlet;

import com.annotationservlet.entity.Manufacturer;
import com.annotationservlet.storage.*;

public class App {
    private static final App INSTANCE = new App();

    //private ICatStorage storage = new HibernateCatStorage();
    private ManufacturerStorage manufacturerStorage = new HibernateManufacturerStorage();

    private App() {
    }

    public static App getInstance() {
        return INSTANCE;
    }

   /* public ICatStorage getStorage() {
        return storage;
    }*/

    public ManufacturerStorage getStorage() {
        return manufacturerStorage;
    }

    public static void main(String[] args) {
        HibernateManufacturerStorage hibernateManufacturerStorage = new HibernateManufacturerStorage();
        Manufacturer manufacturer = new Manufacturer();
        //System.out.println(hibernateManufacturerStorage.get());

        //System.out.println(manufacturer.getName());
    }
}
