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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title"><%=item.getItemName()%></h5>
        <p class="card-text"><%="Price: $" +  item.getItemPrice() %></p>
        <p class="card-text"><%="Quantity: " + item.getItemQuantity()%></p>
        <a href="cart?id=<%= item.getItemId()%>" class="btn btn-primary btn-sm">Add to Cart</a>
    </div>
</div>

<%}}
else{%>
<h4><%= "No items added to the shopping Cart."%></h4>
<%}%>
<br>
<a href="items.jsp" class="btn btn-secondary btn-lg">Continue Shopping</a>
<a href="cart.jsp" class="btn btn-primary btn-lg">Checkout</a>
</body>
</html>
