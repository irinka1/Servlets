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

@WebServlet("/edit-manufacturer")
public class ManufacturerEdit extends HttpServlet {

    private ManufacturerStorage manufacturerStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //long manufacturerId = Long.parseLong(req.getParameter("manufacturerId"));
        String manufacturerId = req.getParameter("manufacturerId");
        Manufacturer manufacturer = manufacturerStorage.get(UUID.fromString(manufacturerId));

       // Manufacturer manufacturer = manufacturerStorage.get(manufacturerId);


        req.setAttribute("manufacturerName", manufacturer.getName());
        req.setAttribute("manufacturerId", manufacturer.getId());

        req.getRequestDispatcher("/jsp/edit-manufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WE ARE REALLY CLOSE!");
    }
}
