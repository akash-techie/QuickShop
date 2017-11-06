 package com.quickshop.dae.dao;
 
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.LoggerManager;
import com.quickshop.dae.model.CustomerProfile;
 
 public class LoginCheckDAO extends AbstractDataAccessObject
 {
   private boolean flag;
 
  public LoginCheckDAO()
   {
    getConnection();
   }
 
   public boolean loginCheck(String username, String password)
  {
    boolean flag = false;
    try
    {
      Statement st = this.con.createStatement();
      for (ResultSet rs = st.executeQuery("select * from employeedetails where status='Y' and loginname='" + username + "' and password='" + password + "'"); rs.next(); )
       {
         CustomerProfile cp = new CustomerProfile();
         cp.setLoginname(rs.getString(12));
         flag = true;
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
     return flag;
   }
 }

