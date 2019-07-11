<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<link href="./css/bootstrap.css" rel="stylesheet">
</head>
<body>

  <table class="table">
      <tr>
          <th>ID</th>
          <th>Login</th>
          <th>Password</th>
          <th>Role</th>
          <th>Active</th>
      </tr>
      <c:forEach items="${usersList}" var="user" >
          <tr>
              <td>${user.getLogin()}</td>
              <td>${user.getPassword()}</td>
              <td>${user.getRole()}</td>
              <td>${user.getUserId()}</td>
              <td>${user.isActive()}</td>
          </tr>
      </c:forEach>
  </table>

    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Available</th>
            <th>Category</th>
            <th>Price</th>
            <th></th>
        </tr>
        <c:forEach items="${itemsList}" var="item" >
            <tr>
                <td>${item.getItemId()}</td>
                <td>${item.getName()}</td>
                <td>${item.getAvailable()}</td>
                <td>${item.getCategoryId()}</td>
                <td>${item.getPrice()}</td>
                <td>
                  <button type="submit" formmethod="post" onclick="location.href='/admin'">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </table>

<form method="post">
    <label>ID:
        <input type="itemId" name="ID"><br />
    </label>
</form>



</body>
</html>


