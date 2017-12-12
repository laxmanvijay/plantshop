<div class='preloader'><div class='loaded'>&nbsp;</div></div>
        <header style="width:100%" id="home" class="navbar-fixed-top">
   
   
   <!-- side bar -->     
   <div class="w3-sidebar w3-bar-block w3-card-2 w3-animate-left w3-white" style="display:none;" id="mySidebar">
    <div class="w3-bar-item w3-button" onclick="w3_close()">Close &times;</div>
   <c:forEach items="${menus}" var="menu">
   <a href="category?name=${menu.name}">
   <div class="w3-button">
   <div class="w3-wide">
   <strong>${menu.name}</strong>
   </div>
   <p>${menu.desc }</p>
   </div>
   </a>
   </c:forEach>
   
  </div>
  
  
   <div zclass="w3-main" id="main">
  <div class="w3-container w3-white w3-animate-bottom" style="/*background:url('resources/static/walnuts_heart_shell_108742_3840x2160.jpg')*/">
    <button class=" w3-button w3-left w3-wide w3-hover-black" id="barButton" onclick="w3_open()">MENU</button>
    
    <button onclick="location.href='home'" class=" w3-button w3-text w3-display-topmiddle w3-wide w3-hover-white" style="align:center"><i class="fa fa-leaf fa-lg"></i>PLANTSHOP</button>
  <c:choose>
      <c:when test="${pageContext.request.userPrincipal.name!=null}">
      <div class=" w3-right w3-dropdown-hover">
     <button class="w3-button w3-row w3-wide w3-hover-black">${pageContext.request.userPrincipal.name}</button>
   		 <div id="Demo" class="w3-dropdown-content w3-bar-block w3-border">
    <button onclick="location.href='cart'" class="w3-bar-item w3-button w3-hover-black">My Cart</button>
    <button onclick="location.href='orders'" class="w3-bar-item w3-button w3-hover-black">My Orders</button>
    
    <security:authorize access="hasRole('ADMIN')">
     <button onclick="location.href='orders'" class="w3-bar-item w3-button w3-hover-black">All Orders By Customers</button>
    </security:authorize>
     <button onclick="location.href='logout'" class="w3-bar-item w3-button w3-hover-black">Log Out</button>
  </div>
   
    </div>
</c:when>  
<c:otherwise>
 <button onclick="location.href='loginpage'" class="w3-button w3-row w3-wide w3-right w3-hover-black">SIGN IN</button>
    
    <button onclick="location.href='registerpage'" class="w3-button w3-row w3-wide w3-right w3-hover-black">REGISTER</button>

 </c:otherwise>
</c:choose>  
  <security:authorize access="hasRole('ADMIN')">
    <button onclick="location.href='adminpage'" class="w3-button w3-row w3-wide w3-right w3-hover-black">CREATE PRODUCT</button>
  </security:authorize>
     
  </div>
        
           </header>
        
        <script>
	function w3_open() {
		document.getElementById("main").style.marginLeft = "18%";
		document.getElementById("mySidebar").style.width = "18%";
		document.getElementById("mySidebar").style.display = "block";
		document.getElementById("openNav").style.display = 'none';
	}
	function w3_close() {
		document.getElementById("main").style.marginLeft = "0%";
		document.getElementById("mySidebar").style.display = "none";
		document.getElementById("openNav").style.display = "inline-block";
	}
</script>