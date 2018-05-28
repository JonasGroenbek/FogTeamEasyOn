<%-- 
    Document   : errorPage
    Created on : May 28, 2018, 11:59:28 AM
    Author     : jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p> something went wrong, please contact IT </p>
        <%= request.getParameter("errorPage")); %>
    </body>
</html>
