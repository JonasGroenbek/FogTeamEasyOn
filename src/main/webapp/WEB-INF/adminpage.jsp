<%@page import="DBAccess.UserMapper"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("email")%> </h1>
        You are now logged in as a ADMIN of our wonderful site.
        <% OrderMapper om = new OrderMapper();
        UserMapper um = new UserMapper();
        List<Order> orders = om.getAllOrders();
        if(orders.size()<1){ %> Der ingen ordre i systemet. <%
            } 
            else{
            %>
            <table>
                <tr>
                <th>Ordre ID</th>
                <th>Kunde mail</th>
                <th>Pris</th>
                <th>Materiale</th>
                <th>Højde</th>
                <th>Længde</th> 
                <th>Bredde</th>
                <th>Tag</th>
                <th>Skur</th>
                </tr>
                <tr>
                <%
                    for(Order o : orders){
                        out.println("<form action=\"UpdateOrder\" method=\"post\">");
                        out.println("<th>"+o.getId()+"</th>");
                        out.println("<th>"+um.getMail(o.getUserID())+"</th>");
                        out.println("<th><input type=\"text\" name=\"price\" value=\""+o.getPrice() + "\">DKK</th>");
                        out.println("<th>"+om.getMaterial(o.getMaterial()).getType()+"</th>");
                        out.println("<th><input type=\"text\" name=\"height\" value=\""+o.getHeight()+ "\">cm</th>");
                        out.println("<th><input type=\"text\" name=\"length\" value=\""+o.getLength()+"\">cm</th>");
                        out.println("<th><input type=\"text\" name=\"width\" value=\""+o.getWidth()+"\">cm</th>");
                        out.println("<th>"+o.getRoofID()+"</th>");
                        out.println("<th>"+o.getShed()+"</th>");
                        out.println("<th><input type=\"hidden\" name=\"orderID\" value=\""+o.getId()+"\">"
                        + "<input type=\"submit\" name=\"update\" value=\"Gem\"></form></th></tr>");
                    }}
                    %>
                
            </table>
                
    </body>
</html>
