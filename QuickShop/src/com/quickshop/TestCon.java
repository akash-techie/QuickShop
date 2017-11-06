package com.quickshop;
 import java.sql.Connection;

import com.quickshop.core.dao.AbstractDataAccessObject;

 public class TestCon
 {
   public static void main(String[] args)
     throws Exception
   {
     AbstractDataAccessObject ss = new AbstractDataAccessObject();
    Connection con = ss.getConnection();
     System.out.println("conection=" + con);
   }
 }
