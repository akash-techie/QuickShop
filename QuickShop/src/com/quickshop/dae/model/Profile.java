 package com.quickshop.dae.model;
 
 import java.sql.Date;
 
 public class Profile
 {
  private int secretqid;
  private String id;
  private String password;
  private String newpassword;
  private String firstname;
  private String lastname;
  private String logintype;
  private int status;
  private String date;
  private int roleid;
  private int flogin;
  private String timezone;
  private String city;
  private String hno;
  private String street;
  private String phoneNo;
  private String email;
  private String bdate;
  private Date birthDate1;
  private String state;
  private String country;
  private String pincode;
  private String locale;
  private String secretqans;
  private String ownsecretq;
  private String passwordmoddate;
  private String profilemoddate;
 
   public void setLoginID(String id)
  {
    this.id = id;
  }
 
   public void setPassword(String password)
  {
     this.password = password;
   }
 
   public void setNewPassword(String newpassword)
   {
     this.newpassword = newpassword;
  }

 public void setFirstName(String firstname)
  {
    this.firstname = firstname;
  }
 
   public void setLastName(String lastname)
  {
     this.lastname = lastname;
   }
 
   public void setLoginType(String logintype)
   {
    this.logintype = logintype;
  }

  public void setStatus(int status)
  {
    this.status = status;
   }
 
   public void setRegDate(String date)
   {
     this.date = date;
   }
 
   public void setSecretQuestionID(int secretqid)
   {
     this.secretqid = secretqid;
   }

   public void setOwnSecretQuestion(String ownsecretq)
   {
    this.ownsecretq = ownsecretq;
   }
 
   public void setSecretAnswer(String secretqans)
   {
     this.secretqans = secretqans;
   }

  public void setFirstLogin(int flogin)
   {
     this.flogin = flogin;
   }
 
   public void setRoleId(int roleid)
   {
     this.roleid = roleid;
   }
 
   public void setBirthDate(String bdate)
   {
     this.bdate = bdate;
   }
 
  public void setCity(String city)
  {
     this.city = city;
  } 
   public void setState(String state)
   {
     this.state = state;
  }

   public void setCountry(String country)
   {
     this.country = country;
   }
 
   public void setLocale(String locale)
   {
     this.locale = locale;
   }
 
   public void setTimeZone(String timezone)
   {
     this.timezone = timezone;
   }
 
   public void setPasswordModifiedDate(String passwordmoddate)
   {
     this.passwordmoddate = passwordmoddate;
   }
 
   public void setProfileModifiedDate(String profilemoddate)
   {
     this.profilemoddate = profilemoddate;
   }
 
   public String getLoginID()
  {
     return this.id;
   }

  public String getPassword()
   {
     return this.password;
   }
 
   public String getNewPassword()
   {
     return this.newpassword;
   }
 
   public String getFirstName()
   {
     return this.firstname;
   }
 
   public String getLastName()
   {
     return this.lastname;
   }
 
   public String getLoginType()
   {
     return this.logintype;
   }
 
   public int getStatus()
   {
     return this.status;
   }
 
   public String getRegDate()
   {
     return this.date;
   }
 
   public int getSecretQuestionID()
   {
     return this.secretqid;
   }
 
   public String getOwnSecretQuestion()
   {
     return this.ownsecretq;
   }

  public String getSecretAnswer()
   {
     return this.secretqans;
   }
 
   public int getFirstLogin()
   {
     return this.flogin;
   }
 
   public int getRoleId()
   {
     return this.roleid;
   }
 
   public String getBirthDate()
   {
    return this.bdate;
  }

  public String getCity()
  {
    return this.city;
  }

  public String getState()
   {
     return this.state;
   }
 
   public String getCountry()
  {
    return this.country;
  }
 
   public String getLocale()
   {
    return this.locale;
  }

   public String getTimeZone()
   {
     return this.timezone;
   }

  public String getPasswordModifiedDate()
  {
    return this.passwordmoddate;
   }
 
   public String getProfileModifiedDate()
   {
     return this.profilemoddate;
   }
 
   public Date getBirthDate1()
   {
     return this.birthDate1;
   }
 
   public void setBirthDate1(Date birthDate1)
   {
     this.birthDate1 = birthDate1;
   }
 
   public String getHno()
   {
     return this.hno;
  }
 
  public void setHno(String hno)
  {
    this.hno = hno;
   }
 
   public String getStreet()
   {
    return this.street;
  }
 
   public void setStreet(String street)
   {
     this.street = street;
   }
 
   public String getPhoneNo()
   {
     return this.phoneNo;
   }
 
   public void setPhoneNo(String phoneNo)
   {
     this.phoneNo = phoneNo;
   }
 
   public String getEmail()
   {
     return this.email;
   }
 
   public void setEmail(String email)
   {
     this.email = email;
   }

   public String getPincode()
   {
     return this.pincode;
   }
 
   public void setPincode(String pincode)
  {
     this.pincode = pincode;
   }
 }

