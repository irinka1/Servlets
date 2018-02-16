<%--
  Created by IntelliJ IDEA.
  User: i
  Date: 26.01.2018
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 style="font-weight: bold;">Adding Product</h2>

<form action="/add-product" method="POST">
    <h3>Product's NAME</h3>
    <input type="text" name="productName"/>

    <input type="text" name="productPrice"/>

    <input type="submit" value="Add Product"/>
</form>

<a href="/allP">Product's List</a>
