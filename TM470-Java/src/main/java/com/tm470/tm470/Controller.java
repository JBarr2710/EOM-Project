
package com.tm470.tm470;

import java.sql.SQLException;

/**
 *
 * @author Jason
 */
public class Controller
{
   
   public static void main(String args[]) throws SQLException
   {
      float totalHours, totalVolume, totalPlan, actualRate;
      DatabaseQuery dbQ = new DatabaseQuery();
      dbQ.overallMetrics();
      dbQ.getHour1();
      dbQ.getHour2();
      dbQ.getHour3();
      dbQ.getHour4();
      dbQ.getHour5();
      dbQ.getHour6();
      dbQ.getHour7();
      dbQ.getHour8();
      dbQ.getHour9();
      dbQ.getHour10();
      
   }  
}
