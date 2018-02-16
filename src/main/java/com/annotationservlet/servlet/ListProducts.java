package com.annotationservlet.servlet;


import com.annotationservlet.App;
import com.annotationservlet.App2;
import com.annotationservlet.entity.Manufacturer;
import com.annotationservlet.entity.Products;
import com.annotationservlet.storage.ManufacturerStorage;
import com.annotationservlet.storage.ProductStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/allP")
public class ListProducts extends HttpServlet {
    private ProductStorage productStorage = App2.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Products> products = productStorage.listAllProducts();

        req.setAttribute("product", products);
        req.getRequestDispatcher("/jsp/list-products.jsp").forward(req, resp);
    }
}
