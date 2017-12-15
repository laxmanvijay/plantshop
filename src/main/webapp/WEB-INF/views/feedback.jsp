
<%@include file="./view-modules/head.jsp"%>

<body>


	<!-- navbar and side bar -->
	<%@include file="./view-modules/navbar.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<style>

</style>
	<div class="w3-display-middle">
		<sf:form method="POST" modelAttribute="user" class=""
			id="feedbackform">


			
				<label class="w3-text w3-margin-bottom">  Name</label><br>
					<sf:input type="text" path="name" class="w3-border w3-input w3-margin-bottom"
						placeholder="First Name"  style="width:500px"/>
					<sf:errors path="name" cssClass="help-block" element="em" />
			

		
				<label class="w3-text w3-margin-bottom">FeedBack</label><br>
					<sf:textarea type="text" path="feedback" class="w3-border w3-input w3-margin-bottom"
						placeholder="Your Feedback..."  style="width:500px;height:200px"/>
					<sf:errors path="feedback" cssClass="help-block" element="em" />
		
		


		
		
					<button type="submit" name="_eventId_activate" class="w3-button w3-black">
						<DIV class="w3-text w3-wide">SUBMIT</DIV>
					</button>
		
		


		</sf:form>

	</div>

</body>
</html>
