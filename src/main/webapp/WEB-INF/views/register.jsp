
<%@include file="./view-modules/head.jsp"%>
<body>
	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
	<div onclick="w3_close()">
	<div class="w3-half w3-display-middle">
	
	 
	<header class="w3-container w3-white"> 
			<h1>New user?</h1>
			<hr>
			</header>
		<form action="register" method="post">
			<label for="Name">Name</label> <br>
			 <input
				class="w3-input w3-text" type="text" name="name" id="name" /> <br>
			<label for="email">Email</label> <br> 
			<input
				placeholder="example@domain.com" data-validation="email"
				class="w3-input w3-text" type="email" name="email" id="email" onblur="checkRegister(this)">
			<br>
				<label for="email">Address</label> <br> 
			<input
				class="w3-input w3-text" type="text" name="address" id="address" >
				
			<br> <label for="phone">Mobile Number</label> <br>
			 <input
				data-validation="number" class="w3-input w3-text" type="text"
				name="mobile" id="mobile"> <br> <label for="password">Password</label>
			<br>
			 <input
				placeholder="8-20 characters. Hover to show password!"
				onmouseover="this.setAttribute('type','text')"
				onmouseout="this.setAttribute('type','password')"
				data-validation="length" data-validation-length="8-20"
				class="w3-input w3-text" type="password" name="password"
				id="password"> <br>
				 <input class="w3-button w3-black"
				type="submit" value="Register"> <br>
		</form>
</div>
</div>
	</div>
<script>
function checkRegister(register){
	
	$.ajax({
		type:"get",
		url:"http://localhost:4085/plantshop/checkRegister?name="+register.value,
		success:(data)=>{
			if(data=="yes"){
				toastr.error("email already exists! you are now redirected to login page");
			setTimeout(()=>{window.location.href="loginpage";},1000);	
			}
		}
	})
}

</script>
</body>
</html>