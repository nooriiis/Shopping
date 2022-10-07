package bo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
}
