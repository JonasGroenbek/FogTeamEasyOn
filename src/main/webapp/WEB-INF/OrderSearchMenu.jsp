<div id="test">
<table>
    <tr>
        <th>Mail:</th>
    </tr>
    <tr>
         <form name="showuserorders" action="FrontController" method="POST">
        <th><input type="text" name = "mail"></th>
    <input type = "hidden" name = "command" value = "showuserorder">
        <th><input type="submit" name = "SearchUserName" value = "search"></th>
         </form>
    </tr>
    <tr>
        <th>Order ID:</th>
    </tr>
    <tr>
    <form name="searchorderid" action="FrontController" method="POST">
        <th><input type="number" name = "orderID"></th>
        <input type = "hidden" name = "command" value = "showorderbyid">
        <th><input type="submit" name = "SearchID" value = "Search"></th>
    </form>
        </tr>
    <tr>
    <form name="showallorders" action="FrontController" method="POST">
        <input type = "hidden" name = "command" value = "showorders">
        <th><input type="submit" name = "ShowAll" value = "Show all"></th>
    </form>
    </tr>
    </table>
</div>