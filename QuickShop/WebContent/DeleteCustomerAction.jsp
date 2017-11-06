<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.quickshop.core.util.CoreHash"%>
<%@page import="com.quickshop.dae.model.CustomerProfile"%>
<%@page import="java.util.*"%>
<%@page import="com.quickshop.dae.dao.StaffDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>QuickShop</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <% boolean flag=false; 
  String check[] = request.getParameterValues("check");
  for(int i=0;i<check.length;i++)
  {
  		String temp =check[i];
        flag = new StaffDAO().deleteCustomer(temp);
  } 
   		
         String target = "ListStaff.jsp?status=Staff Deletion Failed";
         if(flag)
            target = "AdminHome.jsp?status=Staff Deletion Success";
         else  
            target = "ListStaff.jsp?status=Staff Deletion Failed"; 
        RequestDispatcher rd = request.getRequestDispatcher(target);
        rd.forward(request,response); 
  %>
  
  
  </body>
</html>
