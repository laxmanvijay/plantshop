<!-- the head -->
<%@include file="./view-modules/head.jsp"%>

<body>
	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>

<br>
<br>
<br>
<br>

	<table id="table" class="w3-table-all w3-hoverable w3-margin">
	
			<tr>
				<th>product name</th>
				<th>Price</th>
				<th>Rating</th>
				<th>Description</th>
			</tr>
			
			<tbody id="tableappend">
			
			</tbody>
	</table>

Total price:<div id="totalprice"></div>
	
<script type="text/html" id="tableTemplate">	
		<tr>
			<td>{{pname}}</td>
			<td>{{pprice}}</td>
			<td>{{prating}}</td>
			<td>{{pdesc}}</td>
		</tr>
</script>
	<script>
	var tableTemplate=$("#tableTemplate").html();
	var price;
	$(document).ready(function() {
		$.ajax({
			type:"GET",
			url:"http://localhost:4085/plantshop/getCartItems?useremail=${pageContext.request.userPrincipal.name}",
			success:function(products){
				var products=$.parseJSON(products);
				$.each(products,function(i,product){
					price+=product.pprice;	
					$('#tableappend').append(Mustache.render(tableTemplate,product));
					$('#totalprice').html=price;
				})
				
			}
		});
		
	} );
	</script>	



	<!-- footer and styles -->
	<%@include file="./view-modules/footer.jsp"%>

</body>


