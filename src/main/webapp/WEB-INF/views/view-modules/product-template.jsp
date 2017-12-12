
<br>
<br>
<input type="text" oninput="w3.filterHTML('#name','#card',this.value)" placeholder="search products"
	class="w3-input w3-text w3-border w3-margin" style="width: 70%" />
<button class="w3-button w3-black w3-margin">Search</button>
<br>

<hr>
<div class="w3-row-padding">
<div id="append"></div>
<script type="text/html" id="template">
		<div class="w3-container w3-margin-bottom w3-col m6 l4" id="card">
			<div style="width: 90%" >
				<div id="{{pname}}"
					class="w3-card-4 w3-border w3-border-black w3-hover-black"
					style="width: 90%">
					<div>
						<div class="w3-left">
							<h3 class="w3-text" id="name">{{pname}}</h3>
							<img src="resources/static/cup_tea.jpg" width="100%" /> <br>
							<h4 class="w3-text">{{pdesc}}</h4>
							<div id="prating{{id}}"></div>
			
						</div>
						<br>
						<h4 class="w3-text w3-right">Rs.{{pprice}}</h4>
					</div>
					<br>
					<button id="{{pname}}" class="w3-button w3-black" onclick="addToCart(this)">Add
						to cart!</button>
					<button id="{{pname}}" class="w3-button w3-black" onclick="buy(this)">Buy
						it Now!</button>
					<security:authorize access="hasRole('ADMIN')">
						<button id="{{pname}}" class="w3-button w3-black" onclick="deleteItem(this)">Delete Product</button>
					</security:authorize>
				</div>
			</div>
		</div>
</script>

</div>

<div id="product"></div>
<script>

var template=$("#template").html();	
		$(function(){
			$.ajax({
				type:"GET",
				url:"http://localhost:4085/plantshop/product/json",
				success:function(products){
					var products=$.parseJSON(products);
					$.each(products,function(i,product){
						$('#append').append(Mustache.render(template,product));
					})
					
				}
			});
		})
		
	
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
<script>
function buy(x){
	location.href="singleProduct?name="+x.id;
}
function deleteItem(x){
			location.href="delete?name="+x.id;
			toastr.success("deleted"+x.id);
			setTimeOut(function(){
				$.ajax({
				type:"GET",
				url:"http://localhost:4085/plantshop/product/json",
				success:function(products){
					var products=$.parseJSON(products);
					$.each(products,function(i,product){
						$('#append').append(Mustache.render(template,product));
					})
					
				}
			});
			},500);
}
</script>
<style>
.checked {
	color: orange;
}
</style>