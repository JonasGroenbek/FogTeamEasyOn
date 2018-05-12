
<%@page import="FunctionLayer.User"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <% User user = (User)session.getAttribute("user");%>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
         <a href="FrontController?command=link" > tryk her for at bestille </a>
        <%
            if (OrderMapper.getUserOrders(user.getId()).isEmpty()) {
        %>
        <p>du har ingen tideligere ordere</p>>
        <%
        } else {
        %>
        <table class="table table-striped">
            <tr>
                <th>ordre id</th>
                <th>userID</th> 
                <th>pris</th>
                <th>materialeID</th>
                <th>højde</th>
                <th>længde</th> 
                <th>brede</th>
                <th>tagID</th>
                <th>skur</th>
                <th>stykliste</th>
            </tr>
            
            <%
                for (int i = 0; i < OrderMapper.getUserOrders(user.getId()).size(); i++) {
            %> 
            <tr>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getId()); %> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getUserID());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getPrice());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getMaterial());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getHeight());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getLength());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getWidth());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getRoofID());%> </td>
                <td> <%out.println(OrderMapper.getUserOrders(user.getId()).get(i).getShed());%> </td>
                <td><a href="FrontController?command=makebill?OrderID=<% out.println(OrderMapper.getUserOrders(user.getId()).get(i).getId()); %>" > se stykliste </a></td>

            </tr>
            <% }

                }
            %>
        </table>>
    </body>
</html>
