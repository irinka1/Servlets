package com.annotationservlet.storage;

import com.annotationservlet.entity.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

public class HibernateManufacturerStorage implements ManufacturerStorage {

    private SessionFactory sessionFactory;



    public HibernateManufacturerStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    public Manufacturer add(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manufacturer);
        transaction.commit();
        session.close();
        return manufacturer;
    }

    public void delete(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(manufacturer);
        transaction.commit();
        session.close();
    }

    public Manufacturer get(UUID manufacturerId) {
        Manufacturer manufacturer = null;
        Session session = sessionFactory.openSession();
        manufacturer = (Manufacturer) session.get(Manufacturer.class, manufacturerId);
        session.close();
        return manufacturer;
    }

    public List<Manufacturer> listAllManufacturer() {
        Session session = sessionFactory.openSession();
        List<Manufacturer> manufacturers =  (List<Manufacturer>) session.createQuery("from Manufacturer").list();
        session.close();
        return manufacturers;
    }

    public Manufacturer update(Manufacturer manufacturer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(manufacturer);
        transaction.commit();
        session.close();
        return manufacturer;
    }

    public static void main(String[] args) {

    }
}