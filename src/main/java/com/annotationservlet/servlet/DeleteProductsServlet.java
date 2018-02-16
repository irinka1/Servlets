package com.annotationservlet.servlet;
import com.annotationservlet.App2;
import com.annotationservlet.entity.Products;
import com.annotationservlet.storage.ProductStorage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.UUID;

@WebServlet("/delete-product")
public class DeleteProductsServlet extends HttpServlet {
    private ProductStorage productStorage = App2.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");

        Products products = productStorage.get(UUID.fromString(productId));
           productStorage.delete(products);
           resp.sendRedirect("/allP");
    }
}
