<div id="id01" class="w3-modal">
		<div
			class="w3-modal-content w3-card-4 w3-animate-top w3-border w3-border-white">

			<header class="w3-container w3-white"> <span
				onclick="document.getElementById('id01').style.display='none'"
				class="w3-button w3-hover-red w3-display-topright">&times;</span>
			<h1>New user?</h1>
			<hr>
			</header>

			<div class="w3-container w3-white" style="">
				<br>
				<div id="register">
					<form action="register" method="post">
						<label for="Name">Name</label> <br> <input
							class="w3-input w3-text" type="text" name="name" id="name" /> <br>
						<label for="email">Email</label> <br> <input
							placeholder="example@domain.com" data-validation="email"
							class="w3-input w3-text" type="email" name="email" id="email">
						<br> <label for="phone">Mobile Number</label> <br> <input
							data-validation="number" class="w3-input w3-text" type="text"
							name="mobile" id="mobile"> <br> <label
							for="password">Password</label> <br> <input
							placeholder="8-20 characters. Hover to show password!"
							onmouseover="this.setAttribute('type','text')"
							onmouseout="this.setAttribute('type','password')"
							data-validation="length" data-validation-length="8-20"
							class="w3-input w3-text" type="password" name="password"
							id="password"> <br> <input
							class="w3-button w3-black" type="submit" value="Register">
						<br>
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
