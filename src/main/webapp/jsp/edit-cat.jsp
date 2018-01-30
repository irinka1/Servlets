<%@ page import="com.annotationservlet.entity.Cat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Редактирование кота</h2>

<form action="/edit-cat" method="POST">
    <h3>Имя кота</h3>

    <input type="hidden" name="catId" value="<%=request.getAttribute("catId")%>">

    <input type="text" name="catName" value="<%=request.getAttribute("catName")%>"/>

    <br/>

    <input type="checkbox" name="catSex" checked="<%=request.getAttribute("catSex")%>" /> <span>Мужчина</span>

    <br/>

    <input type="submit" value="Сохранить кота"/>
</form>

<a href="/all">Список котов</a>