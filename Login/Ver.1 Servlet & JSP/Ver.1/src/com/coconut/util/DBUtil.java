package com.coconut.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static DBUtil util = new DBUtil();
	
	public static DBUtil getUtil(){
		return util;
	}
	
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/coconut?serverTimezone=UTC";
	private final String user = "ssafy";
	private final String pass = "ssafy";
	
	private DBUtil() {
		try {
			Class.forName(driver);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pass);
	}
	
	public void close(AutoCloseable ...closeables) {
		for(AutoCloseable closeable : closeables) {
			if(closeable != null) {
				try {
					closeable.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
