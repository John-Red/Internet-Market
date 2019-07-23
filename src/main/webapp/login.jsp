<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="login" />

<html lang="${param.lang}">
<head>
<link href="css/registration.css" rel="stylesheet" type="text/css" media="all"/>
    <title>Login</title>
</head>
<body>
<div>
<a href="?lang=en"><img src="./img/en.png" class="en-ru-img"></a>
<a href="?lang=ru"><img src="./img/ru.png" class="en-ru-img"></a>
</div>
<div class="container-login">
    <div class="wrap-login">
        <span><fmt:message key="label.SignIn" /></span><br>
        <form method="post" action="">
            <input type="text" required placeholder="<fmt:message key="label.login" />" name="login"><br>
            <input type="password" required placeholder="<fmt:message key="label.password" />" name="password"><br><br>
            <input type="submit"  class = "sign-up" value="<fmt:message key="label.SignIn" />" >
        </form>
        <span class="to-registration"><fmt:message key="label.needAcc" /><a href="/registration?lang=en" class="to-registration-src"> <fmt:message key="label.SignUp" /></a></span>
    </div>
    </div>
</body>
</html>

