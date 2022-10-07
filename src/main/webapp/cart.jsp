<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.CartItem" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="ui.ItemInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .button {
            background-color: #3775c5;
            color: white;
            border: 2px #3775c5;
            margin: 2px;
            padding: 3px;
        }
    </style>
    <title>Shopping Cart</title>
</head>
<body>
<%
    if (session.getAttribute("username") == null){
        response.sendRedirect("login.jsp");
    }
%>
<h2 style="color: #3775c5"><%= "Your Shopping Cart"%></h2><br>
<hr>
<%
    ArrayList<CartItem> cartItemsSession = (ArrayList<CartItem>) session.getAttribute("cartList");
    if (cartItemsSession != null){
    Collection<ItemInfo> items = ItemHandler.getCartItems(cartItemsSession);
    Iterator<ItemInfo> it = items.iterator();
    for (; it.hasNext();){
        ItemInfo item = it.next(); %>
<h4><%= "Quantity: " + item.getItemQuantity() + " Item: " +  item.getItemName() + " Price: $" + item.getItemPrice()%></h4>
    <hr>
<%}}
else{%>
<h4><%= "No items added to the shopping Cart."%></h4>
<%}%>
<br>
<a href="items.jsp" class="button">Continue Shopping</a>
<a href="cart.jsp" class="button">Checkout</a>
</body>
</html>
