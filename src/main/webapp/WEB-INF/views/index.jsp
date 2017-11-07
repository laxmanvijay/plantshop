<!-- the head -->
<%@include file="./view-modules/head.jsp"%>

<body style="position:relative">


	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>


	<!-- carousal view -->
	<%@include file="./view-modules/carousal.jsp"%>


	<div id="app"></div>

	<!--modal box for login-->
	<%@include file="./view-modules/login-modal.jsp"%>

	<!--modal box for register-->
	<%@include file="./view-modules/register-modal.jsp"%>


	<div class="w3-container w3-border-bottom w3-border-black">
		<h1 class="w3-text">Latest Products</h1>
	</div>
	<hr>

	<!-- template for products -->
	<%@include file="./view-modules/product-template.jsp"%>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<!-- footer and styles -->
	<%@include file="./view-modules/footer.jsp"%>

</body>
</html>