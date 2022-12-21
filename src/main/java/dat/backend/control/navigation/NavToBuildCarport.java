package dat.backend.control.navigation;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "navToBuildCarport", value = "/navToBuildCarport")
public class NavToBuildCarport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/user/buildcarport.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
