<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
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
    <title>Products</title>
</head>
<body>
<h1 style="color: #3775c5"><%= "Electronics E-Commerce" %></h1><br>
<hr>
<% Collection<ItemInfo> items = ItemHandler.getItems("electronic");
    Iterator<ItemInfo> it = items.iterator();
    for (; it.hasNext();){
        ItemInfo item = it.next(); %>

<div class="card" style="width: 18rem;">
    <div class="card-body">
        <h5 class="card-title"><%=item.getItemName()%></h5>
        <p class="card-text"><%="Price: $" +  item.getItemPrice() %></p>
        <p class="card-text"><%=" Description: " + item.getItemInfo() %></p>
        <a href="cart?id=<%= item.getItemId()%>" class="btn btn-primary btn-sm">Add to Cart</a>
    </div>
</div>
<%}%>
<a href="cart.jsp" class="btn btn-primary btn-lg">Go to Cart</a>
</body>
</html>