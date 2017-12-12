  <%@include file="./view-modules/head.jsp"%> 

<body>
	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
	
	
	<br>
<br>
<br>
<br>
<table id="table" class="w3-table-all w3-hoverable w3-margin">
	
			<tr class="w3-black">
				<th class="w3-text w3-wide">PRODUCT NAME</th>
				<th class="w3-text w3-wide">QUANTITY</th>
				<th class="w3-text w3-wide">PRICE</th>
				<th class="w3-text w3-wide">RATING</th>
				<th class="w3-text w3-wide">DESCRIPTION</th>
				<th class="w3-text w3-wide">EMAIL</th>
			</tr>
			
			<tbody id="tableappend">
			
			</tbody>
	</table>
	
	<script type="text/html" id="tableTemplate">	
		<tr>
			<td>{{pname}}</td>
			<td>
					<input id="quantity" name="{{pprice}}" style="width:50px" min="1" max="10" class="w3-input" type="number" value="1" disabled/>
					
			</td>
			<td>{{pprice}}</td>
			<td>{{prating}}</td>
			<td>{{pdesc}}</td>
		</tr>
</script>	
	<script type="text/javascript">
	var tableTemplate=$("#tableTemplate").html();
	$(document).ready(function() {
		$.ajax({
			type:"GET",
			url:"http://localhost:4085/plantshop/ordersItems?name=${pageContext.request.userPrincipal.name}",
			success:function(products){
				var products=$.parseJSON(products);
				$.each(products,function(i,product){	
					$('#tableappend').append(Mustache.render(tableTemplate,product));
				})
			}
		});	
	});
</script>
	
	</body>
</html>
	