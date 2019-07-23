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
</head>

<body>
<%@include file="header.jsp" %>
<div class="page">
<div class="col-left">
<form method="post">
<c:forEach items="${itemsList}" var="item" >
<div class="item-container">

<div class = "image-container">
<div><img src="./img/${item.getImage()}" class="img" alt=""></div>
</div>

<div><h2>${item.getName()}</h2></div>
<div><span class="span">${item.getPrice()} $</span></div>
<div class="item_available"><p> <fmt:message key="label.available" />  ${item.getAvailable()}</p></div>

<div class="item_add">
<button class="item-button" type="submit" name="addInCart" value="${item.getItemId()}"><img src="./img/ca.png"></button>
</div>
</div>
</c:forEach>
</form>
</div>

<div class="col-right">
			<!--categories-->
						<h2><fmt:message key="label.Categories" /></h2>
							<ul class="menu-drop">
							 <c:forEach items="${categoriesList}" var="categories" >
							    <li class="item1"><a href="/items?category=${categories.getName()}&lang=en">${categories.getName()}</a></li>
							</c:forEach>
						</ul>
</div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>

