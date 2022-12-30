package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
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
            order = OrderFacade.readDataFromAnOrder(orderID, connectionPool);
            session.setAttribute("order", order);

            SVG carportDrawTop = CarportSVG.createNewSVG(0, 0, 100, 100, "0 0 1280 720");
            carportDrawTop = CarportSVG.makeSVGTop(order, carportDrawTop);
            request.setAttribute("carportDrawTop", carportDrawTop);

            SVG carportDrawSide = CarportSVG.createNewSVG(0, 0, 100, 100, "0 0 1280 720");
            carportDrawSide = CarportSVG.makeSVGSide(order, carportDrawSide);
            request.setAttribute("carportDrawSide", carportDrawSide);

        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        if (order.getStatusID() <= 2) {
            request.getRequestDispatcher("WEB-INF/user/showorderdetailsuser.jsp").forward(request, response);
        }
        request.getRequestDispatcher("WEB-INF/user/orderdetailswithbom.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
