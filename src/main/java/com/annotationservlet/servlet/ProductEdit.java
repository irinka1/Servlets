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
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.UUID;





@WebServlet("/edit-product")
public class ProductEdit extends HttpServlet {

    private ProductStorage productStorage = App2.getInstance().getStorage();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");

        Products products = productStorage.get(UUID.fromString(productId));
        req.setAttribute("productName", products.getName());
        req.setAttribute("productId", products.getId());
        req.setAttribute("productPrice", products.getPrice());
        req.getRequestDispatcher("/jsp/edit-product.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        UUID productId = UUID.fromString(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        BigDecimal productPrice = new BigDecimal(req.getParameter("productPrice"));


        Products product = new Products();
        product.setId(productId);
        product.setName(productName);
        product.setPrice(productPrice);
        productStorage.update(product);

        resp.sendRedirect("/allP");

        out.close();
    }

}
