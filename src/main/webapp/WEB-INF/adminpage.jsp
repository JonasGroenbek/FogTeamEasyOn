<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.User"%>
<%@page import="DBAccess.UserMapper"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin home page</title>
    </head>
    <body>
        <% User user = (User) session.getAttribute("user");%>
        <% ArrayList<Order> Orders = (ArrayList<Order>) request.getAttribute("orders");%>
        <div class="jumbotron">
        </div>
        <h1>Welcome <%=request.getParameter("email")%> </h1>

        <form name="searchorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="searchorder">
            hvad vil du søge efter:
            <select name="search">
                <option value="1">Alle</option>
                <option value="2">User ID</option>
                <option value="3">Email</option>
            </select>
            <input type="text" name="query">
            <input type="submit" value="Søg">
        </form>
        <%
            if (Orders.isEmpty()) {
        %>

        <h2 id="noorder">Ingen ordre at vise, søg for at finde ordre</h2 >
        <%
        } else {
        %>
        <table class="table table-striped" id="customertable">
            <tr>
                <th>ordre id</th>
                <th>userID</th> 
                <th>pris</th>
                <th>materialeID</th>
                <th>højde</tsomeone@nowhere.comh </th>
                <th>længde</th> 
                <th>brede</th>
                <th>tagID</th>
                <th>skur</th>
            </tr>

            <%
                for (int i = 0; i < Orders.size(); i++) {
            %> 

            <td> <%out.println(Orders.get(i).getId()); %> </td>
            <td> <%out.println(Orders.get(i).getUserID());%> </td>
            <td> <%out.println(Orders.get(i).getPrice());%> </td>
            <td> <%out.println(Orders.get(i).getMaterial());%> </td>
            <td> <%out.println(Orders.get(i).getHeight());%> </td>
            <td> <%out.println(Orders.get(i).getLength());%> </td>
            <td> <%out.println(Orders.get(i).getWidth());%> </td>
            <td> <%out.println(Orders.get(i).getRoofID());%> </td>
            <td> <%out.println(Orders.get(i).getShed());%> </td>


        </tr>


        <% }

            }
        %>
    </table>


    <jsp:include page="../includes/footer.jsp"/>
</body>
</html>
