package org.apache.commons.lang.time;



import java.text.ParseException;

import java.text.ParsePosition;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.Iterator;

import java.util.NoSuchElementException;

import java.util.TimeZone;

import java.util.GregorianCalendar;







import junit.framework.*;





public class StudentTest extends TestCase {







  // Test 1

  public void testisSameDateDate1Null() {

    Date date1 = null;

    Date date2 = new Date();



    try {

        DateUtils.isSameDay(date1,date2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }

  }

  

  



  // Test 2

  public void testisSameDateDate2Null() {

    Date date2 = null;

    Date date1 = new Date();



    try {

        DateUtils.isSameDay(date1,date2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }

  }







// Test 3

  public void testisSameDayCal1Null() {

     GregorianCalendar cal2 = new GregorianCalendar(2004, 6, 9, 13, 45);

     GregorianCalendar cal1 = null;



    try {

     DateUtils dateUtils = new DateUtils();

        dateUtils.isSameDay(cal1,cal2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }

  }





  // Test 4

  public void testisSameDayCal2Null() {

     GregorianCalendar cal1 = new GregorianCalendar(2004, 6, 9, 13, 45);

     GregorianCalendar cal2 = null;



    try {

     DateUtils dateUtils = new DateUtils();

        dateUtils.isSameDay(cal1,cal2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }

  }



  // Test 5 

  public void testIsSameDayCalEra() {

     GregorianCalendar cal1 = new GregorianCalendar(GregorianCalendar.AD, 2004, Calendar.JUNE, 9, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar(GregorianCalendar.BC,-2004, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));





     cal1 = new GregorianCalendar(GregorianCalendar.BC,-2004, Calendar.JUNE, 9, 13, 45);

     cal2 = new GregorianCalendar(GregorianCalendar.AD,2004, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));

 }







  // Test 6

  public void testIsSameDayCalDifYear() {

     GregorianCalendar cal1 = new GregorianCalendar( 2005, Calendar.JUNE, 9, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar( 2003, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));





     cal1 = new GregorianCalendar( 2003, Calendar.JUNE, 9, 13, 45);

     cal2 = new GregorianCalendar( 2005, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));

  }







  // Test 7 

  public void testIsSameDayCalDifDay() {

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 10, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));



     cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);

     cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 10, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));

  }









  // Test 8

  public void testIsSameDayCalDif() {

     GregorianCalendar cal1 = new GregorianCalendar(GregorianCalendar.AD, 2003, Calendar.JULY, 5, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar(GregorianCalendar.BC,-2005, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameDay(cal1, cal2));

  }





  // Test 9

  public void testIsSameInstantDate1Null() {

     Date date1 = null;

     Date date2 = new Date();



    try {

        DateUtils.isSameInstant(date1,date2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage());

   }

 }







  // Test 10

  public void testIsSameInstantDate2Null() {

     Date date2 = null;

     Date date1 = new Date();



    try {

        DateUtils.isSameInstant(date1,date2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }



  }



    // Test 11

  public void testIsSameInstantDateDif() {

     Date date1 = new GregorianCalendar(2003, 6, 9, 13, 45).getTime();

     Date date2 =  new GregorianCalendar(2005, 6, 9, 13, 45).getTime();

     assertEquals(false, DateUtils.isSameInstant(date1, date2));



     date1 = new GregorianCalendar(2005, 6, 9, 13, 45).getTime();

     date2 =  new GregorianCalendar(2003, 6, 9, 13, 45).getTime();

     assertEquals(false, DateUtils.isSameInstant(date1, date2));

  }



 

   // Test 12

  public void testIsSameInstantCal1Null() {

     GregorianCalendar cal1 =null;

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);



    try {

        DateUtils.isSameInstant(cal1,cal2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage());

   }

 }

  

  // Test 13

  public void testIsSameInstantCal2Null() {

     GregorianCalendar cal2 =null;

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);



    try {

        DateUtils.isSameInstant(cal1,cal2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }



  }



    // Test 14

  public void testIsSameInstantCalDif() {

     GregorianCalendar cal1 = new GregorianCalendar( 2003, Calendar.JUNE, 10, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar( 2005, Calendar.JUNE, 9, 13, 45);

     assertEquals(false, DateUtils.isSameInstant(cal1, cal2));



     cal2 = new GregorianCalendar( 2003, Calendar.JUNE, 10, 13, 45);

     cal1 = new GregorianCalendar( 2005, Calendar.JUNE, 9, 13, 45);

     assertEquals(false, DateUtils.isSameInstant(cal1, cal2));

  }





   // Test 15

  public void testisSameLocalTimeCal1Null() {

     GregorianCalendar cal1 =null;

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);



    try {

        DateUtils.isSameLocalTime(cal1,cal2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage());

   }

 }



  // Test 16

  public void testisSameLocalTimeCal2Null() {

     GregorianCalendar cal2 =null;

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);



    try {

        DateUtils.isSameLocalTime(cal1,cal2);

        fail( "Missing exception" );

   } catch( IllegalArgumentException e ) {

        assertEquals( "The date must not be null", e.getMessage() );

   }



  }  



   // Test 17

  public void testisSameLocalTimeDifMiliSec() {

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);

     cal1.set(Calendar.MILLISECOND, 500);



     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);

     cal2.set(Calendar.MILLISECOND, 200);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     cal1.set(Calendar.MILLISECOND, 200);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  



// Test 18

  public void testisSameLocalTimeDifSeconds() {

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45,2);

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45,10);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45,2);

     cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45,10);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  



  // Test 19

  public void testisSameLocalTimeDifMinutes() {

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 30,2);

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45,2);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 30,2);

     cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45,2);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  







  // Test 20

  public void testisSameLocalTimeDifHours() {

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 10, 45);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 13, 45);

     cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 10, 45);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  







    // Test 21

  public void testisSameLocalTimeDifDayOfYear() {

     GregorianCalendar cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 5, 10, 45);

     GregorianCalendar cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 10, 45);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     cal2 = new GregorianCalendar( 2004, Calendar.JUNE, 5, 10, 45);

     cal1 = new GregorianCalendar( 2004, Calendar.JUNE, 9, 10, 45);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  





    // Test 22

  public void testisSameLocalTimeDifYear() {

     GregorianCalendar cal1 = new GregorianCalendar( 2003, Calendar.JUNE, 9, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar( 2005, Calendar.JUNE, 9, 13, 45);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     cal2 = new GregorianCalendar( 2003, Calendar.JUNE, 9, 13, 45);

     cal1 = new GregorianCalendar( 2005, Calendar.JUNE, 9, 13, 45);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  

    

    // Test 23

  public void testisSameLocalTimeDifEra() {

         GregorianCalendar cal1 = new GregorianCalendar(GregorianCalendar.AD, 2004, Calendar.JUNE, 9, 13, 45);

     GregorianCalendar cal2 = new GregorianCalendar(GregorianCalendar.BC,-2004, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));





     cal1 = new GregorianCalendar(GregorianCalendar.BC,-2004, Calendar.JUNE, 9, 13, 45);

     cal2 = new GregorianCalendar(GregorianCalendar.AD,2004, Calendar.JUNE, 9, 13, 45);

     

     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  





     private class MyCustomCalendarSubclass extends GregorianCalendar {

      

          public MyCustomCalendarSubclass() {

              super();

          }



          public MyCustomCalendarSubclass(int var1, int var2, int var3, int var4, int var5, int var6) {

               super(var1, var2, var3, var4, var5, var6);

          }



     }





  // Test 24

  public void testisSameLocalTimeDifClass(){

     



     GregorianCalendar cal1 = new GregorianCalendar(2003, Calendar.JUNE, 2, 13, 42,10);

     MyCustomCalendarSubclass cal2 = new MyCustomCalendarSubclass(2003, Calendar.JUNE, 2, 13, 42,10);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));





  }





  // Test 25

  public void testisSameLocalTimeDif() {

     GregorianCalendar cal1 = new GregorianCalendar(GregorianCalendar.AD, 2003, Calendar.JUNE, 2, 13, 42);

     MyCustomCalendarSubclass customCal = new MyCustomCalendarSubclass(GregorianCalendar.BC,2003, Calendar.JUNE, 2, 13, 42);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, customCal));





     // ERA and YEAR

     cal1 = new GregorianCalendar(GregorianCalendar.AD, 2003, Calendar.JUNE, 2, 13, 42);

     cal1.set(Calendar.MILLISECOND, 500);



     GregorianCalendar cal2 = new GregorianCalendar(GregorianCalendar.BC,-2005, Calendar.JUNE, 2, 13, 42);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));





     // YEAR and DAY_OF_YEAR

     cal1 = new GregorianCalendar(2003, Calendar.JUNE, 5, 13, 42);

     cal1.set(Calendar.MILLISECOND, 500);



     cal2 = new GregorianCalendar(2005, Calendar.JUNE, 2, 13, 42);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     // DAY_OF_YEAR an HOURS

     cal1 = new GregorianCalendar(2003, Calendar.JUNE, 5, 13, 42);

     cal1.set(Calendar.MILLISECOND, 500);



     cal2 = new GregorianCalendar(2003, Calendar.JUNE, 2, 10, 42);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));





     // HOURS and MINUTES

     cal1 = new GregorianCalendar(2003, Calendar.JUNE, 5, 13, 40);

     cal1.set(Calendar.MILLISECOND, 500);



     cal2 = new GregorianCalendar(2003, Calendar.JUNE, 5, 10, 42);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));





     // MINUTES and SECONDS

     cal1 = new GregorianCalendar(2003, Calendar.JUNE, 5, 10, 30,2);

     cal1.set(Calendar.MILLISECOND, 500);



     cal2 = new GregorianCalendar(2003, Calendar.JUNE, 5, 10, 42,12);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



     // SECONDS and MILISECONDS

     cal1 = new GregorianCalendar(2003, Calendar.JUNE, 5, 10, 42,2);

     cal1.set(Calendar.MILLISECOND, 200);



     cal2 = new GregorianCalendar(2003, Calendar.JUNE, 5, 10, 42,12);

     cal2.set(Calendar.MILLISECOND, 500);



     assertEquals(false, DateUtils.isSameLocalTime(cal1, cal2));



  }  





  // Test 26

  public void testParseDateBothNull(){



     try {

          DateUtils.parseDate(null, null);

          fail( "Missing exception" );

     } catch( IllegalArgumentException e ) {

          assertEquals( "Date and Patterns must not be null", e.getMessage() );

     } catch(ParseException p){}



  }



  // Test 27

  public void testParseDateWrong() throws Exception  {

     GregorianCalendar cal = new GregorianCalendar(1972, Calendar.DECEMBER, 3);

     String dateStr = "1972-12-03";

     String[] parsers = new String[] {"yyyy'-'DDD",  "yyyyMMdd"};



     try {

          DateUtils.parseDate(dateStr, parsers);

          fail();

      } catch (ParseException ex) {

          assertEquals(-1,ex.getErrorOffset());

      }

  }





  // Test 28

  public void testAddDateNull(){



     try {

          DateUtils.add(null, Calendar.MONTH,1);

          fail();

      } catch (IllegalArgumentException ex) {

          assertEquals("The date must not be null",ex.getMessage());

      }

  }





  // Test 29

  public void testRoud500ms(){

     Calendar cal = new GregorianCalendar(1972, Calendar.DECEMBER, 3);

     cal.set(Calendar.MILLISECOND, 500);



     cal = DateUtils.round(cal,Calendar.SECOND);

     

     assertEquals(1, cal.get(Calendar.SECOND));

  }





    // Test 30

  public void testRoud30s(){

     Calendar cal = new GregorianCalendar(1972, Calendar.DECEMBER, 3,0,0,30);



     cal = DateUtils.round(cal,Calendar.MINUTE);

     

     assertEquals(1, cal.get(Calendar.MINUTE));

  }

      



    // Test 31

  public void testRoud30m(){

     Calendar cal = new GregorianCalendar(1972, Calendar.DECEMBER, 3,0,30,30);



     cal = DateUtils.round(cal,Calendar.HOUR);

     

     assertEquals(1, cal.get(Calendar.HOUR));

  }





 // Test 32

  public void testSemiMonth(){

     Calendar cal = new GregorianCalendar(1972, Calendar.OCTOBER, 30,0,30,30);



     cal = DateUtils.round(cal,DateUtils.SEMI_MONTH);

     

     assertEquals(Calendar.NOVEMBER, cal.get(Calendar.MONTH));

     assertEquals(1, cal.get(Calendar.DATE));



  }



   // Test 33

  public void testSemiMonth15Days(){

     Calendar cal = new GregorianCalendar(1972, Calendar.OCTOBER, 23,0,30,30);



     cal = DateUtils.round(cal,DateUtils.SEMI_MONTH);

     

     assertEquals(Calendar.OCTOBER, cal.get(Calendar.MONTH));

     assertEquals(16, cal.get(Calendar.DATE));



  }



   // Test 34

  public void testAM_PM12Hours(){

     Calendar cal = new GregorianCalendar(1972, Calendar.OCTOBER, 18,12,30,30);



     cal = DateUtils.round(cal,Calendar.AM_PM);

     

     assertEquals(18, cal.get(Calendar.DAY_OF_MONTH));

     assertEquals(12, cal.get(Calendar.HOUR_OF_DAY));



  }





   // Test 35

  public void testAM_PM6Offset(){

     Calendar cal = new GregorianCalendar(1972, Calendar.OCTOBER, 18,18,30,30);



     cal = DateUtils.round(cal,Calendar.AM_PM);

     

     assertEquals(18, cal.get(Calendar.DAY_OF_MONTH));

     assertEquals(12, cal.get(Calendar.HOUR_OF_DAY));



  }



  // Test 36

  public void testRoundMonths(){

     Calendar cal = new GregorianCalendar(1972, Calendar.OCTOBER, 17,18,30,32);



     cal = DateUtils.round(cal,Calendar.MONTH);

     

     assertEquals(Calendar.NOVEMBER, cal.get(Calendar.MONTH));



  }

  

   // Test 37

  public void testRoundMonthsDay16(){

     Calendar cal = new GregorianCalendar(1972, Calendar.OCTOBER, 16,15,30,32);



     cal = DateUtils.round(cal,Calendar.MONTH);

     

     assertEquals(Calendar.OCTOBER, cal.get(Calendar.MONTH));



  }



  // Test 38

  public void testMonthLastDaySaturday(){

     Calendar cal = new GregorianCalendar(2023, Calendar.SEPTEMBER, 16,15,30,32);



     Iterator  iterator = DateUtils.iterator(cal,DateUtils.RANGE_MONTH_SUNDAY);

      



      Calendar firstDate = (Calendar) iterator.next();

       

      Calendar lastDate = null;

      while (iterator.hasNext()) {

            lastDate = (Calendar) iterator.next();

      }



      assertEquals(Calendar.SEPTEMBER, lastDate.get(Calendar.MONTH));

      assertEquals(30, lastDate.get(Calendar.DAY_OF_MONTH));



      assertEquals(Calendar.AUGUST, firstDate.get(Calendar.MONTH));

      assertEquals(27, firstDate.get(Calendar.DAY_OF_MONTH));



  }



  // Test 39

  public void testMonthLastDayNotSaturday(){

     Calendar cal = new GregorianCalendar(2023, Calendar.DECEMBER, 16,15,30,32);



     Iterator  iterator = DateUtils.iterator(cal,DateUtils.RANGE_MONTH_SUNDAY);

      



      Calendar firstDate = (Calendar) iterator.next();

       

      Calendar lastDate = null;

      while (iterator.hasNext()) {

            lastDate = (Calendar) iterator.next();

      }



      assertEquals(Calendar.JANUARY, lastDate.get(Calendar.MONTH));

      assertEquals(6, lastDate.get(Calendar.DAY_OF_MONTH));



      assertEquals(Calendar.NOVEMBER, firstDate.get(Calendar.MONTH));

      assertEquals(26, firstDate.get(Calendar.DAY_OF_MONTH));



  }



   // Test 40

  public void testCalendarNull(){

     Calendar cal = null;



     try{

           Iterator  iterator = DateUtils.iterator(cal,DateUtils.RANGE_MONTH_SUNDAY);

         fail();

     }catch(IllegalArgumentException e){

         assertEquals("The date must not be null",e.getMessage());

     }      



      



  }



  // Test 41

  public void testMondayToSunday(){

     Calendar cal = new GregorianCalendar(2023, Calendar.DECEMBER, 16,15,30,32);



     Iterator  iterator = DateUtils.iterator(cal,DateUtils.RANGE_MONTH_MONDAY);

      



      Calendar firstDate = (Calendar) iterator.next();

       

      Calendar lastDate = null;

      while (iterator.hasNext()) {

            lastDate = (Calendar) iterator.next();

      }



      assertEquals(Calendar.NOVEMBER, firstDate.get(Calendar.MONTH));

      assertEquals(27, firstDate.get(Calendar.DAY_OF_MONTH));



      assertEquals(Calendar.DECEMBER, lastDate.get(Calendar.MONTH));

      assertEquals(31, lastDate.get(Calendar.DAY_OF_MONTH));



  }





}