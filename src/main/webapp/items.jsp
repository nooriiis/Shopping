<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
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
    <title>Products</title>
</head>
<body>
<h1 style="color: #3775c5"><%= "Electronics E-Commerce" %></h1><br>
<hr>
<% Collection<ItemInfo> items = ItemHandler.getItems("electronic");
    Iterator<ItemInfo> it = items.iterator();
    for (; it.hasNext();){
        ItemInfo item = it.next(); %>
<h4><%= "Product: " + item.getItemName() + "   Price: $" +  item.getItemPrice() + " Description: " + item.getItemInfo()%>
    <a href="cart?id=<%= item.getItemId()%>" class="button">Add to Cart</a>
    <hr>
</h4>
<%}%>
<a href="cart.jsp" class="button">Go to Cart</a>
</body>
</html>