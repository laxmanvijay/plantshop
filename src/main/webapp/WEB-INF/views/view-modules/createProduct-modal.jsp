<div id="id03" class="w3-modal">
		<div
			class="w3-modal-content w3-card-4 w3-animate-top w3-border w3-border-white">

			<header class="w3-container w3-white"> <span
				onclick="document.getElementById('id03').style.display='none'"
				class="w3-button w3-hover-red w3-display-topright">&times;</span>
			<h1>Add Product</h1>
			<hr>
			</header>

			<div class="w3-container w3-white" style="">
				<div id="register">
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
	</div>
