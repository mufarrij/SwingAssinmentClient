package  com.cambio.training;

import java.util.Date;

/**
 * Patient class is used as blueprint for creating  Patient objects which is used to store patient related information
 */
public class Patient
{
  private String name;
  private String phoneNumber;
  private Date birthDay;
  private String gender;
  private String age;
  private String address;
  private String status;

  public Patient(String name, String phoneNumber,Date birthDay, String gender, String age, String address, String status)
  {

    this.name = name;
    this.phoneNumber = phoneNumber;
    this.gender = gender;
    this.birthDay = birthDay;
    this.age = age;
    this.address = address;
    this.status = status;
  }

  public String getName()
  {

    return name;
  }

  public void setName(String  name)
  {
    this.name = name;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String number)
  {
    this.phoneNumber = number;
  }

  public Date getBirthDay()
  {
    return this.birthDay;
  }

  public void setBirthDay(Date birthDay)
  {
    this.birthDay = birthDay;
  }

  public String getGender()
  {
    return this.gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  public String getAge()
  {
    return age;
  }

  public void setAge(String age)
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

  public String getEmpStatus()
  {
    return this.status;
  }

  public void setEmpStatus(String status)
  {
    this.status = status;
  }

}
