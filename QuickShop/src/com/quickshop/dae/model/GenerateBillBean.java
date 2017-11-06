 package com.quickshop.dae.model;

 public class GenerateBillBean
 {
  private String grandtotal;
  private String customername;
  private String productname;
  private String price;
  private String quantity;
  private String date;

  public String getDate()
  {
   return this.date;
  }

  public void setDate(String date)
  {
    this.date = date;
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

  public String getQuantity()
  {
    return this.quantity;
  }

 public void setQuantity(String quantity)
  {
    this.quantity = quantity;
 }
 
  public String getCustomername()
 {
   return this.customername;
   }

  public void setCustomername(String customername)
  {
    this.customername = customername;
   }
 
  public String getGrandtotal()
   {
    return this.grandtotal;
  }
 
   public void setGrandtotal(String grandtotal)
   {
    this.grandtotal = grandtotal;
   }
 }

