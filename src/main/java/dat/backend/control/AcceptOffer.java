package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AcceptOffer", value = "/acceptoffer")
public class AcceptOffer extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    // METODE HENTER SESSION, GEMMER ORDERID I EN VARIABLE OG OPDATERER STATUSID FRA 3 -> 4
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            Order order = OrderFacade.readDataFromAnOrder(orderID, connectionPool);
            if (order.getStatusID() == 3) {
                order.setStatusID(4);
                OrderFacade.updateStatus(order, connectionPool);
                request.getRequestDispatcher("WEB-INF/user/orderconfirmation.jsp").forward(request, response);
            }
            request.getRequestDispatcher("WEB-INF/user/myorders.jsp").forward(request, response);
        } catch (DatabaseException | SQLException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}