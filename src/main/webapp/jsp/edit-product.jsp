<%--
  Created by IntelliJ IDEA.
  User: i
  Date: 16.02.2018
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 style="font-weight: bold;">Edit Product</h2>

<form action="/edit-product" method="POST">
    <h3>Product's Name</h3>

    <input type="hidden" name="productId" value="<%=request.getAttribute("productId")%>">
    <input type="text" name="productName" value="<%=request.getAttribute("productName")%>"/>
    <input type="text" name="productPrice" value="<%=request.getAttribute("productPrice")%>"/>

    <input type="submit" value="Save Product"/>
</form>

<a href="/allP">Product's List</a>
<a href="/allM">Manufacturer's List</a>