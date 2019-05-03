package com.cambio.training;

import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utility {

  /**
   * monthsToYears takes number of months as input and returns number of years equal
   * @param months
   * @return number of years as string
   */
  public static String monthsToYears(int months )
  {
    int years = months / 12; // 1
    return Integer.toString( years ) + " Years";
  }

  /**
   * monthsToYears takes number of months as input and returns it as years and months
   * @param months
   * @return number of years and months as string
   */
  public static String monthsToYearsAndMonths( int months )
  {
    int years = months / 12; // 1
    int remainingMonths = months % 12; // 6
    String convertedTime = Integer.toString( years ) + " Years " + Integer.toString( remainingMonths ) + " Months";

    return convertedTime;
  }

  /**
   * phoneNumberFieldCheck method takes input character to the text field as input and return true if it is not a number
   * @param c
   * @return returns boolean value
   */
  public static boolean phoneNumberFieldCheck(char c)
  {
    if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))){
      return true;
    }
    return false;
  }

  /**
   * isAgeLessThreeMonths method intended to check if a given age is less than three months
   * @param birthDay get birth day Date as argument
   * @return if the age is less than three months return true otherwise return false
   */
  public static boolean isAgeLessThreeMonths(Date birthDay)
  {

    Calendar cal = Calendar.getInstance();
    Date today = (Date)cal.getTime();
    Long diff =today.getTime() - birthDay.getTime();
    Long diffinMonths = diff / 1000 / 60 / 60 / 24 / 30 ;
    if(diffinMonths < 3)
    {
      return true;
    }
    else
    {
      return false;
    }

  }

  public static void main(String[] args) {

    System.out.println( "25 months IS EQUAL " + Utility.monthsToYearsAndMonths(25));

    Calendar myCalendar = new GregorianCalendar(2018, 0, 11);
    Date myDate = myCalendar.getTime();
    System.out.println(isAgeLessThreeMonths(myDate));

  }

}
