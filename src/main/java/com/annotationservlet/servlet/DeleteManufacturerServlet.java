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
import java.sql.SQLException;
import java.util.UUID;

@WebServlet("/delete-manufacturer")
public class DeleteManufacturerServlet  extends HttpServlet {

    private ManufacturerStorage manufacturerStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manufacturerId = req.getParameter("manufacturerId");

        Manufacturer manufacturer = null;
        try {
            manufacturer = manufacturerStorage.get(UUID.fromString(manufacturerId));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            manufacturerStorage.delete(manufacturer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/allM");
    }
}
