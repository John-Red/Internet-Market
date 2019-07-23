<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="items" />

<html lang="${param.lang}">
<head>
<style>
.card {
  margin: 0 auto;
  float: none;
  margin-bottom: 10px;
  margin-top: 70px;
}
.btn {
  margin-left: 180px;
  margin-bottom: 10px;
}
.card .card-text-center .btn-primary {
  background: #76CDD8;
  color: #ffffff;
  border: none;
}
.card-title {
  margin-top: 15px;
  margin-left: 108px;
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<div class="card" style="width: 35rem;">
  <img class="card-img-top" src="img/nomoneytravolta.gif" alt="Card image cap">
  <div class="card-text-center">
    <h5 class="card-title">Not enough coins on your account</h5>
    <a href="/items" class="btn btn-primary">Back to main page</a>
  </div>
</div>
</body>
</html>