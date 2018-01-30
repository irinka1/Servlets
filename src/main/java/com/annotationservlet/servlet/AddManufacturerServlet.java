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

@WebServlet("/add-manufacturer")
public class AddManufacturerServlet extends HttpServlet {

    private ManufacturerStorage manufacturerStorage = App.getInstance().getStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add-manufacturer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        for(String paramName : req.getParameterMap().keySet()) {
            System.out.println(paramName + "=" + req.getParameter(paramName));
        }

        String ManufacturerName = req.getParameter("ManufacturerName").toString();

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(ManufacturerName);


        try {
            manufacturerStorage.add(manufacturer);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("/allM");
    }
}
