<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
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
<div class="item_available"><p>Available:${item.getAvailable()}</p></div>

<div class="item_add">
<button class="item-button" type="submit" name="addInCart" value="${item.getItemId()}"><img src="./img/ca.png"></button>
</div>
</div>
</c:forEach>
</form>
</div>

<div class="col-right">
			<!--categories-->
						<h2>Categories</h2>
							<ul class="menu-drop">
							 <c:forEach items="${categoriesList}" var="categories" >
							    <li class="item1"><a href="/items?category=${categories.getName()}">${categories.getName()}</a></li>
							</c:forEach>
						</ul>
</div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>

