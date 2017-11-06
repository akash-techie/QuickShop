<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuickShop</title>
<link href="default.css" rel="stylesheet" type="text/css"
			media="screen" />
</head>
<body>
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
				
					<h2 style="text-align:center;">
						Contact Us</br>
						
											</h2>
											<h3 style="text-align:center;">Thank you for using QuickShop!</h3>
											<center><table cellpadding="10" border="2" bordercolor="blue" style="text-align:left;padding:5px;">
											<tr>
											<th>Corporate Headquaters</th>
											<th>Contact Numbers</th></tr>
											<tr>
											<td>1985 Cedar Bridge Ave,Suite 3 <br/>Lakewood, NJ 08701</td>
											<td>Phone: +91 80 2852 0261 <br/>
Fax: +91 80 2852 0362</td></tr></table></center>
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
				
		<!-- end page --> -->
		<div id="footer">
			<p id="legal">
				<a href="#">Privacy Policy</a> |
				<a href="#">Terms of Use</a>
			</p>
		</div>

</body>
</html>