package model;


import db.SqliteConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Shepyke
 */
public class LoginModel {
  Connection connection;
  
  public LoginModel(){
      connection = SqliteConnection.Connector();
      if(connection == null){
          System.exit(1);
      }             
  }
  
  public boolean isDbConnected(){
      try {
          return !connection.isClosed();
      } catch (SQLException e) {
          e.printStackTrace();
          return false;
      }
  }
}
