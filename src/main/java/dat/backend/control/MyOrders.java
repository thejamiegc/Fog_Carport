package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CarportFacade;
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
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        List<Carport> carportList;
        List<Order> orderList;

        try {
            orderList = OrderFacade.readOrder(user.getUserID(), connectionPool);
            session.setAttribute("orderList",orderList);
            carportList = CarportFacade.readCarport(orderList, connectionPool);


            request.getRequestDispatcher("WEB-INF/user/myorders.jsp").forward(request, response);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}
