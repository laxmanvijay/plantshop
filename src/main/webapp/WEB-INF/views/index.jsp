<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
    <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
    <meta charset="UTF-8">
    <title>Plantshop</title>
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
   <div class="w3-button">
   <div class="w3-wide">
   <strong>${menu.name}</strong>
   </div>
   <p>${menu.desc }</p>
   </div>
   </c:forEach>
   
  </div>
  
  
   <div zclass="w3-main" id="main">
  <div class="w3-container w3-white w3-animate-bottom" style="/*background:url('resources/static/walnuts_heart_shell_108742_3840x2160.jpg')*/">
    <button class=" w3-button w3-left w3-wide w3-hover-w3-text-green" id="barButton" onclick="w3_open()">MENU</button>
    
    <button class=" w3-button w3-text w3-display-topmiddle w3-wide w3-hover-white" style="align:center"><i class="fa fa-leaf fa-lg"></i>PLANTSHOP</button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-button w3-row w3-wide w3-right w3-hover-w3-text-green">SIGN IN</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-button w3-row w3-wide w3-right w3-hover-w3-text-green">REGISTER</button>
   
  </div>
 <!--
 <nav class="navbar w3-black">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle w3-hover-red" data-toggle="collapse" data-target="#myNavbar"><i class="fa fa-bars"></i></button>
        <a class="navbar-brand w3-text-white" href="#" style="margin:7px">2dots Diary</a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav">
          <li class="active"><a href="#" class="w3-border w3-border-white w3-hover-red" style="margin:7px">
            <div class="w3-text-white"><i class="fa fa-home fa-lg" aria-hidden="true"></i> Home</div></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a>
              <div class="box foo w3-hover-black">
                  <span class="glyphicon glyphicon-user"></span> register
              </div></a></li>
          <li><a>
              <div class="box foo w3-hover-black">
                  <span class="glyphicon glyphicon-log-in"></span> Login
              </div></a></li>
        </ul>
      </div>
    </div>
  </nav>
-->
  
 <!-- <div class="container" style="width:100%;margin:none">
    <div class="jumbotron w3-center" style="margin:none;width:100%">
      <h1>2dots Diary</h1> 
      <p>Simplify your life with online diary.</p> 
    </div>
  </div>-->
<div class="">
<div id="myCarousel" class="carousel slide carousel-fade" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    
    <li data-target="#myCarousel" data-slide-to="1"></li>
    
    <li data-target="#myCarousel" data-slide-to="2"></li>
    
    <li data-target="#myCarousel" data-slide-to="3"></li>
    
    <li data-target="#myCarousel" data-slide-to="4"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="resources/static/plants.jpg" alt="" style="width:100%;height:500px">
      <div>
    <!--    <button class="w3-button w3-left w3-margin box foo w3-hover-black w3-border w3-border-green" id="barButton" onclick="w3_open()"><i class="fa fa-bars"></i></button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-sign-in fa-lg"></i> Sign in</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-user-plus fa-lg"></i> Register</button>
   --></div>
         <div class="w3-padding w3-display-middle w3-wide  "><p style="font-size:90px;color:white">PlantShop</p>
          <br>
          <hr>
          <h2>
          <p style="color:white">Welcome to plant shop.</p></div>
          </h2>
        </div>
        <div class="item">
      <img src="resources/static/flowers_field_yellow_plants_113564_3840x2160.jpg" alt="" style="width:100%;height:500px">
     <div>
   <!--     <button class="w3-button w3-left w3-margin box foo w3-hover-black w3-border w3-border-green" id="barButton" onclick="w3_open()"><i class="fa fa-bars"></i></button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-sign-in fa-lg"></i> Sign in</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-user-plus fa-lg"></i> Register</button>
  --> </div>
        <div class="w3-padding w3-display-middle w3-wide  "><p style="font-size:90px;color:white">agricultural</p>
            <br>
            <hr>
            <h2>
      <p style="color:white">All agricultural needs</p></h2>
      </div></div>
        <div class="item">
      <img src="resources/static/coffeecup.jpg" alt="" style="width:100%;height:500px">
      <div>
    <!--     <button class="w3-button w3-left w3-margin box foo w3-hover-black w3-border w3-border-green" id="barButton" onclick="w3_open()"><i class="fa fa-bars"></i></button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-sign-in fa-lg"></i> Sign in</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-user-plus fa-lg"></i> Register</button>
  --> </div>
          <div class="w3-padding w3-display-middle w3-wide  "><p style="font-size:90px;color:white">Natural products</p>
            <br>
            <hr>

            <h2><p style="color:white">It's time for nature to take lead</p></h2>
      </div>
    </div>
        <div class="item">
      <img src="resources/static/toxic-and-non-toxic-plants.jpg" alt="" style="width:100%;height:500px">
      <div>
     <!--   <button class="w3-button w3-left w3-margin box foo w3-hover-black w3-border w3-border-green" id="barButton" onclick="w3_open()"><i class="fa fa-bars"></i></button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-sign-in fa-lg"></i> Sign in</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-user-plus fa-lg"></i> Register</button>
   --></div>
         <div class="w3-padding w3-display-middle w3-wide  "><p style="font-size:90px;color:white">Ornamental</p>
           <br>
           <hr>
           <h2><p style="color:white">Make our environment!!!</p></h2></div>
      </div>
        <div class="item">
      <img src="resources/static/deer.jpg" alt="" style="width:100%;height:500px">
      <div>
      <!--   <button class="w3-button w3-left w3-margin box foo w3-hover-black w3-border w3-border-green" id="barButton" onclick="w3_open()"><i class="fa fa-bars"></i></button>
      
    <button onclick="document.getElementById('id02').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-sign-in fa-lg"></i> Sign in</button>
  
   <button onclick="document.getElementById('id01').style.display='block'" class="w3-row w3-button w3-margin w3-right box foo w3-hover-black w3-border w3-border-green"><i class="fa fa-user-plus fa-lg"></i> Register</button>
  --> </div>
        <div class="w3-padding w3-display-middle w3-wide "><p style="font-size:90px;color:white">Making life</p><br>
           <hr>
            <h2><p style="color:white;">Create a space for every life.</p></h2>
      </div>
    </div>
</div>
  </div>

</div>
  </div>
  <br>
  <br>
  <br>
  <!--  
  <div class="row">
  <div class=" col-xs-4 w3-card-4">
  <img src="resources/static/agri4k.jpg" alt="Norway" style="width:100%">
  <div class="w3-container w3-center">
    <p>The Troll's tongue in Hardanger, Norway</p>
  </div>
</div>
<div class="col-xs-4 w3-card-4">
  <img src="resources/static/agri4k.jpg" alt="Norway" style="width:100%">
  <div class="w3-container w3-center">
    <p>The Troll's tongue in Hardanger, Norway</p>
  </div>
</div>
<div class="col-xs-4 w3-card-4">
  <img src="resources/static/agri4k.jpg" alt="Norway" style="width:100%">
  <div class="w3-container w3-center">
    <p>The Troll's tongue in Hardanger, Norway</p>
  </div>
</div>
</div>
-->
<div id="app">
  
</div>

<!--modal box-->
<div id="id02" class="w3-modal">

  <div class="w3-modal-content w3-card-4 w3-animate-top w3-border w3-border-white">
        
            <header class="w3-container w3-white">
                 <span onclick="document.getElementById('id02').style.display='none'" class="w3-button w3-hover-red w3-display-topright">&times;</span>
              <h1>Log in</h1>
              <hr>
            </header>
            
            <div class="w3-container w3-white" style="">
              <br>
              <div id="login">
                <form action="login" method="post">
                <label for="email">Email</label>
                <br>
                <input class="w3-input" type="email" name="email-login" id="email-login">
                <br>
                <label for="password">Password</label>
                <br>
                <input class="w3-input" type="password" name="password-login" id="password-login">
                <br>
                <input class="w3-button w3-black" type="submit" value="Log In"/>
            <br>
              </form>
            </div>
        </div>
      
        
</div>
</div>

<div id="id01" class="w3-modal">
<div class="w3-modal-content w3-card-4 w3-animate-top w3-border w3-border-white">

      <header class="w3-container w3-white">
          <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-hover-red w3-display-topright">&times;</span>
          <h1>New user?</h1>
          <hr>
      </header>
      
      <div class="w3-container w3-white" style="">
        <br>
        <div id="register">
          <form action="register" method="post">
        <label for="Name">Name</label>
        <br>
        <input class="w3-input" type="text" name="name" id="name"/>
        <br>
        <label for="email">Email</label>
        <br>
        <input class="w3-input" type="email" name="email" id="email">
        <br>
         <label for="phone">Mobile Number</label>
        <br>
        <input class="w3-input" type="text" name="mobile" id="mobile">
        <br>
        <label for="password">Password</label>
        <br>
        <input class="w3-input" type="password" name="password" id="password">
        <br>
        <input class="w3-button w3-black" type="submit" value="Register">
        <br>
        </form>
      </div>
   </div>
</div>
</div>

<h3 class="w3-text w3-wide">Products</h3>
<hr>
      <table id="product_table" class="w3-table w3-hoverable w3-striped w3-centered">
    <thead>
        <tr>
           <th>S.no</th>
           <th>Name</th>
           <th>Description</th>
           <th>Rating</th>
           <th>Price</th>
        </tr>
    </thead>
   <!--   <tbody>
       <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.pname}</td>
            <td>${product.pdesc}</td>
            <td>${product.prating}</td>
            <td>${product.pprice}</td>
         </tr>
        </c:forEach>
    </tbody>-->
</table>
          
         
            <script>
           	$(document).ready(function(){
                $('#product_table').DataTable( {
                    "ajax": "http://localhost:4085/plantshop/product/json",
                    "columns": [
                        { "data": "id" },
                        { "data": "pname" },
                        { "data": "pdesc" },
                        { "data": "prating" },
                        { "data": "pprice" }
                    ]
                } );
            });
          </script>



<br>
<br>
<br>
<br>
<br>
<br>
<br>
<footer class="w3-card-4 w3-black w3-center" style="height:50px;background:url('resources/static/3570455-4k-wallpaper-grass.jpg')">
  <p class="w3-text w3-wide">PLANTSHOP</p>
</footer>
</div>
</div>
<!--<script>
    w3.slideshow(".slide23",3000);
</script>-->
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

<style>
  .carousel-fade .carousel-inner .item {
  opacity: 0;
  transition-property: opacity;
}

.carousel-fade .carousel-inner .active {
  opacity: 1;
}

.carousel-fade .carousel-inner .active.left,
.carousel-fade .carousel-inner .active.right {
  left: 0;
  opacity: 0;
  z-index: 1;
}

.carousel-fade .carousel-inner .next.left,
.carousel-fade .carousel-inner .prev.right {
  opacity: 1;
}

.carousel-fade .carousel-control {
  z-index: 2;
}

/*
  WHAT IS NEW IN 3.3: "Added transforms to improve carousel performance in modern browsers."
  Need to override the 3.3 new styles for modern browsers & apply opacity
*/
@media all and (transform-3d), (-webkit-transform-3d) {
    .carousel-fade .carousel-inner > .item.next,
    .carousel-fade .carousel-inner > .item.active.right {
      opacity: 0;
      -webkit-transform: translate3d(0, 0, 0);
              transform: translate3d(0, 0, 0);
    }
    .carousel-fade .carousel-inner > .item.prev,
    .carousel-fade .carousel-inner > .item.active.left {
      opacity: 0;
      -webkit-transform: translate3d(0, 0, 0);
              transform: translate3d(0, 0, 0);
    }
    .carousel-fade .carousel-inner > .item.next.left,
    .carousel-fade .carousel-inner > .item.prev.right,
    .carousel-fade .carousel-inner > .item.active {
      opacity: 1;
      -webkit-transform: translate3d(0, 0, 0);
              transform: translate3d(0, 0, 0);
    }
}


.box {
  position:relative;
  vertical-align: middle;
  color: #015FA5;
  display: inline-block;
  height: 40px;
  line-height: 40px;
  text-align: center;
  transition: 0.5s;
  padding: 0 20px;
  cursor: pointer;
  -webkit-transition:0.5s;
}

/*.box:hover {
  border: 2px solid rgba(0,160,80,0);
  color: #FFF;
}*/

.box::before, .box::after {
  width: 100%;
  height:100%;
  z-index: 3;
  content:'';
  position: absolute;
  top:0;
  left:0;
  -webkit-transform: scale(0);
  transition: 0.5s;
}

.foo::before {
  border-bottom: 3px solid #FFF;
  border-left: 3px solid #FFF;
  -webkit-transform-origin: 0 100%;
}

.foo::after {
  border-top: 3px solid #FFF;
  border-right: 3px solid #FFF;
  -webkit-transform-origin: 100% 0%;
}
.box:hover::after, .box:hover::before {
  -webkit-transform: scale(1);
}
  </style>
  <script>

  
  
  </script>
</body>
</html>