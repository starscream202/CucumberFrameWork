package com.hrms.Utils;

import org.openqa.selenium.support.PageFactory;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;

public class db_Utils {
    private static Connection conn;
    private static Statement statement;
    private static  ResultSet resultSet;
    private static Map map;

    public static Connection getConnection(){//establishes connection to database

       try{
            conn=DriverManager.getConnection(
                   ConfigReader.getPropertyValue("db_Url"),
                   ConfigReader.getPropertyValue("db_Username"),
                   ConfigReader.getPropertyValue("db_Pass"));

       }catch(SQLException e){
           e.printStackTrace();
        }

        return conn;
    }

    public static ResultSet getResultSet(String query){//returns resultSet

        try{
            statement=getConnection().createStatement();
            resultSet=statement.executeQuery(query);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;

    }

    public static List<Map<String,String>> getDBDataIntoList(String query){//returns list of map data from database
        List<Map<String,String>> dbList=new ArrayList<>();
        try{
            ResultSetMetaData resultSetMetaData=getResultSet(query).getMetaData();
            while (resultSet.next()){//loops through each row
                map=new LinkedHashMap<>();

                for(int c=1; c<=resultSetMetaData.getColumnCount(); c++){//loops through each column
                    map.put(resultSetMetaData.getColumnName(c),resultSet.getString(c));
                }
                dbList.add(map);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }
        return dbList;

    }public static void closeConnection(){
        try{
            if(resultSet!= null){
                resultSet.close();
            }if(statement != null){
                statement.close();
            }if(conn != null){
                conn.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static List<String> getDBDataIntoListofString(String query){
        List<String> dbList=new ArrayList<>();
        try{
            ResultSetMetaData resultSetMetaData= getResultSet(query).getMetaData();
            while(resultSet.next()){
                for(int row=1; row<=resultSetMetaData.getColumnCount();row++){
                    String data= resultSet.getString(row);
                    dbList.add(data);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            closeConnection();
        }return dbList;
    }
}

