<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<link href="css/bootstrap.css.map" rel="stylesheet" type="text/css" media="all"/>
<link href="css/styles.css" rel="stylesheet" type="text/css" media="all"/>
<style>
.image-container{
width: 200px;
height: 300px;
}
.img{
width: auto;
height: auto;
max-width:200px;
max-height:300px;
}
html,body{
	background:#fff;
	font-size: 100%;
	font-family:'Oxygen-Regular';
}
.span {
    font-size: 0.9em;
    color: #F67777;
    line-height: 1.8em;
    font-family: 'Ubuntu-Bold';
}
.item-container {
display: flex;
display:inline-block;
position:relative;
border: 1px solid #EFECEC;
padding: 10px;

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

