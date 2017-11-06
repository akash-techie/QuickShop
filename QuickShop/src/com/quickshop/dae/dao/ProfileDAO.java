 package com.quickshop.dae.dao;
 
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.Date;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.DateWrapper;
import com.quickshop.core.util.LoggerManager;
import com.quickshop.dae.model.Profile;
 
 public class ProfileDAO extends AbstractDataAccessObject
 {
   public Connection con;
  private boolean flag;

  public boolean registration(Profile regbean)
   {
     String loginid = regbean.getLoginID();
     String password = regbean.getPassword();
     String firstname = regbean.getFirstName();
     String lastname = regbean.getLastName();
     String logintype = regbean.getLoginType();
     int status = regbean.getStatus();
     int secretquest = regbean.getSecretQuestionID();
     String ownsecretquest = regbean.getOwnSecretQuestion();
     String secretans = regbean.getSecretAnswer();
     int firstlogin = regbean.getFirstLogin();
     String bdate = DateWrapper.parseDate(regbean.getBirthDate());
     String hno = regbean.getHno();
     String street = regbean.getStreet();
     String city = regbean.getCity();
     String state = regbean.getState();
     String country = regbean.getCountry();
     String pincode = regbean.getPincode();
     String phoneno = regbean.getPhoneNo();
     String email = regbean.getEmail();
     String locale = regbean.getLocale();
     String passmdate = regbean.getPasswordModifiedDate();
     String profilemdate = regbean.getProfileModifiedDate();
     try
    {
      this.con = getConnection();
      this.con.setAutoCommit(false);
       PreparedStatement pst = null;
       Statement st = this.con.createStatement();
       int i = 0;
       if (secretquest == 0)
       {
         ResultSet rs = st.executeQuery("select (max(questionid))+1 from questionbase");
         if (rs.next())
           secretquest = rs.getInt(1);
         pst = this.con.prepareStatement("INSERT INTO questionbase VALUES(?,?)");
         pst.setInt(1, secretquest);
         pst.setString(2, ownsecretquest);
         pst.executeUpdate();
       }
       String newdate = DateWrapper.parseDate(new Date());
       pst = this.con.prepareStatement("insert into LOGINDETAILS values(?,?,?,?,?,?,?,?,?,?,?)");
       pst.setString(1, loginid);
       pst.setString(2, password);
       pst.setString(3, firstname);
       pst.setString(4, lastname);
       pst.setString(5, logintype);
       pst.setInt(6, status);
       pst.setString(7, newdate);
       pst.setInt(8, secretquest);
       pst.setString(9, secretans);
       pst.setInt(10, firstlogin);
       pst.setString(11, newdate);
       i = pst.executeUpdate();
       if (i == 1)
       {
         pst = this.con.prepareStatement("insert into LOGINPROFILE values(?,?,?,?,?,?,?,?,?,?,?,?)");
         pst.setString(1, loginid);
         pst.setString(2, bdate);
         pst.setString(3, hno);
         pst.setString(4, street);
         pst.setString(5, city);
         pst.setString(6, state);
         pst.setString(7, country);
         pst.setString(8, pincode);
         pst.setString(9, phoneno);
         pst.setString(10, email);
         pst.setString(11, locale);
         pst.setString(12, newdate);
         i = pst.executeUpdate();
       }
       if (i == 1)
       {
         this.flag = true;
         this.con.commit();
       }
       else {
         this.flag = false;
         this.con.rollback();
       }
       this.con.close();
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
     return this.flag;
   }
 
 /*  public Profile getProfile(String loginname)
   {
     Profile rb = null;
    try
   {
      this.con = getConnection();
      Statement st = this.con.createStatement();
      ResultSet rs = st.executeQuery("select ld.firstname,ld.lastname,lp.birthdate,lp.city,lp.state,lp.country from logindetails ld,loginprofile lp where ld.loginname=lp.loginid and ld.loginname='" + loginname + "'");
      if (rs.next())
      {
        rb = new Profile();
         rb.setLoginID(loginname);
         rb.setFirstName(rs.getString(1));
        rb.setLastName(rs.getString(2));
        rb.setBirthDate1(rs.getDate(3));
         rb.setCity(rs.getString(4));
         rb.setState(rs.getString(5));
         rb.setCountry(rs.getString(6));
       }
       this.con.close();
     }
     catch (Exception e)
    {
       LoggerManager.writeLogSevere(e);
     }
     return rb;
   }*/
 
   /*public boolean modifyProfile(Profile regbean)
   {
     String loginid = regbean.getLoginID();
     String bdate = DateWrapper.parseDate(regbean.getBirthDate());
     String city = regbean.getCity();
     String state = regbean.getState();
     String country = regbean.getCountry();
     String firstname = regbean.getFirstName();
    String lastname = regbean.getLastName();
    try
    {
      this.con = getConnection();
       this.con.setAutoCommit(false);
       PreparedStatement pst = this.con.prepareStatement("UPDATE loginprofile SET birthdate=?,city=?,state=?,country=?,profilemodifieddate=? WHERE loginid=?");
       PreparedStatement pst1 = this.con.prepareStatement("UPDATE logindetails SET firstname=?,lastname=? WHERE loginname=?");
       pst.setString(1, bdate);
      pst.setString(2, city);
       pst.setString(3, state);
      pst.setString(4, country);
       pst.setString(5, DateWrapper.parseDate(new Date()));
       pst.setString(6, loginid);
       pst1.setString(1, firstname);
       pst1.setString(2, lastname);
      pst1.setString(3, loginid);
      int i = pst.executeUpdate();
      if (i != 0)
       {
        i = pst1.executeUpdate();
        if (i != 0)
        {
           this.flag = true;
           this.con.commit();
         }
         else {
           this.flag = false;
           this.con.rollback();
         }
       }
       else {
        this.flag = false;
         this.con.rollback();
       }
       this.con.close();
     }
     catch (SQLException ex)
     {
       ex.printStackTrace();
       LoggerManager.writeLogSevere(ex);
       this.flag = false;
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
       this.flag = false;
       try
       {
         this.con.rollback();
       }
       catch (SQLException se)
       {
         LoggerManager.writeLogSevere(se);
       }
     }
     return this.flag;
   }*/
 
   /*public boolean changeAccountStatus(String loginid, int status)
   {
     try
     {
       this.con = getConnection();
       this.con.setAutoCommit(false);
       if (status == 0)
         status = 1;
       else
         status = 0;
       PreparedStatement pst = this.con.prepareStatement("UPDATE logindetails SET loginstatus=? WHERE loginname=?");
       pst.setInt(1, status);
       pst.setString(2, loginid);
       int i = pst.executeUpdate();
      if (i == 1)
       {
        this.flag = true;
         this.con.commit();
       }
       else {
         this.flag = false;
         this.con.rollback();
       }
       this.con.close();
     }
     catch (SQLException ex)
     {
       LoggerManager.writeLogSevere(ex);
       this.flag = false;
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
       this.flag = false;
       try
       {
         this.con.rollback();
       }
       catch (SQLException se)
       {
         LoggerManager.writeLogSevere(se);
       }
     }
     return this.flag;
   }*/
 }

