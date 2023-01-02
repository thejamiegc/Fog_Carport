package dat.backend.control.navigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NavToWelcomeUser", value = "/navtowelcomeuser")
public class NavToWelcomeUser extends HttpServlet {
    @Override
    //METODE DIRIGERER BRUGER VIDERE TIL WELCOMEUSER.JSP SIDE.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/user/welcomeuser.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
