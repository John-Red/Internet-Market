<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 15px;
}
</style>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Available</th>
    </tr>
    <c:forEach items="${itemsList}" var="item" >
        <tr>
            <td>${item.getItemId()}</td>
            <td>${item.getName()}</td>
            <td>${item.getAvailable()}</td>
            <td>${item.getCategoryId()}</td>
            <td>${item.getPrice()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>