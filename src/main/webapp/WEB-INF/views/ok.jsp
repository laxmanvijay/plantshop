  <%@include file="./view-modules/head.jsp"%> 

<body>


	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<div class="jumbotron">
	
	<h3 class="w3-text w3-wide w3-center">THANK YOU FOR YOUR FEEDBACK</h3>
	</div>
	<div class="w3-center">
		<input class="w3-button w3-black " type="submit" name="_eventId_success" value="HOME"  onclick="location.href='${flowExecutionUrl}&_eventId_toHome'"/>
	</div>
	</div>
	</body>
	</html>