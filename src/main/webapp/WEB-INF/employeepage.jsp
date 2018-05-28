<%@page import="FunctionLayer.LogicFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>

        <div class="jumbotron">
        </div>  

        <% User user = (User) session.getAttribute("user");%>
        <% ArrayList<Order> Orders = (ArrayList<Order>) request.getAttribute("orders");%>
        <h1>Hello <%=user.getEmail()%> </h1>

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
                <th>Email</th>
                <th>userID</th> 
                <th>pris</th>
                <th>materialeID</th>
                <th>længde</th> 
                <th>brede</th>
                <th>tagID</th>
                <th>skur</th>
                <th>opdater</th>
            </tr>

            <%
                for (int i = 0; i < Orders.size(); i++) {
            %> 
            <form name="searchorder" action="FrontController" method="POST">
                <input type="hidden" name="command" value="updateorder">
                <td>  <input type="hidden" name="orderID" value="<% Orders.get(i).getId(); %>"> </td>
                <td> <%out.println(Orders.get(i).getUserID());%> </td>
                <td> <%out.println(LogicFacade.getEmail(Orders.get(i).getUserID()));%> </td>
                <td> <input type="text" name="price" value=" <%out.println(Orders.get(i).getPrice()); %>"> </td>
                <td> <%out.println(Orders.get(i).getMaterial()); %> </td>
                <td> <input type="text" name="length" value=" <%out.println(Orders.get(i).getLength()); %>"> </td>
                <td> <input type="text" name="width" value=" <%out.println(Orders.get(i).getWidth()); %>"> </td>
                <td> <%out.println(Orders.get(i).getRoofID());%> </td>
                <td> <input type="text" value=" <%out.println(Orders.get(i).getShed()); %>"> </td>
                <td><input type="submit" value="Opdater"></td>


                </tr>


                <% }

                    }
                %>
            </form>
        </table>

        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
