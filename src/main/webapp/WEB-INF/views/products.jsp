<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta charset="UTF-8">
    <title>${menuName }</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="resources/static/Stork-Circle-Favicon.png" type="image/x-icon">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>
<link href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css" rel="stylesheet"/>
<style>
html,body,h1,h2,h3,h4,h5,h6,label {font-family: "Roboto", sans-serif}
</style>
   <!-- <script src="./w3.js"></script>
    <script src="./src/main.js"></script>-->
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
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
  <div class="w3-row-padding">
<c:forEach items="${products}" var="product">
<div class="w3-card w3-col m4 l3">
<div class="w3-left">
<h3 class="w3-text">${product.pname}</h3>
<img src="resources/static/${product.pimg}" width="100%"/>
<p class="w3-text">${product.pdesc}</p>
<p class="w3-text">${product.prating}</p>
</div>
<h4 class="w3-text w3-right">${product.pprice}</h4>

</div>
</c:forEach>
</div>
</body>
</html>