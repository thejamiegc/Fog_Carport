package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

@WebServlet(name = "ShowDetailsAdmin", value = "/showdetailsadmin")
public class ShowDetailsAdmin extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Locale.setDefault(new Locale("US"));
        int orderID = Integer.parseInt(request.getParameter("orderID"));

        try {
            Order order = OrderFacade.readDataFromAnOrder(orderID, connectionPool);
            if (order.getStatusID() == 1) {
                order.setStatusID(2);
                OrderFacade.updateStatus(order, connectionPool);
            }
            session.setAttribute("order", order);
            SVG carportDrawTop = CarportSVG.createNewSVG(0, 0, 100, 100, "0 0 1280 720");
            carportDrawTop = CarportSVG.makeSVGTop(order, carportDrawTop);
            request.setAttribute("carportDrawTop", carportDrawTop);

            SVG carportDrawSide = CarportSVG.createNewSVG(0, 0, 100, 100, "0 0 1280 720");
            carportDrawSide = CarportSVG.makeSVGSide(order, carportDrawSide);
            request.setAttribute("carportDrawSide", carportDrawSide);

            request.getRequestDispatcher("WEB-INF/admin/showdetailsadmin.jsp").forward(request, response);
        } catch (DatabaseException | SQLException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}