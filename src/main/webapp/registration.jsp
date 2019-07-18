<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link href="css/registration.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
		<div class="container-login">
			<div>
				<form method="post">
				<div  class="wrap-login">
          <span> Account Login </span>
					<div class="wrap-input100 validate-input">
						<input class="input100" type="text" name="login" placeholder="Login" pattern="(?=.*[a-z]).{4,}"
						title="Must contain at least 4 or more characters" required>
					</div>
					<div class="" data-validate="Password is required">
					<input class="" type="password" id="psw" name="pass" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
					</div>
					</div>
				 <input type="submit" value="Sign Up">
          </form>
          <div style="messg">
           <div id="message">
                    <span>Password must contain the following:</span>
                    <p id="letter" class="invalid"> A <b> lowercase</b> letter</p>
                    <p id="capital" class="invalid"> A <b>capital (uppercase)</b> letter</p>
                    <p id="number" class="invalid"> A <b>number</b></p>
                    <p id="length" class="invalid"> Minimum <b>8 characters</b></p>
                  </div>
           </div>
        </div>
        <script src="js/registration.js"></script>
					</form>
			</div>
			<div><span>${incorrect}</span></div>
		</div>
</body>
</html>