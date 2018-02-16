<%--
  Created by IntelliJ IDEA.
  User: i
  Date: 24.01.2018
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<h2 style="font-weight: bold;">Deleting Manufacturer</h2>

<form action="/delete-manufacturer" method="POST">
    <h3>Manufacturer's Name</h3>

    <input type="hidden" name="manufacturerId" value="<%=request.getAttribute("manufacturerId")%>">

    <input type="text" name="ManufacturerName" value="<%=request.getAttribute("ManufacturerName")%>"/>


    <input type="submit" value="Delete Manufacturer"/>
</form>

<a href="/allM">Manufacturer List</a>
