package by.htp.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDao {
	public Connection connection(String driver, String user, String password){
		Connection connect = null;
		try {
		connect = DriverManager.getConnection(driver, user, password);
		  if (connect == null) {
              System.out.println("There is no connection with a DB!");
              System.exit(0);
          }
		} catch (SQLException e){
			System.err.println("SQL Exception!" + e.getMessage() + e);
		} 
		return connect;
	}
}
