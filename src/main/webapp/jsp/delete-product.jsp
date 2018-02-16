<%--
  Created by IntelliJ IDEA.
  User: i
  Date: 16.02.2018
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 style="font-weight: bold;">Deleting Product</h2>

<form action="/delete-product" method="POST">
    <h3>Manufacturer's Name</h3>

    <input type="hidden" name="productId" value="<%=request.getAttribute("productId")%>">

    <input type="text" name="productName" value="<%=request.getAttribute("productName")%>"/>


    <input type="submit" value="Delete Product"/>
</form>

<a href="/allP">Product List</a>

