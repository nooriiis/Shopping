package bo;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

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
