<%@page import="FunctionLayer.User"%>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content/html; charset=UTF-8">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/fog.jpg">
        <title>FOG Carport</title>
    </head>
    <body>
         <div class="jumbotron">
        </div>
        
        <% User user = (User) session.getAttribute("user");%>
        
        <% if(user.getRole() == 1){ %>
        <%@include file="../includes/navbar.jsp" %>
        <% } %>
        
        <% if(user.getRole() != 1){ %>
        <a id="tilbage" href="FrontController?command=back">Tilbage</a>
        <% } %>
        
        <h1>Stykliste</h1>
        <table class="table table-striped">
            <% ArrayList<Bill> list = (ArrayList) request.getAttribute("bill"); %>
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
                <td> <% out.println(list.get(i).getAmount()); %> </td>
                <td><% out.println(OrderMapper.getAllMaterials().get(i).getUnit()); %></td>
                <td><% out.println(OrderMapper.getAllMaterials().get(i).getDesc()); %></td>
            </tr>
            <% }%>
        </table>
         <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
