<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, com.financetracker.model.Transaction" %>
<%
    List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Transactions</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>All Transactions</h2>
<table border="1">
    <tr>
        <th>Type</th>
        <th>Category</th>
        <th>Amount</th>
        <th>Date</th>
    </tr>

    <% if (transactions != null && !transactions.isEmpty()) {
        for (Transaction txn : transactions) { %>
    <tr>
        <td><%= txn.getType() %></td>
        <td><%= txn.getCategory() %></td>
        <td><%= txn.getAmount() %></td>
        <td><%= txn.getDate() %></td>
    </tr>
    <%     }
    } else { %>
    <tr>
        <td colspan="4">No transactions found.</td>
    </tr>
    <% } %>
</table>

<a href="index.jsp">Back to Home</a>
</body>
</html>
