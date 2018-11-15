package data;

import util.ConnectionUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


import org.apache.log4j.Logger;
import test.tomcat.beans.userandpass;

public class session {
	final static Logger Log = Logger.getLogger(session.class);
	
	public int attemptLogin(userandpass Logincreds) {
		System.out.println(Logincreds.getUsername());
		String sql = "select empid from employee where uname = '" + Logincreds.getUsername() + "' AND pword = '" + Logincreds.getPassword() + "'";
		System.out.println(sql);

		try (Connection conn = ConnectionUtil.getConnection()){
			System.out.println("successs!");
			PreparedStatement stmt = conn.prepareStatement(sql);
			Log.info("checking login");
			int output = stmt.executeUpdate();
			System.out.println(output);
			return output;
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid login");
			s.getMessage();
		}
		return 0;
	}
	
	public String genericCall(String sql) {
		try (Connection conn = ConnectionUtil.getConnection()){
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet result = pstm.executeQuery();
			Log.info("Generic Call of DB Success");
			return "success";
		}
		catch (SQLException | ClassNotFoundException s) {
			Log.error("Invalid Generic Call");
			s.getMessage();
		}
		return "error";
	}
	
}
