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
  margin-top: 150px;
}
.btn {
  margin-left: 110px;
}
.card .card-body .btn-primary {
  background: #76CDD8;
  color: #ffffff;
  border: none;
}
.card-title {
  margin-left: 108px;
}
.card-text {
  margin-left: 30px;
}
</style>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<div class="card" style="width: 28rem;">
  <img class="card-img-top" src="img/Shut_up_and_take_all_the_ny_money.gif" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">Thank you for purchase!</h5>
    <p class="card-text">Your order № ${orderId} complete and will be delivered to your work place.</p>
    <a href="/items" class="btn btn-primary">Back to main page</a>
  </div>
</div>
</body>
</html>