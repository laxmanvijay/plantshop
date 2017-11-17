
<br>
<br>
<input type="text" oninput=w3.filterHTML("#name","#card",this.value) placeholder="search products"
	class="w3-input w3-text w3-border w3-margin" style="width: 70%" />
<button class="w3-button w3-black w3-margin">Search</button>
<br>
<hr>
<div class="w3-row-padding">
	<c:forEach items="${products}" var="product">
		<div class="w3-container w3-margin-bottom w3-col m6 l4" id="card">
			<div style="width: 90%" >
				<div id="${product.pname}"
					class="w3-card-4 w3-border w3-border-black w3-hover-black"
					style="width: 90%">
					<div>
						<div class="w3-left">
							<h3 class="w3-text" id="name">${product.pname}</h3>
							<img src="resources/productImages/${product.pname}.jpg" width="100%" /> <br>
							<h4 class="w3-text">${product.pdesc}</h4>
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
						</div>
						<br>
						<h4 class="w3-text w3-right">Rs.${product.pprice}</h4>
					</div>
					<br>
					<button class="w3-button w3-black" onclick="addToCart(this)">Add
						to cart!</button>
					<button class="w3-button w3-black" onclick="buy(this)">Buy
						it Now!</button>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
<script>
function buy(x){
	location.href="singleProduct?name="+x.parentElement.id;
}
$(function(){
/*	$.getJSON("http://localhost:4085/plantshop/product/json",function(data){
		console.log(data);
	});
	*/
	if(${loginStatus}==0){
		toastr.error("please enter a correct password!");
	}
	else if(${loginStatus}==-1){
		toastr.error("your email is not registered.Please register first");
	}
});
var cartItem=[];
function addToCart(product){
	//if(${loginStatus}==0){
		//toastr.error("please login to add to cart.But you can buy directly!");
	//}
	//else{
	cartItem.push(product.parentElement.id);
	if(JSON.parse(localStorage.getItem("cart"))==null) localStorage.setItem("cart",JSON.stringify([]));
	localStorage.setItem("cart",JSON.stringify((JSON.parse(localStorage.getItem("cart"))).push(cartItem)));
	console.log(localStorage.getItem("cart"));
	//}
}
function append(cartItem){
	var localItem=localStorage.getItem("cart");
	if(localItem==null) localItem="";
	return localItem+cartItem;
}
</script>
<style>
.checked {
	color: orange;
}
</style>