<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="icon" href="${pageContext.request.contextPath}/assets/images/fog.jpg">
    </head>
    <body>
        <div class="jumbotron">
        </div>

        <%@include file="../includes/navbar.jsp" %>

        <h1> Bestil din carport </h1>
        <form id="order" name="createorder" action="FrontController" method="POST" onsubmit="return myfunction()">
            <input type="hidden" name="command" value="createorder">
            <br>
            Længde på skur:<br>
            <select id="lengthShed" name="lengthShed">
                <option value="0">Ønsker ikke redskabsrum</option>
                <option value="180">180cm</option>
                <option value="210">210cm</option>
                <option value="240">240cm</option>
                <option value="270">270cm</option>
                <option value="300">300cm</option>
                <option value="330">330cm</option>
                <option value="360">360cm</option>
                <option value="390">390cm</option>
                <option value="420">420cm</option>
                <option value="450">450cm</option>
                <option value="480">480cm</option>
                <option value="510">510cm</option>
                <option value="540">540cm</option>
                <option value="570">570cm</option>
                <option value="600">600cm</option>
                <option value="630">630cm</option>
                <option value="660">660cm</option>
                <option value="690">690cm</option>
                <option value="720">720cm</option>
            </select>
            <br>
            Brede på skur:<br>
            <select id="widthShed" name="widthShed">
                <option value="0">Ønsker ikke redskabsrum</option>
                <option value="180">180cm</option>
                <option value="210">210cm</option>
                <option value="240">240cm</option>
                <option value="270">270cm</option>
                <option value="300">300cm</option>
                <option value="330">330cm</option>
                <option value="360">360cm</option>
                <option value="390">390cm</option>
                <option value="420">420cm</option>
                <option value="450">450cm</option>
                <option value="480">480cm</option>
                <option value="510">510cm</option>
                <option value="540">540cm</option>
                <option value="570">570cm</option>
                <option value="600">600cm</option>
                <option value="630">630cm</option>
                <option value="660">660cm</option>
                <option value="690">690cm</option>
            </select>
            <br>
            Brede:<br>
            <select id="widthCarport" name="width">
                <option value="240">240cm</option>
                <option value="270">270cm</option>
                <option value="300">300cm</option>
                <option value="330">330cm</option>
                <option value="360">360cm</option>
                <option value="390">390cm</option>
                <option value="420">420cm</option>
                <option value="450">450cm</option>
                <option value="480">480cm</option>
                <option value="510">510cm</option>
                <option value="540">540cm</option>
                <option value="570">570cm</option>
                <option value="600">600cm</option>
                <option value="630">630cm</option>
                <option value="660">660cm</option>
                <option value="690">690cm</option>
                <option value="720">720cm</option>
                <option value="750">750cm</option>
            </select>
            <br>
            Længde:<br>
            <select id="lengthCarport" name="length">
                <option value="240">240cm</option>
                <option value="270">270cm</option>
                <option value="300">300cm</option>
                <option value="330">330cm</option>
                <option value="360">360cm</option>
                <option value="390">390cm</option>
                <option value="420">420cm</option>
                <option value="450">450cm</option>
                <option value="480">480cm</option>
                <option value="510">510cm</option>
                <option value="540">540cm</option>
                <option value="570">570cm</option>
                <option value="600">600cm</option>
                <option value="630">630cm</option>
                <option value="660">660cm</option>
                <option value="690">690cm</option>
                <option value="720">720cm</option>
                <option value="750">750cm</option>
                <option value="780">780cm</option>
            </select>
            <br>

            <input type="submit" value="Submit">

        </form>

        <jsp:include page="../includes/footer.jsp"/>

        <script>
            function myfunction() {
                if (document.getElementById("lengthShed").value == 0 && document.getElementById("widthShed").value != 0) {
                    alert("et skur skal have både længde og brede");
                    return false;
                }
                if (document.getElementById("widthShed").value == 0 && document.getElementById("lengthShed").value != 0) {
                    alert("et skur skal have både længde og brede");
                    return false;
                }
                if (document.getElementById("lengthShed").value + 90 > document.getElementById("lengthCarport").value) {
                    alert("skurets længde skal være 90 cm indre end længden på carporten");
                    return false;
                }
                if (document.getElementById("widthShed").value + 90 > document.getElementById("widthCarport").value) {
                    alert("skurets brede skal være 90 cm mindre end breden på carporten");
                    return false;
                }

                alert("tak din bestillign er registreret, vi er glade for at du handlede hos os. du vil blive vidresendt til din ordre side");
                return true;
            }
        </script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
