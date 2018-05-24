
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
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
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <title>Customer home page</title>
    </head>
    <% User user = (User) session.getAttribute("user");%>
    <body>
        <div class="jumbotron" id="jens">
        </div>
        <%@include file="../includes/navbar.jsp" %>
        <h1>Hello <% out.println(session.getAttribute("email")); %> </h1>

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
                <th>højde</tsomeone@nowhere.comh>
                <th>længde</th> 
                <th>brede</th>
                <th>tagID</th>
                <th>skur</th>
                <th>stykliste</th>
                <th>tegning</th>
            </tr>

            <%
                for (int i = 0; i < OrderMapper.getUserOrders(user.getId()).size(); i++) {
            %> 
            <form name="bill" action="FrontController" method="POST">
                <input type="hidden" name="command" value="BillDrawing">
                <input type="hidden" name="orderID" value="<% out.println(OrderMapper.getUserOrders(user.getId()).get(i).getId()); %>">

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
                    <td>
                        <input type="submit" name="site" value="bill" </td>
                    <td>
                        <input type="submit" name="site" value="drawing"> 
                    </td>
            </form>




        </tr>
        <% }

            }
        %>
    </table>>
    <div class="footer">
        <div class="container">
            <a href='#'><i class="fa fa-twitch fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-facebook fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-twitter fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-youtube-play fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-rss fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-vine fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-flickr fa-3x fa-fw"></i></a>
            <a href='#'><i class="fa fa-linkedin fa-3x fa-fw"></i></a>
            </span>
        </div>
    </div>

</body>
</html>
