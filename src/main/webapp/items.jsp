<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<link href="./css/bootstrap.css.map" rel="stylesheet" type="text/css" media="all"/>
<style>
.item-container {
display: flex;
display:inline-block;

flex-flow: row wrap;
    justify-content: space-between;
    margin: 0;
    padding: 16px 20px 12px;
}
</style>
</head>

<body>
<c:forEach items="${itemsList}" var="item" >
<div class="item-container">
<div class=""><img alt="item image" src=""></div>
<div><p>${item.getName()}</p></div>
<div><span>${item.getPrice()} $</span></div>
<div><p>Available:  ${item.getAvailable()}</p></div>
<div><button>BUY</button></div>
</div>

</c:forEach>
</body>
</html>