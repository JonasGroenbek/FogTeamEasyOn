<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Bill"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page import="FunctionLayer.BillCalc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  %>
        <% int id = Integer.parseInt(request.getAttribute("id").toString()); %>
        <% Order order = OrderMapper.getOrder(id); %>
        <% ArrayList<Bill> list = OrderMapper.getBill(id); %>
        <h1>Stykliste</h1>
        <table class="table table-striped">
            <tr>
                <th>Type:</th>
                <th>Materiale:</th>
                <th>Beskrivelse:</th>
                <th>Antal:</th>
            </tr>
                <% for (int i = 0; i < list.size(); i++) { %>

                <tr>
                <td><% out.print(OrderMapper.getMaterial(list.get(i).getMaterialID()).getType()); %></td>
                <td><% out.print(OrderMapper.getMaterial(list.get(i).getMaterialID()).getName()); %></td>
                <td><% out.print(OrderMapper.getMaterial(list.get(i).getMaterialID()).getDescription()); %></td>
                <td><% out.print(list.get(i).getAmount());} %></td>
                </tr>
        </table>
    </body>
</html>
