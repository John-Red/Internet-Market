<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<link href="css/itemsstyle.css" rel="stylesheet" type="text/css" media="all"/>
</head>

<body>
<%@include file="header.jsp" %>

<div class="page">
<div class="col-left">
<c:forEach items="${itemsList}" var="item" >
<div class="item-container">

<div class = "image-container">
<div><img src="./images/${item.getImage()}" class="img" alt=""></div>
</div>

<div><h2>${item.getName()}</h2></div>
<div><span class="span">${item.getPrice()} $</span></div>
<div class="item_available"><p>Available:  ${item.getAvailable()}</p></div>
<div class="img item_add">
<a href="#"><img src="./images/ca.png" alt=""></a>
</div>


</div>
</c:forEach>
</div>

<div class="col-right">
			<!--categories-->
						<h2>Categories</h2>
							<ul class="menu-drop">
							 <c:forEach items="${itemsList}" var="item" >
							    <li class="item1"><a href="#">${item.getCategoryId()}</a></li>
							</c:forEach>
						</ul>
</div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>

