<%@ page import="com.annotationservlet.entity.Cat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Edit Manufacturer</h2>

<form action="/edit-manufacturer" method="POST">
    <h3>Manufacturer's Name</h3>

    <input type="hidden" name="manufacturerId" value="<%=request.getAttribute("manufacturerId")%>">

    <input type="text" name="manufacturerName" value="<%=request.getAttribute("manufacturerName")%>"/>

     <input type="submit" value="Save Manufacturer"/>
</form>

<a href="/all">Manufacturer's List</a>