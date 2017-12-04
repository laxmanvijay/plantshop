
<%@include file="./view-modules/head.jsp"%>
<body>
	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
	<div onclick="w3_close()">
	<div class="w3-half w3-display-middle"> 
		<div class="">
	<header class="w3-container w3-white"> 
			<h1>New user?</h1>
			<hr>
			</header>
		<form action="addProduct" method="post" enctype="multipart/form-data">
						<label for="Name">Product Name</label> <br> 
						<input
							data-validation="length" data-validation-length="1-100"
							class="w3-input w3-text" type="text" name="pname" id="pname" /> <br>
						<label for="category">Category</label> <br> 
						<input
							data-validation="length" data-validation-length="1-100"
							placeholder="eg:home"
							class="w3-input w3-text" type="text" name="category" id="category">
						<br>
						<label for="rating">Rating</label><br>
						<input
							data-validation="number"
							placeholder="eg:4/5"
							class="w3-input w3-text" type="number" name="prating" id="prating">
						<br>
							<label for="price">Price</label><br>
						<input
							data-validation="number"
							placeholder="eg:Rs.400"
							class="w3-input w3-text" type="number" name="pprice" id="pprice">
						<br>
						 <label for="description">Description</label> <br>
						  <input
						  	data-validation="length" data-validation-length="10-200"
							class="w3-input w3-text" 
							type="text"
							name="pdesc" id="pdesc"> <br>
							
							<label for="image">Image</label> <br>
						  <input
							class="w3-input w3-text" 
							type="file"
							name="pimg" id="pimg"> <br>
							
							 <input
							class="w3-button w3-black" type="submit" value="Create Product">
					</form>
					<script>
  $.validate({
    lang: 'en'
  });
</script>

</div>
	</div>
	</div>
</body>
</html>