<div id="id02" class="w3-modal">

		<div id="login_modal"
			class="w3-modal-content w3-card-4 w3-animate-top w3-border w3-border-white">

			<header class="w3-container w3-white"> <span
				onclick="document.getElementById('id02').style.display='none'"
				class="w3-button w3-hover-red w3-display-topright">&times;</span>
			<h1>Log in</h1>
			<hr>
			</header>

			<div class="w3-container w3-white" style="">
				<br>
				<div id="login">
					<form name="login-form" method="POST" action="login">
						<label for="email">Email</label> <br> <input
							placeholder="example@domain.com" data-validation="email"
							class="w3-input" type="email" name="email-login" id="email-login">
						<br> <label for="password">Password</label> <br> <input
							onmouseover="this.setAttribute('type','text')"
							onmouseout="this.setAttribute('type','password')"
							placeholder="Hover to show password!" data-validation="length"
							data-validation-length="8-16" class="w3-input" type="password"
							name="password-login" id="password-login"> <br>
						<p id="login-password-error-text"></p>
						<br> <input type="submit" class="w3-button w3-black"
							value="Log In" /> <br>
					</form>
					<script>
  $.validate({
    lang: 'en'
  });
  
</script>
				</div>
			</div>


		</div>
	</div>
