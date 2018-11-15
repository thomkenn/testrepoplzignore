package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		//aws end point
		String url="jdbc:oracle:thin:@test-db.cidv0cvpvpay.us-west-2.rds.amazonaws.com:1521:ORCL";
		String user = "root";
		String pass = "password";
		return DriverManager.getConnection(url, user, pass);
	}

	
}
