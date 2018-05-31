<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/fog.jpg">
        <title>FOG Carport</title>
    </head>
    <body>
        <div class="jumbotron">
        </div>
        <%@include file="../includes/navbar.jsp" %>
        <script>
            var text = "Thanks for the order, heres the drawing of your carport";
            document.write(text);
        </script>
        <div id="svg"> 
            <% session = request.getSession();%>
            <div id="SVGTopView">
                <%=session.getAttribute("SVGTopView")%>
            </div>
            <div id="SVGSideView">
                <%=session.getAttribute("SVGSideView")%>
            </div>
        </div>

    </body>
</html>
