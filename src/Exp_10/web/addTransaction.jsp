<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Transaction</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="centered-form-container">
    <form action="add" method="post">
        <h2 style="text-align: center; color: #90caf9;">➕ Add New Transaction</h2>

        <label for="type">Type:</label>
        <select name="type" id="type">
            <option value="Income">Income</option>
            <option value="Expense">Expense</option>
        </select>

        <label for="category">Category:</label>
        <input type="text" name="category" id="category" placeholder="e.g. Food, Salary" required>

        <label for="amount">Amount:</label>
        <input type="number" name="amount" id="amount" step="0.01" placeholder="e.g. 1000" required>

        <label for="date">Date:</label>
        <input type="date" name="date" id="date" placeholder="YYYY-MM-DD" required>

        <input type="submit" value="Add Transaction">
    </form>
</div>

</body>
</html>
