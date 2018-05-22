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
        <h1>Stykliste</h1>
        <table class="table table-striped">
            <tr>
                <th>beskrivelse:</th>
                <th>længde:</th>
                <th>antal:</th>
                <th>enhed:</th>
                <th>beskrivelse:</th>
            </tr>
            <% for (int i = 0; i < OrderMapper.getAllMaterials().size(); i++) { %>

            <tr>
                <td><% out.println(OrderMapper.getAllMaterials().get(i).getDescription()); %></td>
                <td><% out.println(OrderMapper.getAllMaterials().get(i).getLength()); %></td>
                <td> <%  %> </td>
                <td><% out.println(OrderMapper.getAllMaterials().get(i).getUnit()); %></td>
                <td><% out.println(OrderMapper.getAllMaterials().get(i).getDesc()); %></td>
            </tr>
            <% }%>
        </table>
    </body>
</html>
