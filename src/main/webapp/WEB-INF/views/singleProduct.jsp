<!-- the head -->
<%@include file="./view-modules/head.jsp"%>

<body>


	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>


	<div class="w3-half w3-display-topmiddle"> 
		<h1 class="w3-text w3-center jumbotron">${product.pname}</h1>

		<img class="thumbnail "
			src="resources/productImages/a.jpg" width="100%" height="100%"></img>

		<div id="prating${product.id }"></div>
		<script>
$(function () {
	   $("#prating${product.id}").rateYo({
	    starWidth:"20px",
	    ratedFill:"#FFD300",
	    normalFill:"#DCDCDC",
		rating: ${product.prating},
	    readOnly: true
	  });
	});
</script>

		<h3 class="w3-text">Rs.${product.pprice }</h3>

		<h3 class="w3-text">${product.pdesc }</h3>
		
		<button id="${product.pname }" class="w3-button w3-black s3-text w3-wide" onclick="addToCart(this)"><h5>ADD TO CART</h5></button>
		
		<button class="w3-button w3-black" id="${product.pname}" onclick="buyNow(this)">
		<h5 class="w3-text w3-wide">BUY</h5>
		</button>
	
	</div>
<script type="text/javascript">
function buyNow(x){
	location.href="buy?name="+x.id;
}

function addToCart(product){
	
	if(${pageContext.request.userPrincipal.name!=null}){
		$.ajax({
			type:"GET",
			url:"http://localhost:4085/plantshop/addToCart?pname="+product.id+"&useremail=${pageContext.request.userPrincipal.name}",
			success:function(res){
				if(res=="success"){
				toastr.success("added to cart");
				}
				else{
					toastr.warning("product already added to cart");
				}
			}
		});
		
	}
	else{
		toastr.error("please login to add to cart");
}
}
</script>






<br>
<br>
	<!-- <footer class="w3-black w3-center"
		style="height: 50px; position: absolute; bottom: 0; width: 100%; background: url('resources/static/3570455-4k-wallpaper-grass.jpg')">
		<p class="w3-text w3-wide">PLANTSHOP</p>
	</footer> -->

</body>
</html>