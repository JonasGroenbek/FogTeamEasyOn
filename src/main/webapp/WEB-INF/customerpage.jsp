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
        <title>Customer home page</title>
    </head>
    <% User user = (User) session.getAttribute("user");%>
    <body>
        <div class="jumbotron">
        </div>
        <h1 id="hello"> Welcome <%=request.getParameter("email")%> </h1>
        <a id="bestil" href="FrontController?command=link" > TRYK HER FOR AT BESTILLE </a>
        <%
            if (OrderMapper.getUserOrders(user.getId()).isEmpty()) {
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
                <th>materialeID</th>
                <th>højde</tsomeone@nowhere.comh>
                <th>længde</th> 
                <th>brede</th>
                <th>tagID</th>
                <th>skur</th>
                <th>stykliste</th>
            </tr>

            <%
                for (int i = 0; i < OrderMapper.getUserOrders(user.getId()).size(); i++) {
            %> 
            <form name="bill" action="FrontController" method="POST">
                <input type="hidden" name="command" value="makebill">
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
                    <td><input type="submit" value="Se Stykliste"> </form></td>
    </tr>
    

    <% }

        }
    %>
</table>
    <jsp:include page="../includes/footer.jsp"/>
</body>
</html>
