<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="css/header_style.css"/>
    <link rel="stylesheet" href="css/cart_style.css">
</head>

<body>
<table class="table">

<td>
<table class="table">
<caption>Users</caption>
  <table class="table">

      <tr>
          <th>Login</th>
          <th>Role</th>
          <th>Active</th>
          <th></th>
          <th></th>
      </tr>
      <c:forEach items="${usersList}" var="user">
              <form method="post">
          <tr>
              <td>${user.getLogin()}</td>
              <td>
              <select name="getRole">
              <option value="${user.getRole()}">${user.getRole()}</option>
              <option value="user">->user</option>
              <option value="guest">->guest</option>
              <option value="admin">->admin</option>
              </select>
              </td>
              <td>
              <select name="getState">
                    <option value="${user.isActive()}">${user.isActive()}</option>
                    <option value="${!user.isActive()}">${!user.isActive()}</option>
                  </select>
              </td>
              <td>
              <td><button type="submit" name="userId" value="${user.getUserId()}">Submit</button></td>
              </td>
          </form>
      </c:forEach>
  </table>
</td>


<td>
    <table class="table">
    <caption>Items</caption>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Available</th>
            <th>Category</th>
            <th>Price</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${itemsList}" var="item" >
           <form method="post">
            <tr>
                <td>${item.getItemId()}</td>
                <td>${item.getName()}</td>
                <td>${item.getAvailable()}</td>
                <td>${item.getCategoryId()}</td>
                <td>${item.getPrice()}</td>
                <td>
                 <td><button onclick="" name="delete" value="${item.getItemId()}" class="delete_button" ><i class="fa fa-trash" aria-hidden="true"></i></button></td>
                </td>
        </c:forEach>
    </table>
</td>

</table>
<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>


