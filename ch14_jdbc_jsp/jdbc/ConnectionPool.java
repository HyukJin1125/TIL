package ch14_jdbc_jsp.jdbc;

import java.sql.*;
import java.util.*;

public class ConnectionPool {
	private static Vector<Connection> pool = new Vector<>();
	private static ConnectionPool instance = new ConnectionPool();

	private ConnectionPool() {
		// SINGLETON PATTERN
		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	private synchronized void initPool() throws SQLException {
		destroyPool();
		ConnectionFactory factory = ConnectionFactory.getInstance();
		int maxConn = factory.getMaxConn();
		for (int i = 0; i < maxConn; i++) {
			pool.add(factory.getConnection());
		}
	}

	private synchronized void destroyPool() throws SQLException {
		for (int i = 0; i < pool.size(); i++) {
			pool.get(i).close();
		}
		pool.clear();
	}

	public synchronized Connection getConnection() {
		if (pool.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection conn = pool.get(0);
		pool.remove(0);
		return conn;
	}

	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}
}
