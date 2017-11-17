<!-- the head -->
<%@include file="./view-modules/head.jsp"%>

<body>
	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>

  <br>
  
  
 <h1>${menuName}</h1>
  <br>
  <hr>
  
  <!-- template for products -->
	<%@include file="./view-modules/product-template.jsp"%>
	

	<!-- footer and styles -->
<%-- 	<%@include file="./view-modules/footer.jsp"%>
 --%>
</body>
</html>