<footer class="w3-black w3-center"
	style="height:50px;position:absolute;bottom:0;width:100%; background: url('resources/static/3570455-4k-wallpaper-grass.jpg')">
	<p class="w3-text w3-wide">PLANTSHOP</p>
</footer>



<style>
.carousel-fade .carousel-inner .item {
	opacity: 0;
	transition-property: opacity;
}

.carousel-fade .carousel-inner .active {
	opacity: 1;
}

.carousel-fade .carousel-inner .active.left, .carousel-fade .carousel-inner .active.right
	{
	left: 0;
	opacity: 0;
	z-index: 1;
}

.carousel-fade .carousel-inner .next.left, .carousel-fade .carousel-inner .prev.right
	{
	opacity: 1;
}

.carousel-fade .carousel-control {
	z-index: 2;
}

@media all and (transform-3d) , ( -webkit-transform-3d ) {
	.carousel-fade .carousel-inner>.item.next, .carousel-fade .carousel-inner>.item.active.right
		{
		opacity: 0;
		-webkit-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
	}
	.carousel-fade .carousel-inner>.item.prev, .carousel-fade .carousel-inner>.item.active.left
		{
		opacity: 0;
		-webkit-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
	}
	.carousel-fade .carousel-inner>.item.next.left, .carousel-fade .carousel-inner>.item.prev.right,
		.carousel-fade .carousel-inner>.item.active {
		opacity: 1;
		-webkit-transform: translate3d(0, 0, 0);
		transform: translate3d(0, 0, 0);
	}
}

.box {
	position: relative;
	vertical-align: middle;
	color: #015FA5;
	display: inline-block;
	height: 50px;
	line-height: 40px;
	text-align: center;
	transition: 0.5s;
	padding: 0.2px;
	cursor: pointer;
	-webkit-transition: 0.5s;
}

.box::before, .box::after {
	width: 100%;
	height: 100%;
	z-index: 3;
	content: '';
	position: absolute;
	top: 0;
	left: 0;
	-webkit-transform: scale(0);
	transition: 0.5s;
}

.foo::before {
	border-bottom: 3px solid #000;
	border-left: 3px solid #000;
	-webkit-transform-origin: 0 100%;
}

.foo::after {
	border-top: 3px solid #000;
	border-right: 3px solid #000;
	-webkit-transform-origin: 100% 0%;
}

.box:hover::after, .box:hover::before {
	-webkit-transform: scale(1);
}
</style>
<script>
	
</script>