<%@page import="FunctionLayer.BillCalc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% BillCalc bill = new BillCalc(); %>
        <h1>Stykliste</h1>
        <table class="table table-striped">
            <tr>
                <th>skruer</th>
                <td><% out.println(bill.createBill(1).getScrews()); %></th>


            </tr>

            <tr>
                <th>5 meter træ</th>
                <td> <% out.println(bill.createBill(1).getWood()); %> </th>

            </tr>
            <tr>
                <th>beslaf</th>
                <td> <% out.println(bill.createBill(1).getBracket());%> </td>
            </tr>

        </table>
    </body>
</html>
