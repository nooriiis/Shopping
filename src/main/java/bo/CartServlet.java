package bo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * This Servlet handles requests and responses related to the Cart of this application.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {

    /**
     * Checks the request from the JSP. If the request's action is "remove", then method cartRemoveItem is called, otherwise
     * method cartShowItems is called.
     * @param request the request sent to the Servlet.
     * @param response the response sent from the Servlet.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null){
            try {
                cartShowItems(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (action.equalsIgnoreCase("remove")) {
            try {
                cartRemoveItem(request,response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This method adds a cartItem to a Servlet Session called "cartList".
     */
    protected void cartShowItems(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ArrayList<CartItem> cartList = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        CartItem cartItem = new CartItem();
        cartItem.setItemId(id);
        cartItem.setCartItemQuantity(1);
        HttpSession session = request.getSession();
        ArrayList<CartItem> cartListSession = (ArrayList<CartItem>) session.getAttribute("cartList");

        if (cartListSession == null){
            cartList.add(cartItem);
            session.setAttribute("cartList", cartList);
        } else {
            cartList = cartListSession;
            boolean itemExist = false;
            for (CartItem c : cartListSession){
                if (c.getItemId() == id){
                    itemExist = true;
                    int quantity = c.getCartItemQuantity();
                    c.setCartItemQuantity(quantity+1);
                }
            }
            if (!itemExist){ //If itemExist is false
                cartList.add(cartItem);
            }
        }
        response.sendRedirect("items.jsp");
        out.close();
    }

    /**
     * This method removes a cartItem from the session.
     */
    protected void cartRemoveItem(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<CartItem> cartListSession = (ArrayList<CartItem>) session.getAttribute("cartList");

        for (int i = 0; i < cartListSession.size(); i++) {
            if (cartListSession.get(i).getItemId() == id) {
                cartListSession.remove(i);
                session.setAttribute("cartList", cartListSession);
                response.sendRedirect("cart.jsp");
            }
        }
    }

}
