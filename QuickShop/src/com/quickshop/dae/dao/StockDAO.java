 package com.quickshop.dae.dao;
 
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.CoreHash;
import com.quickshop.core.util.LoggerManager;
import com.quickshop.dae.model.StockBean;
 
 public class StockDAO extends AbstractDataAccessObject
 {
  private boolean flag;

  public StockDAO()
   {
     getConnection();
   }

   public int getUniqueId()
  {
    int iMaxCount = 0;
    try
     {
       Statement st = this.con.createStatement();
      ResultSet resultSet = st.executeQuery("select max(productid) from productlist");
      if (resultSet.next())
        iMaxCount = resultSet.getInt(1);
      iMaxCount++;
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
     return iMaxCount;
   }

  public boolean insertStock(StockBean stockbean)
  {
   int pid = getUniqueId();
    String pname = stockbean.getProductname();
    String price = stockbean.getPrice();
    String category = stockbean.getCategory();
    try
    {
      PreparedStatement pst = null;
      int i = 0;
      pst = this.con.prepareStatement("insert into productlist values(productid_seq.nextVal,?,?,?,?,?)");
      pst.setString(1, pname);
     pst.setString(2, price);
     pst.setString(3, category);
     pst.setString(4, "Y");
     pst.setString(5, "20");
     i = pst.executeUpdate();
     if (i == 1)
     {
       this.flag = true;
        this.con.commit();
      }
      else {
       this.flag = false;
       this.con.rollback();
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

  public CoreHash getStockDetails()
  {
    CoreHash ch = new CoreHash();
    ch.clear();
    int unique = 0;
   StockBean stkb = null;
    try
    {
      Statement st = this.con.createStatement();
     for (ResultSet rs = st.executeQuery("select * from productlist where status='Y'"); rs.next(); ch.put(unique, stkb))
      {
       unique = rs.getInt(1);
       stkb = new StockBean();
       stkb.setProductid(unique);
       stkb.setProductname(rs.getString(2));
       stkb.setPrice(rs.getString(3));
       stkb.setCategory(rs.getString(4));
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
 
    public CoreHash getProductDetails(String category)
    {
    CoreHash ch1 = new CoreHash();
    ch1.clear();
    int unique = 0;
    StockBean stkb = null;
    try
    {
     Statement st = this.con.createStatement();
     for (ResultSet rs = st.executeQuery("select product_id,productname from productlist where status='Y'and category='" + category + "'"); rs.next(); ch1.put(unique, stkb))
    {
        unique = rs.getInt(1);
        stkb = new StockBean();
        stkb.setProductid(unique);
        stkb.setProductname(rs.getString(2));
     }

   }
   catch (SQLException sqlex)
    {
      sqlex.printStackTrace();
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
    return ch1;
  }
 
  public boolean deleteStock(int pid)
  {
    boolean flag = false;
    try
    {
      PreparedStatement pst = this.con.prepareStatement("update productlist set Status =? where product_id=?");
      pst.setString(1, "N");
     pst.setInt(2, pid);
     int i = pst.executeUpdate();
     if (i != 0)
     {
       flag = true;
        this.con.commit();
      }
       else {
         flag = false;
         this.con.rollback();
       }
   }
   catch (SQLException sqlex)
   {
     sqlex.printStackTrace();
     LoggerManager.writeLogSevere(sqlex);
     flag = false;
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
    return flag;
  }
 
  public CoreHash getAvailableStockDetails()
  {
    CoreHash ch = new CoreHash();
    ch.clear();
    int unique = 0;
    StockBean stkb = null;
     try
    {
     Statement st = this.con.createStatement();
     for (ResultSet rs = st.executeQuery("select * from productlist where status='Y'"); rs.next(); ch.put(unique, stkb))
     {
       unique = rs.getInt(1);
       stkb = new StockBean();
       stkb.setProductid(unique);
       stkb.setProductname(rs.getString(2));
       stkb.setPrice(rs.getString(3));
       stkb.setCategory(rs.getString(4));
       stkb.setAvailablestock(rs.getString(6));
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
 
   public CoreHash getProductDetails()
   {
     CoreHash ch1 = new CoreHash();
     ch1.clear();
     int unique = 0;
     StockBean stkb = null;
     try
    {
      Statement st = this.con.createStatement();
      for (ResultSet rs = st.executeQuery("select product_id,productname from productlist where status='Y'"); rs.next(); ch1.put(unique, stkb))
      {
        unique = rs.getInt(1);
         stkb = new StockBean();
         stkb.setProductid(unique);
         stkb.setProductname(rs.getString(2));
       }
 
     }
    catch (SQLException sqlex)
    {
       sqlex.printStackTrace();
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
     return ch1;
   }
 
   public CoreHash getProductDetails(int prodid)
   {
    CoreHash ch1 = new CoreHash();
    ch1.clear();
    int unique = 0;
     StockBean stkb = null;
    try
    {
      Statement st = this.con.createStatement();
      for (ResultSet rs = st.executeQuery("select * from productlist where status='Y' and product_id=" + prodid); rs.next(); ch1.put(unique, stkb))
      {
        unique = rs.getInt(1);
         stkb = new StockBean();
        stkb.setProductid(unique);
        stkb.setProductname(rs.getString(2));
        stkb.setPrice(rs.getString(3));
        stkb.setCategory(rs.getString(4));
       stkb.setStatus(rs.getString(5));
       stkb.setAvailablestock(rs.getString(6));
     }

   }
   catch (SQLException sqlex)
   {
     sqlex.printStackTrace();
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
     return ch1;
   }
 
   public boolean addQuantity(int prodid, String available)
  {
    boolean flag = false;
    try
    {
      PreparedStatement pst = this.con.prepareStatement("update productlist set availablestock =? where product_id=?");
      pst.setString(1, available);
     pst.setInt(2, prodid);
      int i = pst.executeUpdate();
      if (i != 0)
      {
         flag = true;
         this.con.commit();
       }
       else {
         flag = false;
         this.con.rollback();
      }
    }
    catch (SQLException sqlex)
    {
      sqlex.printStackTrace();
     LoggerManager.writeLogSevere(sqlex);
     flag = false;
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
     return flag;
  }

  public void updateQuantity(String prodname, String availablestock)
  {
     boolean flag = false;
     try
     {
       PreparedStatement pst = this.con.prepareStatement("update productlist set availablestock =? where productname=?");
      pst.setString(1, availablestock);
      pst.setString(2, prodname);
      int i = pst.executeUpdate();
      if (i != 0)
      {
        flag = true;
        this.con.commit();
      }
      else {
        flag = false;
        this.con.rollback();
       }
     }
     catch (SQLException sqlex)
     {
       sqlex.printStackTrace();
       LoggerManager.writeLogSevere(sqlex);
       flag = false;
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
   }

   public StockBean getAvailableStockDetails(String prodname)
   {
     StockBean stkb = null;
     try
     {
       Statement st = this.con.createStatement();
       for (ResultSet rs = st.executeQuery("select * from productlist where status='Y' and productname='" + prodname + "'"); rs.next(); stkb.setAvailablestock(rs.getString(6)))
       {
        int unique = rs.getInt(1);
        stkb = new StockBean();
        stkb.setProductid(unique);
        stkb.setProductname(rs.getString(2));
        stkb.setPrice(rs.getString(3));
        stkb.setCategory(rs.getString(4));
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
     return stkb;
  }
 }

