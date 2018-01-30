

<%@ page contentType="text/html; charset=UTF-8" %>

<h2 style="font-weight: bold;">Adding Manufacturer</h2>

<form action="/add-manufacturer" method="POST">
    <h3>Manufacture's NAME</h3>
    <input type="text" name="ManufacturerName"/>

    <input type="submit" value="Add manufacturer"/>
</form>

<a href="/all">Manufacturer List</a>