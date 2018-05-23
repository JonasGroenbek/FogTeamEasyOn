<%@page import="java.util.List"%>
<%@page import="DBAccess.OrderMapper"%>
<%@page import="DBAccess.UserMapper"%>
<%@page import="FunctionLayer.Order"%>

<% 
        List<Order> orders = OrderMapper.getUserOrders(UserMapper.getID(request.getAttribute(username)));
        if(orders.size()<1){ %> Der ingen ordre i systemet. <%
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
                    for(Order o : orders){
                        out.println("<form name=\"updateorder\" action=\"FrontController\" method=\"POST\">");
                        out.println("<input type=\"hidden\" name=\"command\" value=\"updateorder\">");
                        out.println("<th>"+o.getId()+"</th>");
                        out.println("<th>"+UserMapper.getMail(o.getUserID())+"</th>");
                        out.println("<th><input type=\"number\" name=\"price\" value=\""+o.getPrice() + "\">DKK</th>");
                        out.println("<th><input type=\"number\" name=\"height\" value=\""+o.getHeight()+ "\">cm</th>");
                        out.println("<th><input type=\"number\" name=\"length\" value=\""+o.getLength()+"\">cm</th>");
                        out.println("<th><input type=\"number\" name=\"width\" value=\""+o.getWidth()+"\">cm</th>");
                        out.println("<th>"+o.getRoofID()+"</th>");
                        out.println("<th>"+o.getShed()+"</th>");
                        out.println("<th><input type=\"hidden\" name=\"orderID\" value=\""+o.getId()+"\">");
                        out.println("<th><input type=\"submit\" value=\"Submit\"></th></tr> ");
                    }}
                    %>