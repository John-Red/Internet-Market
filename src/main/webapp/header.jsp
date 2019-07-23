<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="items" />

<html lang="${param.lang}">
<head>
	<title>EPAM EXPRESS</title>
	<meta charset="UTF-8">
	<meta name="description" content="EPAM store">

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Raleway:400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.css">
	<link rel="stylesheet" href="css/header_style.css"/>
</head>
<body>
	<!-- Header section -->
	<header class="header-section header-normal">
		<div class="container-fluid">
			<!-- logo -->
			<div class="site-logo">
			<div class="localisation">
              		<a href="?lang=en"><img src="./img/en.png" class="en-ru-img"></a>
              		<a href="?lang=ru"><img src="./img/ru.png" class="en-ru-img"></a>
              		</div>
			<a href="/items?lang=en">
				<img src="img/epam_logo.png"  alt="logo"></a>
			</div>
			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<form method="post">
			<div class="header-right">
			  <a href="/admin?lang=en" class="user" ><i class="fa fa-user fa-2x fa-fw" style="color:white" aria-hidden="true"></i></a>
			  <a href="/cart?lang=en" class="card-bag" ><i class="fa fa-shopping-cart fa-2x fa-fw" style="color:white" aria-hidden="true"></i><span>${CartQuantity}</span></a>
			  <a href="<c:url value="/logout"/>" class="a-search-img"><img src="img/logout.png" class="search-img" ></a>
			  <a><span class="span-balance">Balance: ${userBalance}</span></a>
			</div>
			</form>
			<!-- site menu -->
			<ul class="main-menu">
			<li><a href="/items?category=furniture&lang=en"><fmt:message key="label.Furniture" /></a></li>
				<li><a href="/items?category=electronics&lang=en"><fmt:message key="label.Electronics" /></a></li>
				<li><a href="/items?category=sporting goods&lang=en"><fmt:message key="label.SportingGoods" /></a></li>
				<li><a href="/items?category=merch&lang=en"><fmt:message key="label.Merch" /></a></li>
				<li><a href="/items?category=stationary&lang=en"><fmt:message key="label.Stationery" /></a></li>
				<li><a href="/items?category=books&lang=en"><fmt:message key="label.Books" /></a></li>
			</ul>
		</div>
	</header>
	</body>
</html>