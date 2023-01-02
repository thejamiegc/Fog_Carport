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

@WebServlet(name = "DeleteOrder", value = "/deleteorder")
public class DeleteOrder extends HttpServlet {
    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    // You shouldn't end up here with a GET-request, thus you get sent to doPost m'lord
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    // METODE - henter session, gemmer orderID som variabel, læser Ordre data fra database og henter skur længde, herefter slettes skur fra database.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Order order = null;
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            order = OrderFacade.readDataFromAnOrder(orderID, connectionPool);
            if (order.getShed().getShedLength() != 0) {
                OrderFacade.deleteShed(orderID, connectionPool);
            }
            OrderFacade.deleteOrder(orderID, connectionPool);
        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        session.setAttribute("order", order);
        request.getRequestDispatcher("WEB-INF/admin/deleteconfirmation.jsp").forward(request, response);
    }
}