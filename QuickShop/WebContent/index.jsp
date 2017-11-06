<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>QuickShop</title>
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<link href="default.css" rel="stylesheet" type="text/css"
			media="screen" />
	</head>
		
		<body>
				
		<!-- start header -->
		
		<div id="logo">
		<h1><jsp:include page="header.html" /></h1>
		<pre> <img src="images/ic.png" style="height:40px;width:70px;margin-top:25px;"></img></pre>
		</div>
		
		 <div id="menu">
			<ul>
				<jsp:include page="generaloptions.html" />
			</ul> 
		</div>
		<!-- end header -->
		<!-- start page -->
		<div id="page">
			<div id="page-bg">
				<div id="latest-post">
				
					<h1>
						Welcome to QuickShop</br>
						</br>
						<img class="mySlides" src="images/a.jpg" style="width:100%"></img>
                        <img class="mySlides" src="images/b.jpg" style="width:100%"></img>
                        <img class="mySlides" src="images/c.jpg" style="width:100%"></img>
                        <img class="mySlides" src="images/d.jpg" style="width:100%"></img>
                        <img class="mySlides" src="images/e.jpg" style="width:100%"></img>
					</h1>
				</div>			
				<!-- start content -->
				<div id="content">
					
				</div>
				<!-- end content -->
								<div style="clear: both;">
					&nbsp;
				</div> 
			</div>
		</div>
		<script>
var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
		
		<!-- end page --> -->
		<div id="footer">
			<p id="legal">
				<a href="#">Privacy Policy</a> |
				<a href="#">Terms of Use</a>
			</p>
		</div>
	</body>
</html>

