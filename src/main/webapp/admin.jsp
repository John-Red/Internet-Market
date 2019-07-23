<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false"%>


<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="admin" />

<html lang="${param.lang}">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
    <link rel="stylesheet" href="css/header_style.css"/>
    <link rel="stylesheet" href="css/cart_style.css">
    <style>
    .table{
     margin-bottom: 0;
    }
    .page-style{
     min-height: calc(100vh - 182px);
    }
    </style>
</head>

<body>
<div class="page-style">
<table class="table">
<td>
  <table class="table">
  <caption><fmt:message key="label.Users" /></caption>
      <tr>
          <th><fmt:message key="label.Login" /></th>
          <th><fmt:message key="label.Role" /></th>
          <th><fmt:message key="label.Active" /></th>
          <th>Balance</th>
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
              <option value="user">-><fmt:message key="label.user" /></option>
              <option value="admin">-><fmt:message key="label.admin" /></option>
              </select>
              </td>
              <td>
              <select name="getState">
                    <option value="${user.isActive()}">${user.isActive()}</option>
                    <option value="${!user.isActive()}">${!user.isActive()}</option>
                  </select>
              </td>
              <td><input name="getBalance" maxlength="10" size="8" value=${user.getBalance()}></td>
              <td>
              <td><button type="submit" name="userId" value="${user.getUserId()}"><fmt:message key="label.Submit" /></button></td>
              </td>
          </form>
      </c:forEach>
  </table>
</td>


<td>
     <table class="table">
    <caption><fmt:message key="label.Items" /></caption>
        <tr>
            <th><fmt:message key="label.ID" /></th>
            <th><fmt:message key="label.Name" /></th>
            <th><fmt:message key="label.Available" /></th>
            <th><fmt:message key="label.Category" /></th>
            <th><fmt:message key="label.Price" /></th>
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
                 <td><button type="submit" name="delete" value="${item.getItemId()}" onclick="return confirm('delete?');">X</button></td>
                </td>
        </c:forEach>
    </table>
</td>
</table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


