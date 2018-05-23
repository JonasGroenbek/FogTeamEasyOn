<%-- 
    Document   : showorderbyid
    Created on : 23-May-2018, 11:39:11
    Author     : stgre
--%>
<%@page import="java.util.List"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page import="DBAccess.UserMapper"%>
<%@page import="FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Order ID <% out.println(request.getParameter("mail")); %></h1>
        <%
            Order order;
            switch ((Integer) session.getAttribute("role")) {
            case 2:
        order = OrderMapper.getOrder(Integer.valueOf(request.getParameter("orderID")));
        if(order == null){ %> Ordren eksisterer ikke. <%
            } 
            else{
            %>
            <table>
                <tr>
                <th>Ordre ID</th>
                <th>Kunde mail</th>
                <th>Pris</th>
                <th>Højde</th>
                <th>Længde</th> 
                <th>Bredde</th>
                <th>Tag</th>
                <th>Skur</th>
                </tr>
                <tr>
                <%
                        out.println("<th>"+order.getId()+"</th>");
                        out.println("<th>"+UserMapper.getMail(order.getUserID())+"</th>");
                        out.println("<th>"+order.getPrice() + "DKK</th>");
                        out.println("<th>"+order.getHeight()+ "cm</th>");
                        out.println("<th>"+order.getLength()+"cm</th>");
                        out.println("<th>"+order.getWidth()+"cm</th>");
                        out.println("<th>"+order.getRoofID()+"</th>");
                        out.println("<th>"+order.getShed()+"</th>");
                        out.println("</tr> ");
                    }
                break;
            case 3:
                order = OrderMapper.getOrder(Integer.valueOf(request.getParameter("orderID")));
        if(order == null){ %> Ordren eksisterer ikke. <%
            } 
            else{
            %>
            <table>
                <tr>
                <th>Ordre ID</th>
                <th>Kunde mail</th>
                <th>Pris</th>
                <th>Højde</th>
                <th>Længde</th> 
                <th>Bredde</th>
                <th>Tag</th>
                <th>Skur</th>
                </tr>
                <tr>
                <%
                    
                        out.println("<form name=\"updateorder\" action=\"FrontController\" method=\"POST\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"updateorder\">");
                        out.println("<th>"+order.getId()+"</th>");
                        out.println("<th>"+UserMapper.getMail(order.getUserID())+"</th>");
                        out.println("<th><input type=\"number\" name=\"price\" value=\""+order.getPrice() + "\">DKK</th>");
                        out.println("<th><input type=\"number\" name=\"height\" value=\""+order.getHeight()+ "\">cm</th>");
                        out.println("<th><input type=\"number\" name=\"length\" value=\""+order.getLength()+"\">cm</th>");
                        out.println("<th><input type=\"number\" name=\"width\" value=\""+order.getWidth()+"\">cm</th>");
                        out.println("<th>"+order.getRoofID()+"</th>");
                        out.println("<th>"+order.getShed()+"</th>");
                        out.println("<th><input type=\"hidden\" name=\"orderID\" value=\""+order.getId()+"\">");
                        out.println("<th><input type=\"submit\" value=\"Submit\"></th></tr> ");
                    }
                break;
				default:
                out.println("<p>Permission denied</P>");
                break;
        }
        %>
    </body>
</html>
