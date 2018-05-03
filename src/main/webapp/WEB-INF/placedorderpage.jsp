<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thank you for your order, you will receive an email when your order has been shipped</h1>

        <svg width="1000" height="1000">
        <rect x="20" y="20" width="<%=request.getParameter("width")%>" 
              height="<%=request.getParameter("length")%>"
              style="fill:white;stroke:black;stroke-width:3;" />
        <circle cx="27" cy="27" r="3" stroke="black" stroke-width="1" fill="white" />
        <circle cx="<%=request.getParameter("width")+27 %>" cy="27" r="3" stroke="black" stroke-width="1" fill="white" />
        </svg>

    </body>
</html>
