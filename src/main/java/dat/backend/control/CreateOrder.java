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

@WebServlet(name = "CreateOrder", value = "/createorder")
public class CreateOrder extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    // METODE - henter session, gemmer orderID som variabel, og ændrer status fra alt under 3 til -> 3
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            Order order = OrderFacade.readDataFromAnOrder(orderID, connectionPool);
            if (order.getStatusID() < 3) {
                order.setStatusID(3);
                OrderFacade.updateStatus(order, connectionPool);
            }
            session.setAttribute("order", order);
            request.getRequestDispatcher("/navToCustomerOrders").forward(request, response);
        } catch (DatabaseException | SQLException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}