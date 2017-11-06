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
import com.quickshop.dae.model.CustomerProfile;
 
 public class StaffDAO extends AbstractDataAccessObject
 {
   private boolean flag;
 
   public StaffDAO()
   {
     getConnection();
   }
 
   public boolean registration(CustomerProfile regbean)
   {
     String loginname = regbean.getLoginname();
     String password = regbean.getPassword();
     String firstname = regbean.getFirstName();
     String lastname = regbean.getLastName();
     String secretquest = regbean.getOwnSecretQuestion();
     String secretans = regbean.getSecretAnswer();
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
     String creditcardno = regbean.getCreditcardNo();
     try {
       this.con.setAutoCommit(false);
       PreparedStatement pst = null;
       Statement st = this.con.createStatement();
       int i = 0;
       String newdate = DateWrapper.parseDate(new Date());
       pst = this.con.prepareStatement("insert into employeedetails values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,customerid_seq.nextVal)");
       pst.setString(1, firstname);
       pst.setString(2, lastname);
       pst.setString(3, bdate);
       pst.setString(4, hno);
       pst.setString(5, street);
       pst.setString(6, city);
       pst.setString(7, state);
       pst.setString(8, country);
       pst.setString(9, pincode);
       pst.setString(10, phoneno);
       pst.setString(11, email);
       pst.setString(12, loginname);
       pst.setString(13, password);
       pst.setString(14, secretquest);
       pst.setString(15, secretans);
       pst.setString(16, creditcardno);
       pst.setString(17, "Y");
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
     }
     return this.flag;
   }
 
   public CoreHash getCustomerDetails()
   {
     CoreHash ch = new CoreHash();
     ch.clear();
     String unique = "";
     CustomerProfile cp = null;
     try
     {
       Statement st = this.con.createStatement(1005, 1008);
 
       String qry = "select * from employeedetails where status='Y'";
       System.out.println("qry-->" + qry);
       for (ResultSet rs = st.executeQuery(qry); 
         rs.next(); 
         ch.put(unique, cp))
       {
         unique = rs.getString(12);
         cp = new CustomerProfile();
         cp.setFirstName(rs.getString(1));
         cp.setLastName(rs.getString(2));
         cp.setBirthDate(rs.getString(3));
         cp.setHno(rs.getString(4));
         cp.setStreet(rs.getString(5));
         cp.setCity(rs.getString(6));
         cp.setState(rs.getString(7));
         cp.setCountry(rs.getString(8));
         cp.setPincode(rs.getString(9));
         cp.setPhoneNo(rs.getString(10));
         cp.setEmail(rs.getString(11));
         cp.setLoginname(unique);
         cp.setPassword(rs.getString(13));
         cp.setOwnSecretQuestion(rs.getString(14));
         cp.setSecretAnswer(rs.getString(15));
         cp.setCreditcardNo(rs.getString(16));
       }
 
     }
     catch (SQLException sqlex)
     {
       LoggerManager.writeLogSevere(sqlex);
       sqlex.printStackTrace();
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
 
   public boolean deleteCustomer(String loginname)
   {
     boolean flag = false;
     try
     {
       PreparedStatement pst = this.con.prepareStatement("update employeedetails set Status =? where loginname=?");
       pst.setString(1, "N");
       pst.setString(2, loginname);
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
 
    return flag;
   }
 }

