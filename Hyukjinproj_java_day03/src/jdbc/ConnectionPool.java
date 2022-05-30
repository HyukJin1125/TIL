package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;


public class ConnectionPool {

	private static Vector<Connection> pool = new Vector<>();
	private static ConnectionPool instance = new ConnectionPool();
	
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	private ConnectionPool() {
		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void initPool() throws SQLException {
		destroyPool();
		ConnectionFactory factory = ConnectionFactory.getInstance();
		int maxConn = factory.getMaxConn();
		
		for(int i = 0; i < maxConn; i++) {
			pool.add(factory.getConnection());
		}
	}
	
	private synchronized void destroyPool() throws SQLException {
		// Connection 객체 다 닫아주기
		for(int i = 0; i < pool.size(); i++) {
			pool.get(i).close();
		}
		// pool 비우기
		pool.clear();
	}
	
	public synchronized Connection getConnection() {
		if(pool.size() == 0) {
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
