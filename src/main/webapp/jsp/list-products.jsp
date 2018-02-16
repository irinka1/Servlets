<%@ page import="com.annotationservlet.entity.Products" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %><%--
  Created by IntelliJ IDEA.
  User: i
  Date: 16.02.2018
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 style="font-weight: bold;">All Products</h2>

<%
    List<Products> products = (List<Products>) request.getAttribute("product");
    for(Products product: products) {
        String link = product.getName();
        BigDecimal price = product.getPrice();
        UUID id = product.getId();
        String strId = id.toString();

        out.println("<span>" + link + ", " + "</span>");
        out.println("<span>" + price + ", " + "</span>");
        out.println("<a href=\"/delete-product?productId=" + strId + "\"> Удалить </a>");
        out.println("<a style=\"background: red;\" href=\"/edit-product?productId=" + strId + "\"> Редактировать </a>");
        out.println("</br>");
    }

%>

<a href="/add-product">Add Product</a>