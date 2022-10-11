package bo;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This Servlet handles requests and responses related to the Login process of this application.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    /**
     * Checks if the input of the request matches any sets of the database, and sens the User to the Login page if the credentials of the
     * username and password fails, or the main page if it is successful.
     * @param request the request sent to the Servlet.
     * @param response the response sent from the Servlet.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("user");
        String password = request.getParameter("pass");
        Boolean logInBoolean = User.isUser(username,password);
        if (logInBoolean==false){
            response.sendRedirect("login.jsp");
        } else{
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect("cart.jsp");
        }
        out.close();
    }
}
