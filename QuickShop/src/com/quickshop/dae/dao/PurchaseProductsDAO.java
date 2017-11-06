package com.quickshop.dae.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.DateWrapper;
import com.quickshop.dae.model.PurchaseProductsBean;

public class PurchaseProductsDAO extends AbstractDataAccessObject
{
  private boolean flag;

  public PurchaseProductsDAO()
  {
    getConnection();
  }

  public int getUniqueCartId()
  {
    int sUniqueCartId = 0;
    int iMaxCount = 0;
    try
    {
      Statement st = this.con.createStatement();
      ResultSet resultSet = st.executeQuery("select cartid_seq.nextval from dual");
      if (resultSet.next())
        iMaxCount = Integer.parseInt(resultSet.getString(1));
    //  sUniqueCartId = "cart_" + (iMaxCount + 1);
      sUniqueCartId = iMaxCount;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      this.flag = false;
      try
      {
        this.con.rollback();
      }
      catch (SQLException se)
      {
        se.printStackTrace();
      }
    }
    return sUniqueCartId;
  }

  public boolean addtoCart(PurchaseProductsBean ppbean)
  {
    Date pdate = new Date();
    String custname = ppbean.getCustomername();
    String prodname = ppbean.getProductname();
    String quantity = ppbean.getQuantity();
    String purchaseddate = DateWrapper.parseDate(pdate);
    int cartid = getUniqueCartId();
    System.out.println("CustName: "+ custname);
    System.out.println("Productname: "+ prodname);
    System.out.println("Quantiti: "+ quantity);
    System.out.println("PurchaseDate: "+ purchaseddate);
    System.out.println("CartId: "+ cartid);
    try
    {
      PreparedStatement pst = null;
      int i = 0;
	  System.out.println("before executing the preparestatement ");
      pst = this.con.prepareStatement("insert into shoppingcart values(?,?,?,?,?,?)");
      pst.setInt(6, cartid);
      pst.setString(1, custname);
      pst.setString(2, prodname);
      pst.setString(3, quantity);
      pst.setString(4, purchaseddate);
      pst.setString(5, "No");
      i = pst.executeUpdate();
      if (i == 1)
      {
        this.flag = true;
        this.con.commit();
      }
      else {
        this.flag = false;
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      this.flag = false;
      try
      {
        this.con.rollback();
      }
      catch (SQLException se)
      {
        se.printStackTrace();
      }
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
    return this.flag;
  }
}