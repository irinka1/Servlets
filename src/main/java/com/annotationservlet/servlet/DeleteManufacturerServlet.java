package com.annotationservlet.servlet;

import com.annotationservlet.App;
import com.annotationservlet.entity.Manufacturer;
import com.annotationservlet.storage.ManufacturerStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/delete-manufacturer")
public class DeleteManufacturerServlet  extends HttpServlet {

    private ManufacturerStorage manufacturerStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufacturerId = req.getParameter("manufacturerId");

        System.out.println("Manufacturer ID <" + manufacturerId + ">");

        Manufacturer manufacturer = manufacturerStorage.get(UUID.fromString(manufacturerId));
        manufacturerStorage.delete(manufacturer);

        resp.sendRedirect("/all");
    }
}
