<%@page import="DBAccess.UserMapper"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a ADMIN of our wonderful site.
        <table>
    <tr>
        <th>Mail:</th>
    </tr>
    <tr>
        <th><input type="text" name = "username"></th>
        <th><input type="button" name = "SearchUserName" value = "search"></th>
    </tr>
    <tr>
        <th>Order ID:</th>
    </tr>
    <tr>
    <form name="searchID" action="FrontController" method="POST">
        <th><input type="number" name = "orderID"></th>
        <th><input type="button" name = "SearchID" value = "Search"></th>
        <th><input type="button" name = "ShowAll" value = "Show all"></th>
        
    </form>
    </tr>
    </table>
        <%@include file="ShowAllOrders.jsp" %>
    </body>
</html>
