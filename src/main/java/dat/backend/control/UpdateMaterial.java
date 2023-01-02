package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Material;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updatematerial", value = "/updatematerial")
public class UpdateMaterial extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    // METODE - parametres hentes fra JSP side og materialets data bliver opdateret i database ud fra materialets ID (materialID)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Material material = new Material(Integer.parseInt(request.getParameter("materialID")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("length")),
                request.getParameter("unit"),
                Double.parseDouble(request.getParameter("priceperunit")),
                0,
                request.getParameter("typename"));

        try {
            OrderFacade.updateMaterial(material, connectionPool);
        } catch (SQLException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("/navToMaterialList").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
