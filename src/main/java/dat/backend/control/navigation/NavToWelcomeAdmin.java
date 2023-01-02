package dat.backend.control.navigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NavToWelcomeAdmin", value = "/navtowelcomeadmin")
public class NavToWelcomeAdmin extends HttpServlet {
    @Override
    // METODE DIRIGERER BRUGER VIDERE TIL WELCOMEADMIN.JSP SIDE
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/admin/welcomeadmin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
