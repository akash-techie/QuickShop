<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.quickshop.dae.dao.StockDAO"%>
<%@page import="com.quickshop.core.util.CoreHash"%>
<%@page import="com.quickshop.dae.model.StockBean"%>
<%@page import="java.util.*"%>
<%
  StockDAO sdao = new StockDAO();
  CoreHash ch = sdao.getStockDetails();
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>QuickShop</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<!-- start header -->
<div id="logo">
	<h1><jsp:include page="header.html"/></h1>
	<pre> <img src="images/ic.png" style="height:40px;width:70px;margin-top:25px;"></img></pre>
	</div>
<div id="menu">
	<ul>
		<jsp:include page="adminoptions.html"/> 
	</ul>
</div>
<!-- end header -->
<!-- start page -->
<div id="page">
  <div id="page-bg">
	<!-- 	<div id="latest-post">
		  <h1>Welcome to Our Website!</h1>
	  </div>  -->
		<!-- start content -->
	<!-- end content -->
	<!-- start sidebar -->
<div id="latest-post">
<ul>
				
				
				  <form id="form1" method="post" action="">
				   <fieldset class="field_set">
                   <legend><h2>Stock Details</h2></legend>
                   
            <table align="center" width="645" border="1">
            
            <tr>
            <th>ProductId</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Category</th>
            </tr>
           <% Enumeration enumeration = ch.elements();
	        while(enumeration.hasMoreElements()) 
		    {
		    	StockBean sb = (StockBean)enumeration.nextElement();
		   	%>	
            <tr>
	   		<td><%=sb.getProductid()%></td>
			<td><%=sb.getProductname()%></td>
	    	<td><%=sb.getPrice()%></td>
	    	<td><%=sb.getCategory()%></td>
	    	</tr>
	        
           <%}%> 
           <tr><td colspan="8" align="right"><input name="print" type="button" value="Print Report" onclick="javascript:window.print();"/></td></tr>
           </table>
           </fieldset>
                  </form>
				
				
					<div align="center"></div>
	  </ul>
		</div>
    <div style="clear: both;">&nbsp;</div>
	</div>
  <div align="center"></div>
</div>
<!-- end page -->
<div id="footer">
			<p id="legal">
				<a href="#">Privacy Policy</a> |
				<a href="#">Terms of Use</a>
			</p>
		</div>
</body>
</html>
