package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Fix;
import model.Management;
import model.Student;

public class Connector {
	public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String dbURL;
	private String userName;
	private String userPwd;
	private String database;
	private Connection conn = null;
	private ResultSet result = null;
	private Statement stmt = null;

	/**
	 * 不带参数的构造方法，使用此方法必须要在之后执行setLoginInfo方法传递登陆数据库信息
	 * 
	 */
	public Connector() {
		try {
			Class.forName(this.driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 */
	public Connector(String dbURL, String userName, String userPwd, String database) {

		this.dbURL = dbURL;
		this.userName = userName;
		this.userPwd = userPwd;
		this.database = database;

		try {
			Class.forName(this.driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用来向Connector类传递数据库地址、登陆信息等
	 * 
	 */
	public void setLoginInfo(String dbURL, String userName, String userPwd, String database) {

		this.dbURL = dbURL;
		this.userName = userName;
		this.userPwd = userPwd;
		this.database = database;

	}

	/**
	 * 通用连接方法,返回一个List<Map>，Map中存放的是列名和值。
	 * 
	 */
	public List<Map> commonQuery(String column, String table) {
		List nameList = new ArrayList<String>();
		List<Map> list = new ArrayList<>();
		connect();
		try {
			result = stmt.executeQuery("select " + column + " from " + table + ";");
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsmd.getColumnName(i);
				nameList.add(columnName);
			}
			while (result.next()) {
				Map map = new HashMap();
				for (int i = 1; i <= nameList.size(); i++) {
					Object temp = result.getObject(i);
					map.put(nameList.get(i - 1), temp);
				}
				list.add(map);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return list;
	}

	/**
	 * 通用连接方法,返回一个List<Map>，Map中存放的是列名和值。
	 * 
	 */
	public List commonQuery(String column, String table, String where) {
		List nameList = new ArrayList<String>();
		List list = new ArrayList<>();
		connect();
		try {
			result = stmt.executeQuery("select " + column + " from " + table + " where " + where + ";");
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = rsmd.getColumnName(i);
				nameList.add(columnName);
			}
			while (result.next()) {
				Map map = new HashMap();
				for (int i = 1; i <= nameList.size(); i++) {
					Object temp = result.getObject(i);
					map.put(nameList.get(i - 1), temp);
				}
				list.add(map);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return list;
	}
	
	public void executeSql(String sql){
		connect();
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	

	

	/**
	 * @function 连接数据库
	 * 
	 */
	private void connect() {
		try {
			this.conn = DriverManager.getConnection(dbURL + database, userName, userPwd);
			this.stmt = conn.createStatement();
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
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Connector conn = new Connector("jdbc:sqlserver://localhost:1433;DatabaseName=", "sa", "", "DormManagemrnt");
		List<Map> list = conn.commonQuery("*", "MANAGEMENT");
		Management management=Management.getInstance(list.get(2));
		System.out.println(management);
	}
}
