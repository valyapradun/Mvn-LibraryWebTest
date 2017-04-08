package by.htp.library.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.library.domain.Book;

public class BookDaoImpl implements BookDao {
	
	private static final String DRIVER = "jdbc:mysql://localhost/webdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
		
	public BookDaoImpl(){
			
	}
	
	public boolean addBook(Book newbook) {
		boolean resultAdd = false;
		if (newbook != null) {
			Connection connection = new UtilDao().connection(DRIVER, USER, PASSWORD);
			if (connection != null){
				Statement query;
				try {
					query = connection.createStatement();
					int result = query.executeUpdate("INSERT INTO book(`TITLE`, `AUTHOR`, `PRICE`, `SRC`) "
							+ "VALUES ('" + newbook.getTitle() + "', '" + newbook.getAuthor() + "', '" +
							newbook.getPrice() + "', '" + newbook.getSrc() + "');");
					if (result != 0) {
						resultAdd = true;
					}	
				} catch (SQLException e) {
					System.err.println("SQL Exception!" + e.getMessage() + e);
				} finally {
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException e) {
							System.err.println("SQL Exception!" + e.getMessage() + e);
						}
					}
				}	
			}	
		}
		return resultAdd;
	}

}
