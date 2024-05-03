package dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	// Método para realizar a conexão com o banco de dados
	public static Connection doConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost/auth", "root", "12345");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new SQLException("Driver JDBC não encontrado: " + e.getMessage());
		}
	}
	
	
	// MAIN
	public static void main(String[] args) throws SQLException {
		doConnection();
	}
	
}

