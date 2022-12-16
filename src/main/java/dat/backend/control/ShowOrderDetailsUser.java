package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.OrderMapper;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "ShowOrderDetailsUser", value = "/showorderdetailsuser")
public class ShowOrderDetailsUser extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Locale.setDefault(new Locale("US"));
        Order order = null;
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            order = OrderFacade.readDataFromAnOrder(orderID,connectionPool);
            session.setAttribute("order",order);
            SVG carportDraw = CarportSVG.createNewSVG(0, 0, 100, 60, "0 0 855 690");
            carportDraw = CarportSVG.addRafters(order, carportDraw);
            carportDraw = CarportSVG.addBeams(order,carportDraw);
            carportDraw = CarportSVG.addPoles(order,carportDraw);
            session.setAttribute("carportDraw",carportDraw);
            request.getRequestDispatcher("WEB-INF/user/showorderdetailsuser.jsp").forward(request, response);


        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        if (order.getStatusID() <= 2) {
            request.getRequestDispatcher("WEB-INF/user/showorderdetailsuser.jsp").forward(request, response);
        }
            request.getRequestDispatcher("WEB-INF/user/orderdetailswithbom.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
