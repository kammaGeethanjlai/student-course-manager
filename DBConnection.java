import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static String url="jdbc:mysql://localhost:3306/studentdb";
	static String user="root";
	static String password="1234";

	public static Connection getConnection() {
		try {
			
			return DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			System.out.println("DB connection failed: "+e.getMessage());
			return null;
		}
	}

}
