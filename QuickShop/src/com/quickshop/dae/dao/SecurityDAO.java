 package com.quickshop.dae.dao;
 
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.LoggerManager;
import com.quickshop.dae.model.CustomerProfile;
 
 public class SecurityDAO extends AbstractDataAccessObject
 {
   public SecurityDAO()
   {
     getConnection();
   }
 
   public String recoverPasswordByExistQuestion(CustomerProfile cp)
   {
     String password = "";
     String loginname = cp.getLoginname();
     String secretquestion = cp.getOwnSecretQuestion();
     String secretanswer = cp.getSecretAnswer();
     try
     {
       PreparedStatement pst = this.con.prepareStatement("SELECT password FROM employeedetails  WHERE loginname=? and secretquestion=? and secretanswer=?");
       pst.setString(1, loginname);
       pst.setString(2, secretquestion);
       pst.setString(3, secretanswer);
       ResultSet rs = pst.executeQuery();
       if (rs.next())
         password = rs.getString(1);
       else
         password = "";
     }
     catch (Exception e)
     {
       LoggerManager.writeLogSevere(e);
       password = "";
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
     return password;
   }
 }

