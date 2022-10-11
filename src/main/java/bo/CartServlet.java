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

        // Create a new list
        ArrayList<CartItem> cartList = new ArrayList<>();

        // Get id from clicked item and create new cart item
        int id = Integer.parseInt(request.getParameter("id"));
        CartItem cartItem = new CartItem();
        cartItem.setItemId(id);
        cartItem.setCartItemQuantity(1);
        HttpSession session = request.getSession();
        ArrayList<CartItem> cartListSession = (ArrayList<CartItem>) session.getAttribute("cartList");

        // If the list is not created previously then use the new list
        // and add the new created cart item
        if (cartListSession == null){
            cartList.add(cartItem);
            session.setAttribute("cartList", cartList);
        } else {

            // Looks if the item sent is already created, if it is then add
            // another to the quantity. But if it isn't then add the new created item

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
