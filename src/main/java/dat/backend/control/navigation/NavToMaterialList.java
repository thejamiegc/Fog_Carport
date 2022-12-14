package dat.backend.control.navigation;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "navToMaterialList", value = "/navToMaterialList")
public class NavToMaterialList extends HttpServlet {
    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

//        List<Material> materialList;
//
//        try {
//            materialList = OrderFacade.create;
//            session.setAttribute("materialList",materialList);
//
//            request.getRequestDispatcher("WEB-INF/admin/materiallist.jsp").forward(request, response);
//
//        } catch (DatabaseException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
