 package com.quickshop.core.dao;

 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.Properties;

import com.quickshop.core.util.LoggerManager;
 
 public class AbstractDataAccessObject
{
  public Connection con;
  static Properties props;

  public Properties getProperties()
  {
     return props;
  }

  public void setProperties(Properties props)
  {
   props = props;
 }

   public Connection getConnection()
   {
    try
   {
       Properties p = getProperties();
      Class.forName("oracle.jdbc.driver.OracleDriver");
      this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","smartshop","2425508");
  }
  catch (ClassNotFoundException cnf)
  {
    LoggerManager.writeLogWarning(cnf);
    cnf.printStackTrace();
  }
   catch (SQLException se)
    {
      LoggerManager.writeLogWarning(se);
      se.printStackTrace();
    }
    return this.con;
  }

  public int getSequenceID(String tableName, String pkid)
 {
  int id = 0;
   this.con = getConnection();
   try {
     Statement st = this.con.createStatement();
     ResultSet rs = st.executeQuery("select max(" + pkid + ") from " + tableName);
     if (rs.next())
       id = rs.getInt(1);
     id++;
      this.con.close();
    }
    catch (Exception e)
    {
     LoggerManager.writeLogWarning(e);
  }
    try
    {
      this.con.close();
     }
     catch (SQLException se)
    {
     LoggerManager.writeLogWarning(se);
   }
  catch (Exception e)
    {
      LoggerManager.writeLogWarning(e);
   }
    try
   {
     this.con.close();
    }
   catch (SQLException se)
     {
      LoggerManager.writeLogWarning(se);
   }
   catch (Exception e)
   {
     LoggerManager.writeLogWarning(e);
   }
   try
   {
     this.con.close();
   }
   catch (SQLException se)
   {
     LoggerManager.writeLogWarning(se);
    }
    catch (Exception e)
    {
	LoggerManager.writeLogWarning(e);
   }
    return id;
   }
}

