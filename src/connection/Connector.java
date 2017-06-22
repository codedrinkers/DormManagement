package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connector {
	public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=";
	public static final String userName = "sa";
	public static final String userPwd = "";
	public static final String database = "DormManagement";
	private Connection conn = null;
	private ResultSet result = null;
	private PreparedStatement sql = null;

	public Connector() {
		try {
			Class.forName(this.driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	

	

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}

	public PreparedStatement getSql() {
		return sql;
	}

	public void setSql(PreparedStatement sql) {
		this.sql = sql;
	}
	
	/**
	 * @function 连接数据库
	 * 
	 */
	private void connect() {
		try {
			this.conn = DriverManager.getConnection(dbURL + database, userName, userPwd);
			System.out.println("Coneection complished!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @function 关闭数据库连接
	 */
	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		Connector conn = new Connector();
		conn.connect();
	}
}
