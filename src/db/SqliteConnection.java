package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Shepyke
 */
public class SqliteConnection {
      public static Connection Connector(){
          try{
              Class.forName("org.sqlite.JDBC");
              Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Shepyke\\Desktop\\szakdoga\\Sequence\\src\\db\\SequenceDB.sqlite");
              return connection;            
          }catch(Exception e){
            return null;
          }
      }
}
