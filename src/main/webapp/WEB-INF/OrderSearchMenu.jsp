<table>
    <tr>
        <th>Mail:</th>
    </tr>
    <tr>
         <form name="searchuserorders" action="FrontController" method="POST">
        <th><input type="text" name = "username"></th>
    <input type = "hidden" name = "Search" value = "UserOrders">
        <th><input type="submit" name = "SearchUserName" value = "search"></th>
         </form>
    </tr>
    <tr>
        <th>Order ID:</th>
    </tr>
    <tr>
    <form name="searchorderid" action="FrontController" method="POST">
        <th><input type="number" name = "orderID"></th>
        <input type = "hidden" name = "command" value = "searchorderid">
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