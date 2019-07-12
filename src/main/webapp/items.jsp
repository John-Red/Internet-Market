<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<link href="css/bootstrap.css.map" rel="stylesheet" type="text/css" media="all"/>
<link href="css/styles.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/itemsstyle.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>

<c:forEach items="${itemsList}" var="item" >
<div class="item-container">

<div class = "image-container">
<img src="./images/${item.getImage()}" class="img" alt="">
</div>

<div><p>${item.getName()}</p></div>
<div><span class="span">${item.getPrice()} $</span></div>
<div><p>Available:  ${item.getAvailable()}</p></div>
<div class="img item_add">
<a href="#"><img src="./images/ca.png" alt=""></a>
</div>


</div>
</c:forEach>

</body>
</html>

