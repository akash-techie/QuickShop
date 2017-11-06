<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.quickshop.dae.dao.PurchaseProductsDAO"%>
<%@page import="com.quickshop.dae.model.PurchaseProductsBean"%>
<%@page import="com.quickshop.dae.dao.StockDAO"%>
<%@page import="com.quickshop.dae.model.StockBean"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
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
		<br>
		<%
			String user=(String)session.getAttribute("user");
		 System.out.println("user: "+user);
			String target = "PurchaseProducts.jsp?status=adding to cart Failed";
			try {
				  StockBean stkb=new StockBean();
				PurchaseProductsBean ppb = new PurchaseProductsBean();
				ppb.setPaidStatus("No");
				ppb.setCustomername(user);
				ppb.setProductname((String)request.getParameter("products"));
				ppb.setQuantity((String)request.getParameter("quantity"));
				stkb= new StockDAO().getAvailableStockDetails((String)request.getParameter("products"));
				//	Enumeration en = ch1.elements();
					String available = "";
				//	while (en.hasMoreElements()) {
				//		stkb = (StockBean) en.nextElement();
						available = stkb.getAvailablestock();
				//	}
					//String cartqunatity=gbbean.getQuantity();
				int	smstock=Integer.parseInt(available) - Integer.parseInt((String)request.getParameter("quantity"));
				if(smstock<0)
				{
					target = "PurchaseProducts.jsp?status=Quantity exceeds the stock";
					System.out.println("target: "+target);
					RequestDispatcher rd = request.getRequestDispatcher(target);
					rd.forward(request, response);
				}
				else
				{
				PurchaseProductsDAO pdao=new PurchaseProductsDAO();	
				boolean flag = pdao.addtoCart(ppb);
                System.out.println("flag: "+flag);
				if (flag)
					target = "PurchaseProducts.jsp?status=Item added to the cart successfully";
				else
					target = "PurchaseProducts.jsp?status=adding to cart Failed";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("target: "+target);
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		%>
	</body>
</html>
