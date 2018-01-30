package com.annotationservlet.storage;

import com.annotationservlet.entity.Products;

import java.util.List;
import java.util.UUID;

public interface ProductStorage {
    Products add(Products product) ;
    void delete(Products product);
    Products get(UUID productId);
    List<Products> listAllProducts();
    Products update(Products cat);
}

