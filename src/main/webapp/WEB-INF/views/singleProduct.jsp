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
		
		<button class="w3-button w3-teal w3-big" id="${product.pname}" onclick="buyNow(this)">
		<h3>Proceed to Buy!</h3>
		</button>
	
	</div>
<script type="text/javascript">
function buyNow(x){
	location.href="buy?name="+x.id;
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