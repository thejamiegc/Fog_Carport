package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
                request.getParameter("roof"),
                Integer.parseInt(request.getParameter("shed")));


        try {

            int carportID = CarportFacade.createCarport(carport ,connectionPool);
            User user = (User)session.getAttribute("user");
            order = new Order(user.getUserID(),carportID,1);
            int orderID = OrderFacade.createOrder(order,connectionPool);
            int bomID = OrderFacade.createBom(orderID,connectionPool);
            Calculator.calculateAll(carport,bomID,connectionPool);
            request.getRequestDispatcher("/myorders").forward(request, response);

        } catch (DatabaseException e) {

            e.printStackTrace();
        }

    }
}
