<%@page import="java.util.List"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page import="DBAccess.UserMapper"%>
<%@page import="FunctionLayer.Order"%>
<% 
        Order order = OrderMapper.getOrder(Integer.parseInt(request.getAttribute(orderID)));
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
                    %>