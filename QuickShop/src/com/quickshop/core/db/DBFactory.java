 package com.quickshop.core.db;
 
 import com.quickshop.core.dao.AbstractDataAccessObject;
 
 public class DBFactory
{
  public DBFactory()
 {
    new AbstractDataAccessObject().getConnection();
  }
 }

