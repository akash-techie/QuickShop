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
import com.quickshop.dae.model.StaffBean;
 
 public class StaffDAO_bkp extends AbstractDataAccessObject
 {
   private boolean flag;
 
   public StaffDAO_bkp()
   {
     getConnection();
   }
 
  public boolean insertStaff(StaffBean staffbean)
  {
    int empid = 0;
    String empname = staffbean.getEmpName();
    String designation = staffbean.getDesignatin();
    String salary = staffbean.getSalary();
    String jdate = staffbean.getDoj();
    String accno = staffbean.getAccno();
    String contactaddress = staffbean.getContactAddress();
    String phoneno = staffbean.getPhoneNo();
    try {
       this.con.setAutoCommit(false);
      PreparedStatement pst = null;
     // Statement st = this.con.createStatement();
      int i = 0;
       String newdate = DateWrapper.parseDate(new Date());
      // ResultSet rs = st.executeQuery("select max(empid) from employeedetails");
      // if (rs.next())
     //    empid = rs.getInt(1);
     //  empid++; 
       pst = this.con.prepareStatement("insert into employeedetails values(employeeid_seq.nextVal,?,?,?,?,?,?,?,?)");
       pst.setString(1, empname);
       pst.setString(2, designation);
       pst.setString(3, salary);
       pst.setString(4, jdate);
       pst.setString(5, accno);
       pst.setString(6, contactaddress);
       pst.setString(7, phoneno);
       pst.setString(8, "Y");
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
     //  this.flag = false;

    //  this.con.rollback();
   }
     catch (SQLException sex)
     {
       sex.printStackTrace();
     }
    /* try
     {
     this.con.close();
     }
     catch (Exception e)
     {
       e.printStackTrace();
     }*/
  //   this.flag = false;
  //  try
    //{
      //this.con.rollback();
    //}
     //catch (SQLException se)
     //{
      //se.printStackTrace();
    //}
     //try
    //{
      //this.con.close();
   //}
    //catch (Exception e)
   //{
     // e.printStackTrace();
   //}
   //try
    //{
     //this.con.close();
     //}
    /*catch (Exception e)
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
     return this.flag;
   }

 public CoreHash getStaffDetails()
   {
    CoreHash ch = new CoreHash();
    ch.clear();
    int unique = 0;
    StaffBean sdto = null;
    try
    {
      Statement st = this.con.createStatement();
      for (ResultSet rs = st.executeQuery("select * from employeedetails where status='Y'"); rs.next(); ch.put(unique, sdto))
      {
        unique = rs.getInt(1);
        sdto = new StaffBean();
        sdto.setEmpId(unique);
        sdto.setEmpName(rs.getString(2));
       sdto.setDesignatin(rs.getString(3));
       sdto.setSalary(rs.getString(4));
        sdto.setDoj(rs.getString(5));
      sdto.setAccno(rs.getString(6));
      sdto.setContactAddress(rs.getString(7));
       sdto.setPhoneNo(rs.getString(8));
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

  public boolean deleteStaff(int empid)
  {
    boolean flag = false;
    try
   {
      PreparedStatement pst = this.con.prepareStatement("update employeedetails set Status =? where emp_id=?");
       pst.setString(1, "N");
       pst.setInt(2, empid);
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
 }