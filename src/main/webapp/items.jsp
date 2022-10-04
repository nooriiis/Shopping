<%@ page import="ui.ItemInfo" %>
<%@ page import="java.util.Collection" %>
<%@ page import="bo.ItemHandler" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<% Collection<ItemInfo> items = ItemHandler.getItems("console");
    Iterator<ItemInfo> it = items.iterator();
    for (; it.hasNext();){
        ItemInfo item = it.next(); %>
    <%= item.getItemId()%>
    <%= item.getItemName()%></br>
    <%= item.getItemPrice()%></br>
    <%= item.getItemInfo()%></br>
<%    }%>
</body>
</html>