<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="items" />

<html lang="${param.lang}">
<head>
    <meta charset="UTF-8">
    <title>EPAM EXPRESS</title>
<link href="css/bootstrap.css.map" rel="stylesheet" type="text/css" media="all"/>
<link href="css/itemsstyle.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/styles.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/registration.css" rel="stylesheet" type="text/css" media="all"/>
<style>
.purchase-txt{
 font-size: 40px;
  font-weight: bold;
   color: #39c2d7;
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
<div class="page">
<div class="container-login">
<div class="purchase-txt">
<span>PLEASE, LOGIN AS ADMIN </span>
</div>
</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>


