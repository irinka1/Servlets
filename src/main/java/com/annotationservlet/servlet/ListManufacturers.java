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
import java.util.List;

@WebServlet("/allM")
public class ListManufacturers extends HttpServlet  {
     private ManufacturerStorage manufacturerStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manufacturer> manufacturers = null;
        try {
            manufacturers = manufacturerStorage.listAllManufacturer();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("manufacturers", manufacturers);
        req.getRequestDispatcher("/jsp/list-manufacturers.jsp").forward(req, resp);
    }
}

