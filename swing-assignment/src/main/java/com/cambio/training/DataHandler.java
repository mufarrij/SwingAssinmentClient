package com.cambio.training;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * DataHandler class is used to hold and handle data related to patients
 */
public final class DataHandler
{
  /**
   * patientList  used to store patient objects
   */
  public static List<Patient> patientList = new ArrayList<Patient>();
  public static List<Patient> searchList = new ArrayList<Patient>();


  public static PatientTableModel patientTableModel;


  // defining birthdays for three sample patients
  Calendar myCalendar1 = new GregorianCalendar(1992, 5, 11);
  Date p1BirthDate = myCalendar1.getTime();
  Calendar myCalendar2 = new GregorianCalendar(2019, 0, 1);
  Date p2BirthDate = myCalendar2.getTime();
  Calendar myCalendar3 = new GregorianCalendar(2016, 11, 24);
  Date p3BirthDate = myCalendar3.getTime();

  /**
   * constructor for data handler
   * initializing patient list with sample data
   */
  public DataHandler() {
    Patient p1 = new Patient("Nimal", "0772546890", p1BirthDate, "Male", "26 years", "3,Torington,Colombo-7.", "Student");
    Patient p2 = new Patient("Kamal", "0762545890", p2BirthDate, "Male", "0 years 2 months", "21,Dehigastalawa,Balangoda.", "Unemployed");
    Patient p3 = new Patient("Vimala", "0772546870", p3BirthDate, "Female", "2 years 4 month", "34,Ramakrishna road,Colombo-6.", "Part Time");
    patientList.add(p1);
    patientList.add(p2);
    patientList.add(p3);
    patientTableModel = new PatientTableModel(patientList);
  }

  /**
   * getPatientTableModel is the getter method for get patientTableModel
   * @return patientTableModel object of dataHandler
   */
  public PatientTableModel getPatientTableModel()
  {
    return patientTableModel;
  }

  /**
   * addPatient method takes patient object as input and add it to patientList
   * @param p takes patient object as input
   */
  public void addPatient(Patient p)
  {
    this.patientList.add(p);
    patientTableModel = new PatientTableModel(patientList);
  }

  /**
   * addSearchPatient method takes patient object as input and add it to  searchList
   * @param p takes patient object as input
   */
  public void addSearchPatient(Patient p)
  {
    this.searchList.add(p);
  }

  /**
   * fillSearchData method fills the searcList according to search criteria
   * @param name name of the patient string
   * @param birthYear patient birth Year in string
   * @param gender patient gender in string
   */
  public void fillSearchData(String name, String birthYear, String gender)
  {
    for (Patient p : patientList)
    {
      SimpleDateFormat df = new SimpleDateFormat("yyyy");
      String patientBirthYear = df.format(p.getBirthDay());

      if (name != "" && birthYear != "" && gender != "")
      {
        if ( name.equalsIgnoreCase(p.getName()) && patientBirthYear.equalsIgnoreCase(birthYear) && p.getGender() == gender )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name == "" && birthYear != "" && gender != "" )
      {
        if ( patientBirthYear.equalsIgnoreCase(birthYear) && p.getGender() == gender )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name !="" && birthYear == "" && gender !="" )
      {
        if ( name.equalsIgnoreCase(p.getName()) && p.getGender() == gender )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name !="" && birthYear != "" && gender =="" )
      {
        if (  name.equalsIgnoreCase(p.getName()) && patientBirthYear.equalsIgnoreCase(birthYear) )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name =="" && birthYear != "" && gender =="" )
      {
        if ( patientBirthYear.equalsIgnoreCase(birthYear) )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name != "" && birthYear == "" && gender =="" )
      {

        if ( name.equalsIgnoreCase(p.getName()) )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name =="" && birthYear == "" && gender !="" )
      {
        if ( p.getGender() == gender )
        {
          this.addSearchPatient(p);
        }
      }
      else if( name =="" && birthYear == "" && gender == "")
      {
        this.addSearchPatient(p);
      }

    }

  }

}

