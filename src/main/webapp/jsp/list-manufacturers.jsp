<%@ page import="java.util.List" %>
<%@ page import="java.util.UUID" %>
<%@ page import="com.annotationservlet.entity.Manufacturer" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">All Manufacturers</h2>

<%
    List<Manufacturer> manufacturers = (List<Manufacturer>) request.getAttribute("manufacturer");


    for(Manufacturer manufacturer: manufacturers) {
        String link = manufacturer.getName();
        UUID id = manufacturer.getId();
        String strId = id.toString();

        out.println("<span>" + link + ", " + "</span>");
        out.println("<a href=\"/delete-manufacturer?manufacturerId=" + strId + "\"> Удалить </a>");
        out.println("<a style=\"background: red;\" href=\"/edit-manufacturer?manufacturerId=" + strId + "\"> Редактировать </a>");
        out.println("</br>");
    }

%>

<a href="/add-manufacturer">Add Manufacturer</a>