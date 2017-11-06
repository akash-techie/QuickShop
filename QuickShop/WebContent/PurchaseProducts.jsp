<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@page import="com.quickshop.dae.dao.StockDAO"%>
<%@page import="com.quickshop.core.util.CoreHash"%>
<%@page import="com.quickshop.dae.model.StockBean"%>
<%@page import="java.util.*"%>
<%
	try{
	String category = (String)request.getParameter("category");
	String sStatus = (String)request.getParameter("status");
	category = category==null?"":category;
	System.out.println("category:"+category);
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>QuickShop</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<script language="JavaScript">
function onPageLoad()
{
	//alert("Inside onPageLoad():"+"<%=category%>");
	document.getElementById("category").value = "<%=category%>";

	if("<%=category%>" == "")
	{
		document.getElementById("products").disabled = true;
		
	}
}
function changeAction(name)
{
	alert(name);
	if(name == "bill")
	{
		document.getElementById("form1").action ="GenerateBill.jsp";
		alert("before bill");
		document.form1.submit();
		alert("after bill");
		
	}else if(name == "cart")
	{   
		if(document.getElementById("category").selectedIndex==0)
		{
			alert("Please select one category");
			return false;
		}
		if(document.getElementById("products").selectedIndex==0)
		{
			alert("Please select one product");
			return false;
		}
		if(document.getElementById("quantity").value=="")
		{
			alert("Please enter the quantity of the product");
			return false;
		}
		document.getElementById("form1").action ="PurchaseProductsAction.jsp";
		document.form1.submit();
	}
}
function submitQuery(name)
{
	//alert("Inside submitQuery():"+name);
	var category = document.getElementById("category").value;
	
	var paraString = "";
	if(name=="category")
	{
		paraString = "category="+category;
	}
	location.href="PurchaseProducts.jsp?"+paraString;	
}
</script>
<body onload="onPageLoad()">
<!-- start header -->
<div id="logo">
	<h1><jsp:include page="header.html"/></h1>
	<pre> <img src="images/ic.png" style="height:40px;width:70px;margin-top:25px;"></img></pre>
	</div>
<div id="menu">
	<ul>
		<jsp:include page="customeroptions.html"/> 
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
				<center><h2><%=sStatus==null?"":sStatus%></h2></center>
				
				  <form name="form1" id="form1" method="post">
				   <fieldset class="field_set">
                   <legend><h2>Purchase Products</h2> </legend>
                   
            <table width="245" height="102" border="0" align="center">
            
            <tr>
            <th><div align="justify">Category</div></th>
                <td><SELECT name="category" id="category" onchange="submitQuery('category')">
    <OPTION value="">
	-- Select Category --
	</OPTION>
	<OPTION value="Electrical and Electronics">
	Electrical and Electronics
	</OPTION>
	<OPTION value="Stationary">
	Stationary
	</OPTION>
	<OPTION value="Beauty">
	Beauty
	</OPTION>
	<OPTION value="Garments">
	Garments
	</OPTION>
	<OPTION value="Jewelary">
	Jewelary
	</OPTION>
	<OPTION value="Others">
	Others
	</OPTION>
	</SELECT></td>
            </tr><tr height="20"><td></td></tr>
            <%
 			  StockDAO sdao = new StockDAO();
 			  CoreHash ch = new CoreHash();
 			  if(category.trim().length()>0)
 			  {
 			  	ch = sdao.getProductDetails(category);
 			  }
 			    
			%>
           	<tr>
           	<th><div align="justify">ProductName </div></th>
			<td><SELECT name="products" id="products"><option>[Select Product]</option>
			<% Enumeration enumeration1 = ch.elements();
	        while(enumeration1.hasMoreElements()) 
		    {
		    	StockBean sb = (StockBean)enumeration1.nextElement();
		   	%>	
		    <OPTION value="<%=sb.getProductname()%>"><!--value="select"-->
			<%=sb.getProductname()%></OPTION>
			<%} %>
			</SELECT></td>
	    	</tr>
	    	<tr height="20"><td></td></tr>
	    	<tr height="20"><th><div align="justify">Quantity</div> </th><td><input type="text" name="quantity" id="quantity" /></td></tr>
	    	<tr height="20"><td></td></tr>
	    	<tr><td colspan="2" align="center"><input name="cart" type="button" value="Add to Shopping cart" onclick="changeAction('cart')" style="border-radius:12px";/></td></tr>
            <tr><td height="20"></td></tr>
            <tr><td colspan="2" align="center"><input name="bill" type="button" value="Generate Bill" onclick="return changeAction('bill')" style="border-radius:12px;"/></tr>
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
<%
	}catch(Exception e){e.printStackTrace();}
%>
</html>
