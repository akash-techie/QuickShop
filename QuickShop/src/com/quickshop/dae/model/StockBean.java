 package com.quickshop.dae.model;
 
 public class StockBean
 {
   private int productid;
   private String productname;
   private String price;
   private String category;
   private String availablestock;
   private String status;
 
   public String getStatus()
   {
     return this.status;
  }

  public void setStatus(String status)
  {
    this.status = status;
  }

  public String getAvailablestock()
  {
    return this.availablestock;
   }
 
   public void setAvailablestock(String availablestock)
  {
    this.availablestock = availablestock;
  }
 
   public int getProductid()
   {
    return this.productid;
  }

   public void setProductid(int productid)
   {
     this.productid = productid;
  }
 
   public String getProductname()
   {
     return this.productname;
  }
 
   public void setProductname(String productname)
   {
     this.productname = productname;
   }
 
   public String getPrice()
   {
    return this.price;
  }

  public void setPrice(String price)
  {
    this.price = price;
  }

   public String getCategory()
   {
     return this.category;
   }
 
   public void setCategory(String category)
  {
    this.category = category;
  }
 }

