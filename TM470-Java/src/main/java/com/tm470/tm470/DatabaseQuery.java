
package com.tm470.tm470;

/**
 *
 * @author Jason
 */

import java.sql.*;

class DatabaseQuery {
   
String dbURL = "jdbc:mysql://localhost:3306/mysql";
String username ="root";
String password = "password";
Connection dbCon = null;
Statement stmt = null;
ResultSet resultSet = null;

   
   public float[] overallMetrics() throws SQLException {
      System.out.println("Started...");
        float overallResult[] = new float[4];
        String query = "SELECT * FROM metrics.process_data WHERE department = 'Inbound' AND update_time >= '2022-06-23 08:00:00' AND update_time <= '2022-06-23 18:00:00';";
            
        try {
           
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);

            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
            //Resultset returned by query
            resultSet = stmt.executeQuery(query);
                  
         while(resultSet.next()){
            System.out.println("ENTERED");
            
            overallResult[0] = resultSet.getFloat(5);
            overallResult[1] = resultSet.getFloat(6);
            overallResult[2] = resultSet.getFloat(7);
            overallResult[3] = resultSet.getFloat(8);
            }
         
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        } finally{
           System.out.println("FINISHED!");
           dbCon.close();
           
           for(int i = 0; i <= overallResult.length -1; i++)
              {
                  System.out.println(overallResult[i]);
              }
           return overallResult;
      }
   }

   public float[] hourlyOverall(String query) throws SQLException {
      System.out.println("Started...");
        float overallResult[] = new float[4];
            
        try {
           
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);

            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
            //Resultset returned by query
            resultSet = stmt.executeQuery(query);
            
         while(resultSet.next()){
            System.out.println("ENTERED");
            
            overallResult[0] = resultSet.getFloat(1);
            overallResult[1] = resultSet.getFloat(2);
            overallResult[2] = resultSet.getFloat(3);
            overallResult[3] = resultSet.getFloat(4);
            }
         
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        } finally{
           System.out.println("FINISHED!");
           dbCon.close();
           
           for(int i = 0; i <= overallResult.length -1; i++)
              {
                  System.out.println(overallResult[i]);
              }
           return overallResult;
      }
   }
   
      public float[] subprocessMetrics(String query) throws SQLException {
      System.out.println("Started...");
        float subResult[] = new float[4];
        
        try {
           
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, password);

            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
            //Resultset returned by query
            resultSet = stmt.executeQuery(query);
            
         while(resultSet.next()){
            System.out.println("ENTERED");
            subResult[0] = resultSet.getFloat(1);

            }
         
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
        } finally{
           System.out.println("FINISHED!");
           dbCon.close();
           
           for(int i = 0; i <= subResult.length -1; i++)
              {
                  System.out.println(subResult[i]);
              }
           return subResult;
      }
   }
   
   public float[] getHour1() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 08:00:00' AND update_time <= '2022-06-23 09:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour2() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 09:00:00' AND update_time <= '2022-06-23 10:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour3() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 10:00:00' AND update_time <= '2022-06-23 11:00:00';";
      return this.hourlyOverall(query);
   }

   public float[] getHour4() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 11:00:00' AND update_time <= '2022-06-23 12:00:00';";
      return this.hourlyOverall(query);
   }

   public float[] getHour5() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 12:00:00' AND update_time <= '2022-06-23 13:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour6() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 13:00:00' AND update_time <= '2022-06-23 14:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour7() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 14:00:00' AND update_time <= '2022-06-23 15:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour8() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 15:00:00' AND update_time <= '2022-06-23 16:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour9() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 16:00:00' AND update_time <= '2022-06-23 17:00:00';";
      return this.hourlyOverall(query);
   }
   
   public float[] getHour10() throws SQLException
   {
      String query = "SELECT SUM(actual_hours) AS Total_Hours, SUM(actual_volume) AS Total_Volume, SUM(plan_hours) AS Total_Plan, SUM(actual_volume) / SUM(plan_hours) AS Actual_Rate FROM metrics.process_data WHERE update_time >= '2022-06-23 17:00:00' AND update_time <= '2022-06-23 18:00:00';";
      return this.hourlyOverall(query);
   }
      
}
