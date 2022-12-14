package dat.backend.control.navigation;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "navToCustomerOrders", value = "/navToCustomerOrders")
public class NavToCustomerOrders extends HttpServlet {
    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Order> orderList;

        try {
            orderList = OrderFacade.readOrdersAsAdmin(connectionPool);
            session.setAttribute("orderList",orderList);
            request.getRequestDispatcher("WEB-INF/admin/allordersfromcustomers.jsp").forward(request, response);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
