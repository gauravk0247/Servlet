package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTil {
	public static Connection getDBConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc1","root","gaurav@123");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		return con;
	}
}