<%@ page import="ui.CartInfo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bo.CartServlet" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ui.ItemInfo" %>
<%@ page import="bo.ItemHandler" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>


<%
    if (request.getSession().getAttribute("username")==null){
        response.sendRedirect("login.jsp");
    }
%>
<h2><%= "Your Shopping Cart"%></h2>

<%  if (session.getAttribute("cartList")!=null){

    ArrayList<CartItem> cartItemSession = (ArrayList<CartItem>) session.getAttribute("cartList");
    List<CartItem> cartItems = (List<CartItem>) CartItem.searchItemsById(cartItemSession);
    request.getSession().setAttribute("cart_list",cartItemSession);

    for(CartItem c : cartItemSession){%>
<table><th><%="Item name: "+c.getItemName()%>&emsp;</th>
    <th><%="Item price: "+c.getItemPrice()%>&emsp;</th>
    <th><%="Item info:"+c.getItemInfo()%>&emsp;</th>
    <th><%="Quantity: " + c.getCartItemQuantity()%></th>
</table>

<%}%>
<%}
else %>

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


