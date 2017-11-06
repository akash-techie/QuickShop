 package com.quickshop.dae.model;
 public class PurchaseProductsBean
 {
   private String cartId;
   private String customername;
   private String productname;
   private String quantity;
   private String paidStatus;
 
   public String getCartId()
   {
     return this.cartId;
   }
 
   public void setCartId(String cartId)
   {
     this.cartId = cartId;
  }
 
   public String getPaidStatus()
   {
    return this.paidStatus;
  }

  public void setPaidStatus(String paidStatus)
  {
    this.paidStatus = paidStatus;
  }

  public String getCustomername()
  {
    return this.customername;
  }

  public void setCustomername(String customername)
  {
    this.customername = customername;
   }

   public String getProductname()
  {
    return this.productname;
  }

  public void setProductname(String productname)
  {
    this.productname = productname;
  }

  public String getQuantity()
  {
    return this.quantity;
  }

  public void setQuantity(String quantity)
  {
    this.quantity = quantity;
  }
 }

