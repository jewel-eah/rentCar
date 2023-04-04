package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String username = "C##SYSTEM";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("ORACLE 연동 성");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ORACLE 연동 실패");
		}
		
		return conn;
	}
	
	
	public static Connection getConnectionFromMySQL() {
		Connection conn = null;
		
		try {
			Context init = new InitialContext();
			DataSource source = (DataSource) init.lookup("java:comp/env/jdbc/rentcar");
			conn = source.getConnection();
			System.out.println("MySQL 연동 성공 ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MySQL 연동 실패  ");
		}

		return conn;
	}
	
	
	public static void close (Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close (Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
