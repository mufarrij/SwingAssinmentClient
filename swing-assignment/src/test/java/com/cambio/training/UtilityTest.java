package com.cambio.training;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilityTest extends TestCase
{

  @Test
  public void  testMonthToYears_monthsNotDevidedByTwelve_returnYears()
  {

    assertEquals("2 Years",Utility.monthsToYears(34));
  }

  @Test
  public void  testMonthToYears_monthsDevidedByTwelve_returnYears()
  {

    assertEquals("3 Years",Utility.monthsToYears(36));
  }

  @Test
  public void testMonthToYearsAndMonths_monthsNotDevidedByTwelve_returnYearsAndMonths()
  {

    assertEquals("2 Years 8 Months",Utility.monthsToYearsAndMonths(32));
  }

  @Test
  public void testMonthToYearsAndMonths_monthsDevidedByTwelve_returnYearsAndMonths()
  {

    assertEquals("4 Years 0 Months",Utility.monthsToYearsAndMonths(48));
  }

  @Test
  public void testPhoneNumberField_characterIsaNumber_returnsFalse()
  {

    assertEquals(false,Utility.phoneNumberFieldCheck('8'));
  }

  @Test
  public void testPhoneNumberField_characterIsNotaNumber_returnsTrue()
  {
    assertEquals(true,Utility.phoneNumberFieldCheck('{'));
  }

  @Test
  public void testPhoneNumberField1_characterIsaLetter_returnsTrue()
  {
    assertEquals(true,Utility.phoneNumberFieldCheck('a'));
  }

  @Test
  public void testisAgeLessThreeMonths_ageLessThanThreeMonth_returnTrue(){

    Calendar myCalendar = new GregorianCalendar(2019, 0, 1);
    Date birthDate = myCalendar.getTime();
    assertEquals(true,Utility.isAgeLessThreeMonths(birthDate));
  }

  @Test
  public void testisAgeLessThreeMonths_ageGreaterThanThreeMonth_returnFalse(){

    Calendar myCalendar = new GregorianCalendar(2017, 8, 1);
    Date birthDate = myCalendar.getTime();
    assertEquals(false,Utility.isAgeLessThreeMonths(birthDate));
  }

}
