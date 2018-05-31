<%@page import="FunctionLayer.Shed"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/fog.jpg">
        <title>FOG Carport</title>
    </head>
    <% User user = (User) session.getAttribute("user");%>
    <body>

        <div class="jumbotron">
        </div>


        <%@include file="../includes/navbar.jsp" %>
        <h1>Hello <% out.println(session.getAttribute("email")); %> </h1>
        <a id="bestil" href="FrontController?command=link" > TRYK HER FOR AT BESTILLE </a>
        

        <%
            ArrayList<Order> Orders = LogicFacade.getUserOrders(user.getId());
            if ( Orders.isEmpty() ) {
        %>

        <h2 id="noorder">DU HAR INGEN TIDLIGERE ORDRE</h2 >
        <%
        } else {
        %>
        <table class="table table-striped" id="customertable">
            <tr>
                <th>ordre id</th>
                <th>userID</th> 
                <th>pris</th>
                <th>højde</tsomeone@nowhere.comh </th>
                <th>længde</th> 
                <th>brede</th>
                <th>skur længde</th>
                <th>skur brede</th>
                <th>stykliste</th>
                <th>tegning</th>
            </tr>

            <%
                
                for (Order o : Orders) {
                Shed shed = LogicFacade.getShed(o.getShed());
            %> 
            <form name="bill" action="FrontController" method="POST">
                <input type="hidden" name="command" value="billdrawing">
                <input type="hidden" name="orderID" value="<% out.println(o.getId()); %>">
                
                <td> <%out.println( o.getId()); %> </td>
                <td> <%out.println( o.getUserID());%> </td>
                <td> <%out.println( o.getPrice());%> </td>
                <td> <%out.println( o.getHeight());%> </td>
                <td> <%out.println( o.getLength());%> </td>
                <td> <%out.println( o.getWidth());%> </td>
                <td> <%out.println( shed.getLength());%> </td>
                <td> <%out.println( shed.getWidth());%> </td>
                <td><input type="submit" name="site" value="Se Stykliste"> </td>
                <td><input type="submit" name="site" value="tegning"> </form></td>

    </tr>


    <% }

        }
    %>
</table>
<jsp:include page="../includes/footer.jsp"/>

</body>
</html>
