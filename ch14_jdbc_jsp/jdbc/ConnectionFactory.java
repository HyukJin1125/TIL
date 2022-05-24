package ch14_jdbc_jsp.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionFactory {
	private String driver;
	private String url;
	private String id;
	private String pw;
	private int maxConn;

	private ConnectionFactory() {
		// SINGLETON PATTERN
		Properties prop = new Properties();
		InputStream config = getClass().getClassLoader().getResourceAsStream("config/db.properties");
		try {
			prop.load(config);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			id = prop.getProperty("id");
			pw = prop.getProperty("pw");
			maxConn = Integer.parseInt(prop.getProperty("maxConn"));
			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, id, pw);
		return conn;
	}

	private static ConnectionFactory instance = new ConnectionFactory();

	public static ConnectionFactory getInstance() {
		return instance;
	}

	public int getMaxConn() {
		return maxConn;
	}

}
