package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
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

@WebServlet(name = "MyOrders", value = "/myorders")
public class MyOrders extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirects to doPost method.
        this.doPost(request, response);
    }

    @Override
    /*METODE - henter session, og gemmer nuværende (sessionens user) user som object, og initialisere en liste af Ordre objekter
    -> herefter henter og viser ordre data fra database */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> orderList;

        try {
            orderList = OrderFacade.readOrdersAsCustomer(user.getUserID(), connectionPool);
            session.setAttribute("orderList", orderList);
            request.getRequestDispatcher("WEB-INF/user/myorders.jsp").forward(request, response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}