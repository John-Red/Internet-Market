<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${param.lang}" />
<fmt:setBundle basename="registration" />

<html lang="${param.lang}">
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="css/registration.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<div>
      		<a href="?lang=en"><img src="./img/en.png" class="en-ru-img"></a>
      		<a href="?lang=ru"><img src="./img/ru.png" class="en-ru-img"></a>
      		</div>
		<div class="container-login">
			<div>
				<form method="post">
				<div  class="wrap-login">
          <span> <fmt:message key="label.registration" /> </span>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="login" placeholder="<fmt:message key="label.login" />" pattern="(?=.*[a-z]).{4,}"
						title="<fmt:message key="label.loginMust" />" required>
					</div>
					<div class="" data-validate="Password is required">
					<input class="" type="password" id="psw" name="pass" placeholder="<fmt:message key="label.password" />" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="<fmt:message key="label.passwordMust" />" required>
					</div>
					</div>
				 <input type="submit" class = "sign-up" value="<fmt:message key="label.signUp" />">
          </form>
          <div style="messg">
           <div id="message" class="wrap-message">
                    <span><fmt:message key="label.following" /></span>
                    <p id="letter" class="invalid"><b><fmt:message key="label.lowercase" /></b> letter</p>
                    <p id="capital" class="invalid"><b><fmt:message key="label.capital" /></b> letter</p>
                    <p id="number" class="invalid"><b><fmt:message key="label.number" /></b></p>
                    <p id="length" class="invalid"><fmt:message key="label.minimum" /><b><fmt:message key="label.characters" /></b></p>
                  </div>
           </div>
        </div>
        <script src="js/registration.js"></script>
					</form>
</body>
</html>