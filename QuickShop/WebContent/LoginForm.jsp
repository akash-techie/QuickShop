<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%
	String password = null;
	password=request.getParameter("status");
/*	if(password==null)
	{
		password="family";
	}*/
%>
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
				
				<!-- start content -->
				
				<!-- end content -->
				<!-- start sidebar -->
				<div id="content">
					<ul>
					<% if(password!=null){
						
						%>
					
					<p style="text-align:center;padding-left:170px;">
								 Your <b><%=password%></b></p><%} %>
					<h2 style="text-align:center;padding-left:170px;">
						Login
					</h2>
						<form action="LoginAction.jsp" method="post" name="register">
								<table width="200" border="0" align="center">
									<tr>
										<td><table border="0"><tr><td height="186" valign="baseline"><div align="center">
										  <table height="120" border="0">
                                            <tr>
                                           <td width="67" height="80" align="right"></td> 
                                              <td width="212"><table  border="0" align="center" cellpadding="10" style="text-align:left;padding-left:80px;">
                                                  <tr>
                                                    <td><b> Username </b></td>
                                                    <td><input type="text" name="username" required style="border-radius:25px;border-color:#0000FF;"/>                                                    </td>
                                                  </tr>
                                                  <tr>
                                                    <td><b> Password </b> </td>
                                                    <td><input type="password" name="password" required style="border-radius:25px;border-color:#0000FF;"/>                                                    </td>
                                                  </tr>
                                                  <tr>
                                                  <td></td>
                                                    <td colspan="2"><div align="center">
                                                        <input type="submit" name="Submit" value="Sign In" style="border-radius:12px;width:40%;"/>
                                                        <input name="Input2" type="reset" value="Clear" style="border-radius:12px;width:40%;"/>
                                                    </div></td>
                                                  </tr>
                                              </table></td>
                                              <td width="6">&nbsp;</td><tr></tr><tr></tr><tr></tr><tr></tr>
                                            </tr>
                                            <tr>
                                              <td></td>
                                              <td valign="baseline"><div align="right"> <a href="Recoverpassword.jsp">Forgot Password
                                        </a> | <a href="Registerform.jsp"> SignUp (New Staff)</a> </div></td>
                                              
                                            </tr>
                                           
                                          </table>
										  </div>
													</td>
												</tr>
										</table>
									  </td>
									</tr>
								</table>
							</form>
						
					</ul>
				</div>
<div style="clear: both;">
					&nbsp;
				</div>
				</div>
			</div>
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

