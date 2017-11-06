 package com.quickshop.project.model;
 
 import com.quickshop.core.model.AbstractDataObject;
 
 public class Sample extends AbstractDataObject
{
  private int sno;
  private String sname;
  private int age;
 private String address;

  public int getSno()
  {
    return this.sno;
  }

  public void setSno(int sno)
  {
    this.sno = sno;
  }

   public String getSname()
  {
   return this.sname;
 }

   public void setSname(String sname)
   {
    this.sname = sname;
  }

  public int getAge()
  {
   return this.age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }
 
  public String getAddress()
  {
    return this.address;
  }

  public void setAddress(String address)
   {
     this.address = address;
   }
 }

