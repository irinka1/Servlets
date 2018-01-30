package com.annotationservlet.storage;

import com.annotationservlet.entity.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.UUID;

public class HibernateProductsStorage implements ProductStorage {

    private SessionFactory sessionFactory;

    public HibernateProductsStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Products add(Products product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        return product;
    }

    public void delete(Products product) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public Products get(UUID productId) {
        Products product = null;
        Session session = sessionFactory.openSession();
        product = (Products) session.get(Products.class, productId);
        session.close();
        return product;
    }

    public List<Products> listAllProducts() {
        Session session = sessionFactory.openSession();
        List<Products> products = session.createQuery("from product").list();
        session.close();
        return products;
    }

    public Products update(Products cat) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cat);
        transaction.commit();
        session.close();
        return cat;
    }

    public static void main(String[] args) {
        String uuidStr = "d95e7b1c-f3f7-4830-9dc0-fcf1b3a59bc9";
        HibernateProductsStorage productsStorage = new HibernateProductsStorage();

        Products cat = productsStorage.get(UUID.fromString(uuidStr));
        System.out.println(cat);
//
//        Cat cat = new Cat();
//        cat.setName("Max");
//        cat.setSex(true);
//
//        catStorage.add(cat);
//
//        UUID uuid = cat.getId();
//
//        System.out.println(uuid.toString());
//
//        List<Cat> cats = catStorage.listAllCats();
//
//        System.out.println("Cat count: " + cats.size());
//        for(Cat cat: cats) {
//            System.out.println(cat);
//        }

    }
}
