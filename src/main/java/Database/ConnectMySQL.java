/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectMySQL {
    public static Connection getConnection() throws ClassNotFoundException{
           Connection connection = null;
           try{
                     Class.forName("com.mysql.jdbc.Driver");
                 String Url = "jdbc:mysql://localhost:3306/doanoop?zeroDateTimeBehavior=CONVERT_TO_NULL";
                     String User = "root";
                     String Password = "1234";
                     connection = DriverManager.getConnection(Url, User, Password);
           }
        catch(SQLException ex){
            System.out.println(ex);
        }
           return connection;
    }
}
