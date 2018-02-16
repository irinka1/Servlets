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
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.UUID;


@WebServlet("/edit-manufacturer")
public class ManufacturerEdit extends HttpServlet {

    private ManufacturerStorage manufacturerStorage = App.getInstance().getStorage();

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String manufacturerId = req.getParameter("manufacturerId");

       Manufacturer manufacturer = null;
       try {
           manufacturer = manufacturerStorage.get(UUID.fromString(manufacturerId));
       } catch (SQLException e) {
           e.printStackTrace();
       }

       req.setAttribute("manufacturerName", manufacturer.getName());
       req.setAttribute("manufacturerId", manufacturer.getId());

       req.getRequestDispatcher("/jsp/edit-manufacturer.jsp").forward(req, resp);
   }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();

        UUID manufacturerId = UUID.fromString(req.getParameter("manufacturerId"));
        String manufacturerName = req.getParameter("manufacturerName");


        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(manufacturerId);
        manufacturer.setName(manufacturerName);
        try {
            manufacturerStorage.update(manufacturer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/allM");

        out.close();
    }

}
