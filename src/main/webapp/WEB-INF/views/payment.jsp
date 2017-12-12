  <%@include file="./view-modules/head.jsp"%> 

<body>


	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
<div class="w3-display-middle">

	<button id="pay" class="w3-button w3-black w3-wide w3-margin" onclick="thankYou()">MAKE PAYMENT</button>
	
	<h5 class="w3-text w3-wide"></h5>
	<button id="continue" class="w3-button w3--black w3-wide" onclick="location.href='home'"><h4></h4></button>
	</div>
	
	<script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
	<script>
	$(()=>{
		$('#continue').hide();
	})
	
	
	function thankYou(){
	
			$.ajax({
				type:"GET",
				url:"http://localhost:4085/plantshop/placeOrder?name=${pageContext.request.userPrincipal.name}",
				success:function(){
					console.log("done");
				}
			});
			$('h5').html("THANK YOU FOR SHOPPING<br>WITH US!<BR>AN INVOICE IS GENERATED<BR> FOR YOUR REFERENCE");
			$('#pay').hide();
			$('#continue').show();
			$('h4').html("CONTINUE SHOPPING");
			var doc = new jsPDF();
			var date=new Date();
			var d=date.getDate();
			var m=date.getMonth();
			var y=date.getYear();
			var Todaydate=d + '/'+ m + '/'+ y;
			date.setDate(date.getDate()+6);
			var d=date.getDate();
			var m=date.getMonth();
			var y=date.getYear();
			var EstimatedDate=d + '/'+ m + '/'+ y;
			var transaction="Your TransactionId is:"+Math.floor(Math.random()*1000000);
			
			doc.text('PLANTSHOP.\n\n\nThank You for purchasing!\n\n Your purchase mail id is:${pageContext.request.userPrincipal.name}\n\n'+transaction +"\n"+'Your order Date:'+Todaydate+"\nEstimated Delivery Date:"+EstimatedDate , 10, 10);
			doc.save('invoice.pdf');
	}
	
	</script>
	</body>
	
	</html>