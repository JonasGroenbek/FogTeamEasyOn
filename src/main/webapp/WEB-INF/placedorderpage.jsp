<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Thank you for your order, you will receive an email when your order has been shipped</h1>
<% session = request.getSession(); %>
        <svg width="1050" height="1050">
        <rect x="20" y="20" width="<%=(int)session.getAttribute("width")%>" 
              height="<%=(int)session.getAttribute("length")%>"
              style="fill:white;stroke:black;stroke-width:3;" />
        <circle cx="27" cy="27" r="3" stroke="black" stroke-width="1" fill="white" />
        <circle cx="<%=(int)(session.getAttribute("width")) + 13%>" cy="27" r="3" stroke="black" stroke-width="1" fill="white" />
        <circle cx="27" cy="<%=(int)(session.getAttribute("length")) + 13%>" r="3" stroke="black" stroke-width="1" fill="white" />
        <circle cx="<%=(int)(session.getAttribute("width")) + 13%>" cy="<%=(int)(session.getAttribute("length")) + 13%>" r="3" stroke="black" stroke-width="1" fill="white" />
        </svg>

    </body>
</html>
