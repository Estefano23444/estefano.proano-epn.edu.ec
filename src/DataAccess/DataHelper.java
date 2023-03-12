package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHelper {
  private static final String EP_DRIVER = "com.mysql.jdbc.Driver";
  private static final String EP_CONNECTION = "jdbc:mysql://hostname:port/database_name";
  private static final String EP_USER = "username";
  private static final String EP_PASSWORD = "password";
  /**
   * 
   * @return
   */
  public static Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName(EP_DRIVER);
      connection = DriverManager.getConnection(EP_CONNECTION, EP_USER, EP_PASSWORD);
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }
}