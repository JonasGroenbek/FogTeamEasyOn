<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>

        <form name="createorder" action="FrontController" method="POST">
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
            <select name="lengthShed">
                <option value="0">Ønsker ikke redskabsrum</option>
                <option value="150">150cm</option>
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
            Width of shed:<br>
            <select name="widthShed">
                <option value="0">Ønsker ikke redskabsrum</option>
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
            Width:<br>
            <select name="width">
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
            <select name="length">
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
            Would you like to build it yourself ?:<br>
            <!-- <input type="number" name="width" value="enter 0 for no and 1 for yes"> !-->
            <input type="checkbox" name="assemble">
            <br>
            <input type="submit" value="Submit">
        </form>


        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
