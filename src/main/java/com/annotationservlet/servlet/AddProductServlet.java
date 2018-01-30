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
import java.math.BigDecimal;

@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {


        private ProductStorage productStorage = App2.getInstance().getStorage();

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/jsp/add-product.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            for(String paramName : req.getParameterMap().keySet()) {
                System.out.println(paramName + "=" + req.getParameter(paramName));
            }

            String ProductName = req.getParameter("ProductName").toString();

            BigDecimal ProductPrice = new BigDecimal(req.getParameter("ProductPrice"));

            Products product = new Products();
            product.setName(ProductName);
            product.setPrice(ProductPrice);

            productStorage.add(product);

            resp.sendRedirect("/allP");
        }
    }

