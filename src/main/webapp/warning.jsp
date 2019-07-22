<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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
PLEASE, LOGIN AS ADMIN
</body>
</html>