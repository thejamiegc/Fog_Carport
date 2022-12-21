package dat.backend.control.navigation;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name = "NavToEditMaterial", value = "/editmateriallist")
public class NavToEditMaterial extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int materialID = Integer.parseInt(request.getParameter("materialID"));

        try {
            Material material = OrderFacade.readMaterial(materialID,connectionPool);
            session.setAttribute("material",material);
        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/admin/editmaterial.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
