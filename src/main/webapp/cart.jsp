<%@ page import="ui.CartInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bo.CartServlet" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ui.ItemInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<%
    if (session.getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>
<h2><%= "Your Shopping Cart"%></h2>
<% ArrayList<CartItem> cartItemSession = (ArrayList<CartItem>) session.getAttribute("cartList");
   List<CartItem> cartItems = (List<CartItem>) CartItem.searchItemsById(cartItemSession);
   request.setAttribute("cart_list",cartItemSession);
    for(CartItem c : cartItems){%>
<h2><%=c.getItemPrice()%></h2>
    <%}%>
</body>
</html>

<%-- public static Collection<ItemInfo> getItems(String s){
        Collection c = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getItemInfo()));
        }
        return items;
    }--%>

<%--public static Collection<CartInfo> getCartItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        ArrayList<CartItem> cartItemsSession = (ArrayList<CartItem>) session.getAttribute("cartList");
        Collection c = CartItem.searchItemsById(cartItemsSession);
        ArrayList<CartInfo> cartItems = new ArrayList<CartInfo>();
        for (Iterator it = c.iterator(); it.hasNext();){
            CartItem cartItem = (CartItem) it.next();
            cartItems.add(new CartInfo(cartItem.getItemId(), cartItem.getCartItemQuantity(), cartItem.getItemName(), cartItem.getItemPrice()));
        }
        out.close();
        return cartItems;
    }--%>


