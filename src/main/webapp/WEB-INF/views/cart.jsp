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
	
			<tr class="w3-black">
				<th class="w3-text w3-wide">PRODUCT NAME</th>
				<th class="w3-text w3-wide">QUANTITY</th>
				<th class="w3-text w3-wide">PRICE</th>
				<th class="w3-text w3-wide">RATING</th>
				<th class="w3-text w3-wide">DESCRIPTION</th>
				<th class="w3-text w3-wide">REMOVE</th>
			</tr>
			
			<tbody id="tableappend">
			
			</tbody>
	</table>
<h3 class="w3-text w3-wide"></h3>
<h1 class="w3-text w3-center">
TOTAL:<p id="totalprice"></p>
	</h1>
	<div class="w3-bar">
	<button class=" w3-left w3-button w3-black" onclick="location.href='home'">
		<h6 class="w3-text w3-wide">CONTINUE SHOPPING</h6>
	</button>
	<button class="w3-right w3-button w3-black" onclick="location.href='payment'">
		<h6 class="w3-text w3-wide">CONFIRM ORDER</h6>
	</button>
	</div>
<script type="text/html" id="tableTemplate">	
		<tr>
			<td>{{pname}}</td>
			<td>
					<input id="quantity" name="{{pprice}}" style="width:50px" min="1" max="10" class="w3-input" type="number" value="1" onblur="updatePrice(this)"/>
					
			</td>
			<td>{{pprice}}</td>
			<td>{{prating}}</td>
			<td>{{pdesc}}</td>
				<td><button id="{{pname}}" class="w3-button w3-red w3-hover-black" onclick="removeItem(this)">X</button></td>
		</tr>
</script>
	<script>
	var tableTemplate=$("#tableTemplate").html();
	var price=0;
	$(document).ready(function() {
		$.ajax({
			type:"GET",
			url:"http://localhost:4085/plantshop/getCartItems?useremail=${pageContext.request.userPrincipal.name}",
			success:function(products){
				var products=$.parseJSON(products);
				if(products!=null){
				$.each(products,function(i,product){
					price+=Number(product.pprice);	
					$('#tableappend').append(Mustache.render(tableTemplate,product));
				})
				$('#totalprice').html(price);
				}
			else{
				$('h3').html("CART IS EMPTY");
			}
			}
		});
		
	} );
	var prevValue=1;
	function updatePrice(product){
		toastr.success("Increased Quantity");
		if(product.value<prevValue){
			$('#totalprice').html(Number($('#totalprice').html())-(Number(product.name)*(prevValue-product.value)));
		}
		else{
			$('#totalprice').html(Number($('#totalprice').html())+(Number(product.name)*(product.value-prevValue)));
		}
	
	}
	
	function removeItem(product){ 
		$.ajax({
			type:"GET",
			url:"http://localhost:4085/plantshop/removeFromCart?pname="+product.id+"&useremail=${pageContext.request.userPrincipal.name}",
			success:function(data){
				toastr.success("product removed from cart");
				location.reload();
			}
		})
	}
	</script>	



	<!-- footer and styles -->
	<%@include file="./view-modules/footer.jsp"%>

</body>


