/*     */ package com.quickshop.project.dao;
import java.io.PrintStream;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import com.quickshop.core.dao.AbstractDataAccessObject;
import com.quickshop.core.util.CoreHash;
import com.quickshop.core.util.LoggerManager;
import com.quickshop.project.model.Sample;

 public class SampleDAO extends AbstractDataAccessObject
{
  Connection con;
  Sample sample;

 public boolean addSample(Sample aSample)
 {
     boolean flag = false;
     try
     {
	  this.con = getConnection();
      PreparedStatement st = this.con.prepareStatement("insert into test values(?,?,?,?)");
      st.setInt(1, aSample.getSno());
      st.setString(2, aSample.getSname());
      st.setInt(3, aSample.getAge());
      st.setString(4, aSample.getAddress());
      int i = st.executeUpdate();
      this.con.commit();
      if (i > 0)
        flag = true;
      this.con.close();
    }
   catch (Exception e)
     {
      LoggerManager.writeLogWarning(e);
     }
     return flag;
  }
 
   public void updateSample(Sample sample1)
   {
   }

   public boolean deleteSample(String s)
   {
     boolean flag = false;
     try
     {
       this.con = getConnection();
      PreparedStatement st = this.con.prepareStatement("delete from test where sno=?");
     st.setString(1, s);
     int i = st.executeUpdate();
     if (i > 0)
      flag = true;
   this.con.close();
     }
     catch (Exception e)
     {
       LoggerManager.writeLogWarning(e);
     }
     return flag;
   }
 
   public Sample viewSample(String s)
   {
     try
     {
       this.con = getConnection();
       Statement st = this.con.createStatement();
       for (ResultSet rs = st.executeQuery("select * from test where sno = " + s); rs.next(); this.sample.setAddress(rs.getString(4)))
       {
         this.sample = new Sample();
         this.sample.setSno(rs.getInt(1));
         this.sample.setSname(rs.getString(2));
         this.sample.setAge(rs.getInt(3));
       }

       this.con.close();
     }
     catch (SQLException e)
     {
       LoggerManager.writeLogWarning(e);
     }
     return this.sample;
  }

  public CoreHash listSample()
 {
    System.out.println("in list sample");
   CoreHash aCoreHash = new CoreHash();
    aCoreHash.clear();
    System.out.println("aCoreHash--" + aCoreHash.isEmpty());
   try
   {
     this.con = getConnection();
     Statement st = this.con.createStatement();
      int sno;
      for (ResultSet rs = st.executeQuery("select * from test"); rs.next(); aCoreHash.put(new Integer(sno), this.sample))
      {
        sno = rs.getInt(1);
        this.sample = new Sample();
        this.sample.setSno(sno);
        this.sample.setSname(rs.getString(2));
        this.sample.setAge(rs.getInt(3));
        this.sample.setAddress(rs.getString(4));
      }

      this.con.close();
    }
   catch (SQLException e)
   {
     LoggerManager.writeLogWarning(e);
   }
     return aCoreHash;
   }
 }

