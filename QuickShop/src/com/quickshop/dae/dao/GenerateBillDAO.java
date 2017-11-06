 package com.quickshop.dae.dao;

 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.Date;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.CoreHash;
import com.quickshop.core.util.DateWrapper;
import com.quickshop.core.util.LoggerManager;
import com.quickshop.dae.model.GenerateBillBean;
 
 public class GenerateBillDAO extends AbstractDataAccessObject
 {
   private boolean flag;
   private boolean flag1;
 
   public GenerateBillDAO()
   {
     getConnection();
   }
 
   public CoreHash generateBill(GenerateBillBean gbb)
   {
   CoreHash ch = new CoreHash();
     ch.clear();
     String unique = "";
     Date todaydate = new Date();
     String date = DateWrapper.parseDate(todaydate);
     String custname = gbb.getCustomername();
     System.out.println("custname="+ custname);
     try
     {
       Statement st = this.con.createStatement();
       System.out.println("Inside Try");
       ResultSet rs1 = st.executeQuery("select * from shoppingcart sc where sc.purchasedate='" + date + "' and sc.custname='" + custname + "'");
       while(rs1.next()){
    	   System.out.println("rs1 : "+rs1.getString(5)+" : "+rs1.getInt(6));
       }
       ResultSet rs = st.executeQuery("select sc.cart_id, pl.productname,pl.price,sc.quantity from productlist pl,shoppingcart sc where pl.status='Y' and pl.productname=sc.prodname and sc.purchasedate='" + date + "' and sc.paid_status='No' and sc.custname='" + custname + "'");
       while ( rs.next() )
       {
    	   System.out.println("Purchased");
         unique = rs.getString(1);
         gbb = new GenerateBillBean();
         gbb.setProductname(rs.getString(2));
         gbb.setPrice(rs.getString(3));
         gbb.setQuantity(rs.getString(4));
         ch.put(unique, gbb);
         System.out.println("Purchased Complete");
       }
     }
     catch (SQLException sqlex)
     {
       LoggerManager.writeLogSevere(sqlex);
     }
     try
     {
       this.con.close();
     }
     catch (Exception e)
     {
       e.printStackTrace();
     }
   /*  try
     {
       this.con.close();
     }
     catch (Exception e)
     {
       e.printStackTrace();
     }
    try
   {
      this.con.close();
     }
     catch (Exception e)
     {
       e.printStackTrace();
     }*/
     return ch;
   }
 
   public boolean insertProductsBought(GenerateBillBean gbb)
   {
     Date date = new Date();
     String boughtdate = DateWrapper.parseDate(date);
     String custname = gbb.getCustomername();
     String grandtotal = gbb.getGrandtotal();
     try
     {
       PreparedStatement pst = null;
       int i = 0;
       pst = this.con.prepareStatement("insert into productsbought values(?,?,?)");
       pst.setString(1, custname);
       pst.setString(2, grandtotal);
       pst.setString(3, boughtdate);
       i = pst.executeUpdate();
       if (i == 1)
       {
         this.flag = true;
         //updatePaidStatus(gbb);
         System.out.println("Going to update");
         //this.flag = false;
       }
     }
     catch (SQLException ex)
     {
       ex.printStackTrace();
       this.flag = false;
       try
       {
         this.con.rollback();
       }
       catch (SQLException sex)
       {
         sex.printStackTrace();
         LoggerManager.writeLogSevere(ex);
       }
     }
     try
     {
       this.con.close();
     }
     catch (Exception ex)
     {
       LoggerManager.writeLogSevere(ex);
     }
     try
     {
       this.con.close();
     }
     catch (Exception ex)
     {
       LoggerManager.writeLogSevere(ex);
     }
     try
     {
       this.con.close();
     }
     catch (Exception ex)
     {
       LoggerManager.writeLogSevere(ex);
     }
     return this.flag;
   }
 
   public boolean updatePaidStatus(GenerateBillBean gbb)
   {
     String purchasedate = DateWrapper.parseDate(new Date());
     String custname = gbb.getCustomername();
     try
     {
       PreparedStatement pst = this.con.prepareStatement("UPDATE shoppingcart SET paid_status='Yes' WHERE custname='" + custname + "' and purchasedate='" + purchasedate + "'");
       int i = pst.executeUpdate();
       if (i != 0)
         this.flag1 = true;
       else
         this.flag1 = false;
     }
     catch (SQLException ex)
     {
       ex.printStackTrace();
       LoggerManager.writeLogSevere(ex);
       this.flag1 = false;
       try
       {
         this.con.rollback();
       }
       catch (SQLException se)
       {
         LoggerManager.writeLogSevere(se);
       }
     }
     catch (Exception e)
     {
       LoggerManager.writeLogSevere(e);
       this.flag1 = false;
       try
       {
         this.con.rollback();
       }
       catch (SQLException se)
       {
         LoggerManager.writeLogSevere(se);
       }
     }
     return this.flag1;
   }
 
   public CoreHash getDailyReport(GenerateBillBean gbb)
   {
     CoreHash ch = new CoreHash();
     ch.clear();
     int unique = 0;
     String date = gbb.getDate();
     System.out.println("************************** date:" + date);
     try
     {
       Statement st = this.con.createStatement();
       String query = "select custname,grandtotal from productsbought where boughtdate='" + date + "'";
       for (ResultSet rs = st.executeQuery(query); rs.next(); ch.put(unique, gbb))
       {
         unique++;
         gbb = new GenerateBillBean();
         gbb.setCustomername(rs.getString(1));
         gbb.setGrandtotal(rs.getString(2));
       }
 
    }
    catch (SQLException sqlex)
    {
      LoggerManager.writeLogSevere(sqlex);
     }
     try
    {
       this.con.close();
     }
     catch (Exception e)
     {
       e.printStackTrace();
     }
     try
     {
       this.con.close();
     }
     catch (Exception e)
    {
      e.printStackTrace();
     }
     try
    {
      this.con.close();
    }
    catch (Exception e)
    {
       e.printStackTrace();
     }
     return ch;
   }
 }

