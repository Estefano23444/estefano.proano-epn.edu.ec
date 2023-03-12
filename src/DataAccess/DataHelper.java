package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
  private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
  private static final String DB_CONNECTION = "jdbc:mysql://hostname:port/database_name";
  private static final String DB_USER = "username";
  private static final String DB_PASSWORD = "password";

  public static Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName(DB_DRIVER);
      connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}
/**
 * Este código utiliza el controlador JDBC para conectarse a una 
 * base de datos en la nube. Puedes reemplazar los valores DB_CONNECTION, 
 * DB_USER y DB_PASSWORD con tus propios valores correspondientes para 
 * conectarte a tu base de datos en la nube.
 */
