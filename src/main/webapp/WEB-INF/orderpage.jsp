<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    </head>
    <body>
        <div class="jumbotron">
        </div>
        <h1>PLACE YOUR ORDER</h1>
        <form id="order" name="createorder" action="FrontController" method="POST" onsubmit="return myfunction()">
            <input type="hidden" name="command" value="createorder">
            Choose Material:
            <br>
            <select name="material">
                <option value="1">material1</option>
                <option value="2">material2</option>
            </select>
            <br>
            Choose type of roof:
            <br>
            <select name="roof">
                <option value="1">roof1</option>
                <option value="2">roof2</option>
            </select>
            <br>
            Length of shed:<br>
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
            Width of shed:<br>
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
            Width:<br>
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
            Length:<br>
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

            <input type="submit" value="Submit" onclick="alert('tak din bestillign er registreret, vi er glade for at du handlede hos os. du vil blive vidresendt til din ordre side')" >

        </form>

        <jsp:include page="../includes/footer.jsp"/>

        <script>
            function myfunction() {
                if (document.getElementById("lengthShed").value == 0 && document.getElementById("widthShed").value != 0) {
                    alert("Shed must be given both dimensions");
                    return false;
                }
                if (document.getElementById("widthShed").value == 0 && document.getElementById("lengthShed").value != 0) {
                    alert("Shed must be given both dimensions");
                    return false;
                }
                if (document.getElementById("lengthShed").value + 90 > document.getElementById("lengthCarport").value) {
                    alert("The shed has to be atleast 90cm shorter in length than the carport");
                    return false;
                }
                if (document.getElementById("widthShed").value + 90 > document.getElementById("widthCarport").value) {
                    alert("The shed has to be atleast 90cm shorter in width than the carport");
                    return false;
                }

                return true;
            }
        </script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
