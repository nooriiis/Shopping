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

<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Quantity</th>
    </tr>
    </thead>

    <tbody>
<%

    ArrayList<CartItem> cartItemsSession = (ArrayList<CartItem>) session.getAttribute("cartList");
    if (cartItemsSession != null){
    Collection<ItemInfo> items = ItemHandler.getCartItems(cartItemsSession);
    Iterator<ItemInfo> it = items.iterator();
    int totalPrice=0;
    for (int i=1; it.hasNext();i++){
        ItemInfo item = it.next();%>
            <tr>
                <th scope="row"><%=i%></th>
                <td><%=item.getItemName() %></td>
                <td><%=item.getItemPrice() %></td>
                <td><%=item.getItemQuantity() %></td>
            </tr>
        <%totalPrice += (item.getItemPrice()*item.getItemQuantity());%>
<%}%>  </tbody>

        </table>
<h3>Total Price: <%=totalPrice %> </h3>
<%}
else{%>
<h4><%= "No items added to the shopping Cart."%></h4>
<%}%>

<br>
<a href="items.jsp" class="btn btn-secondary btn-lg">Continue Shopping</a>
<a href="cart.jsp" class="btn btn-primary btn-lg">Checkout</a>
</body>
</html>
