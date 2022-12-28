package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "BuildCarport", value = "/buildCarport")
public class BuildCarport extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Order order = null;
        Carport carport = new Carport(Integer.parseInt(
                request.getParameter("length")),
                Integer.parseInt(request.getParameter("width")),
                request.getParameter("roof"));
        Shed shed = null;

        if (request.getParameter("shedlength") != "") {
            shed = new Shed(Integer.parseInt(request.getParameter("shedlength")), Integer.parseInt(request.getParameter("shedwidth")));
        }

        try {
            if (shed != null) {
                int shedID = CarportFacade.createShed(shed, connectionPool);
                shed.setShedID(shedID);
            }
            int carportID = CarportFacade.createCarport(carport, connectionPool);
            carport.setCarportID(carportID);
            User user = (User) session.getAttribute("user");
            order = new Order(user, carport, 1);
            int orderID = OrderFacade.createOrder(order, connectionPool);
            order.setOrderID(orderID);
            CarportFacade.updateOrderID(orderID, carportID, connectionPool);
            if (shed != null) {
                CarportFacade.updateShedID(orderID, shed, connectionPool);
            }
            Calculator.calculateAllBom(order, shed, connectionPool);
            request.getRequestDispatcher("/myorders").forward(request, response);

        } catch (DatabaseException | SQLException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
