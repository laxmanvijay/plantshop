
<%@include file="./view-modules/head.jsp"%>
<body>
	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
	<div onclick="w3_close()">



		<div class="w3-half w3-display-middle">
   
		
			<form name="login-form" method="POST" action="perform_login">
				<label for="email">Email</label> <br> <input
					placeholder="example@domain.com" class="w3-input" type="email"
					name="username" id="username"> <br> <label
					for="password">Password</label> <br> <input
					onmouseover="this.setAttribute('type','text')"
					onmouseout="this.setAttribute('type','password')"
					placeholder="Hover to show password!" data-validation="length"
					data-validation-length="8-16" class="w3-input" type="password"
					name="password-login" id="password"> <br>
				<p id="login-password-error-text"></p>
				<br> <input type="submit" class="w3-button w3-black"
					value="Log In" /> <br> <input type="hidden"
					name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
			<script>
				$.validate({
					lang : 'en'
				});
			</script>
		</div>

	</div>
	</div>

</body>
</html>