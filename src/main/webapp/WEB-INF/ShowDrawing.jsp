<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/fog.jpg">
        <title>FOG Carport</title>
    </head>
    <body>
        <div class="jumbotron">
        </div>
        <div id="svg"> 
            <% User user = (User) session.getAttribute("user");%>

            <% if (user.getRole() == 1) { %>
            <%@include file="../includes/navbar.jsp" %>
            <% } %>

            <% if (user.getRole() != 1) { %>
            <a id="tilbage" href="FrontController?command=back">Tilbage</a>
            <% } %>
            
            <% session = request.getSession();%>
            <div id="SVGTopView">
                <%=session.getAttribute("SVGTopView")%>
            </div>
            <div id="SVGSideView">
                <%=session.getAttribute("SVGSideView")%>
            </div>
        </div>

        <jsp:include page="../includes/footer.jsp"/>

    </body>

</html>
