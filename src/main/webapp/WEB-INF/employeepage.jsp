<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
<% User user = (User)session.getAttribute("user");%>
        <h1>Hello <%=user.getEmail()%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
         
        <%@include file="OrderSearchMenu.jsp" %>
        
        <form name="updateBuilder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="updateBuilder">
                <input type="number" min="1"max="1000" name="orderId">
            <select name="builder">
                <option value="0">Customer's building</option>
                <option value="1">Assembler's building</option>
            </select>
                <input type="submit" value="updateBuilder">
            </form>
 
    </body>
</html>
