package SuperLiga;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection dbConnection;
	
	private final static String host = "localhost";
	private final static String dbName = "superliga";
	private final static String username = "root";
	private final static String password = "egzonavllasaliu12345";
	
	public static Connection getConnection() {
		if(dbConnection == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				dbConnection = 
						DriverManager.getConnection("jdbc:mysql://" + host+ "/" + dbName, username, password);
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return dbConnection;
	}
		
}
