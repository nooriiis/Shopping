package bo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        int price = Integer.parseInt(request.getParameter("price"));
        String info = request.getParameter("info");
        String name = request.getParameter("name");
        CartItem cartItem = new CartItem();
        cartItem.setItemId(id);
        cartItem.setCartItemQuantity(cartItem.getCartItemQuantity()+1);
        cartItem.setItemName(name);
        cartItem.setItemInfo(info);
        cartItem.setItemPrice(price);
        HttpSession session = request.getSession();
        ArrayList<CartItem> cartListSession = (ArrayList<CartItem>) session.getAttribute("cartList");
        if (cartListSession == null){
            cartList.add(cartItem);

            session.setAttribute("cartList", cartList);
            out.println("<html><head></head><body onload=\"alert('Item added to the Cart!')\"></body></html>");
            out.println("Session created");


        } else {
            cartList = cartListSession;
            boolean itemExist = false;
            for (CartItem c : cartListSession){
                if (c.getItemId() == id){
                    itemExist = true;

                    out.println("<html><head></head><body onload=\"alert('Item is already in your Cart.')\"></body></html>");
                    out.println("product exist");

                }
            }
            if (!itemExist){
                cartList.add(cartItem);
                out.println("<html><head></head><body onload=\"alert('Item added to the Cart!')\"></body></html>");

                response.sendRedirect("items.jsp");
            }

        }
        out.close();
    }
}
