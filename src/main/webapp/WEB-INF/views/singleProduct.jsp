<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="w3-sidebar w3-bar-block w3-card-2 w3-animate-left w3-white" style="display:none;" id="mySidebar">
    <div class="w3-bar-item w3-button" onclick="w3_close()">Close &times;</div>
   <c:forEach items="${menus}" var="menu">
   <a class="w3-button" href="category?name=${menu.name}">
   <div class="w3-wide">
   <strong>${menu.name}</strong>
   </div>
   <p>${menu.desc }</p>
   </a>
   </c:forEach>
   
  </div>
  
  
   <div zclass="w3-main" id="main">
  <div class="w3-container w3-white w3-animate-bottom" style="/*background:url('resources/static/walnuts_heart_shell_108742_3840x2160.jpg')*/">
    <button class=" w3-button w3-left w3-wide w3-hover-w3-text-green" id="barButton" onclick="w3_open()">MENU</button>
    
    <button class=" w3-button w3-text w3-display-topmiddle w3-wide w3-hover-white" style="align:center"><i class="fa fa-leaf fa-lg"></i>PLANTSHOP</button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-button w3-row w3-wide w3-right w3-hover-w3-text-green">SIGN IN</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-row w3-wide w3-right w3-hover-w3-text-green">REGISTER</button>
   
  </div>



</body>
</html>