 package com.quickshop.dae.model;
 
 public class StaffBean
 {
  private int empid;
  private String empname;
  private String designation;
  private String jdate;
  private String salary;
  private String accno;
  private String contactaddress;
  private String phoneno;

   public void setEmpId(int empid)
   {
     this.empid = empid;
  }
 
  public void setEmpName(String empname)
  {
    this.empname = empname;
  }

  public void setDesignatin(String designation)
  {
    this.designation = designation;
  }

  public void setDoj(String jdate)
  {
     this.jdate = jdate;
   }
 
   public void setSalary(String salary)
  {
    this.salary = salary;
  }
 
   public void setAccno(String accno)
   {
     this.accno = accno;
   }

  public void setContactAddress(String contactaddress)
  {
     this.contactaddress = contactaddress;
   }
 
   public void setPhoneNo(String phoneno)
  {
    this.phoneno = phoneno;
  }

   public int getEmpId()
   {
     return this.empid;
   }
 
   public String getEmpName()
   {
     return this.empname;
   }
 
   public String getDesignatin()
   {
     return this.designation;
  }

  public String getDoj()
  {
    return this.jdate;
   }

  public String getSalary()
   {
     return this.salary;
   }
 
   public String getAccno()
   {
     return this.accno;
   }
 
   public String getContactAddress()
   {
     return this.contactaddress;
   }
 
  public String getPhoneNo()
  {
    return this.phoneno;
   }
 }

