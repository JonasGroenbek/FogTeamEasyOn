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
        <h1>Hello <%=user.getEmail()%> </h1>

        <%@include file="OrderSearchMenu.jsp" %>

        <form id="empform" name="updateBuilder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="updateBuilder">
            <input type="number" min="1"max="1000" name="orderId">
            <select name="builder">
                <option value="0">Customer's building</option>
                <option value="1">Assembler's building</option>
            </select>
            <input type="submit" value="updateBuilder">
        </form>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
