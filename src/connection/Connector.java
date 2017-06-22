package connection;

import java.lang.reflect.InvocationTargetException;
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

import model.Administrater;
import model.Fix;
import model.Management;
import model.Model;
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

	public List<Model> query(String column, String table) {
		List<Map<String, Object>> temp = commonQuery(column, table);
		List<Model> list = new ArrayList<Model>();
		Model model;
		switch (table) {
		case "ADMINISTRATER":
			for (Map map : temp) {
				model = new Administrater(map);
				list.add(model);
			}
			break;
		case "FIX":
			for (Map map : temp) {
				model = new Fix(map);
				list.add(model);
			}
			break;
		case "MANAGEMENT":
			for (Map map : temp) {
				model = new Management(map);
				list.add(model);
			}
			break;
		case "STUDENT":
			for (Map map : temp) {
				model = new Student(map);
				list.add(model);
			}
			break;

		}
		return list;

	}

	public List<Model> query(String column, String table, String where) {
		List<Map<String, Object>> temp = commonQuery(column, table, where);
		List<Model> list = new ArrayList<Model>();
		Model model;
		switch (table) {
		case "ADMINISTRATER":
			for (Map map : temp) {
				model = new Administrater(map);
				list.add(model);
			}
			break;
		case "FIX":
			for (Map map : temp) {
				model = new Fix(map);
				list.add(model);
			}
			break;
		case "MANAGEMENT":
			for (Map map : temp) {
				model = new Management(map);
				list.add(model);
			}
			break;
		case "STUDENT":
			for (Map map : temp) {
				model = new Student(map);
				list.add(model);
			}
			break;

		}
		return list;

	}

	public void delete(String table, String where) {
		connect();
		try {
			stmt.execute("delete from " + table + " where " + where);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	public void update() {

	}

	public void insert(String table, Map<String, Object> map) {
		connect();
		String keys = "";
		String values = "";
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			keys+=entry.getKey();
			keys+=",";
			values+="'";
			values+=entry.getValue();
			values+="',";
		}
		
		System.out.println(keys);
		keys=keys.replaceAll(",$","");
		values=values.replaceAll(",$","");
		
		System.out.println(keys);
		System.out.println(values);
		System.out.println("insert into " + table + "("+keys+") values " + "(" +values+ ");");
		try {
			stmt.execute("insert into " + table + "("+keys+") values " + "(" +values+ ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	public void executeSql(String sql) {
		connect();
		try {
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	public static void main(String[] args) {
		Connector conn = new Connector("jdbc:sqlserver://localhost:1433;DatabaseName=", "sa", "", "DormManagemrnt");
		Map map=new HashMap<>();
		map.put("EMPNO", "20170000001");
		map.put("SNO", "20151303001");
		conn.insert("Management", map);
	}

	/**
	 * 通用连接方法,返回一个List<Map>，Map中存放的是列名和值。
	 * 
	 */
	private List<Map<String, Object>> commonQuery(String column, String table) {
		List<String> nameList = new ArrayList<String>();
		List<Map<String, Object>> list = new ArrayList<>();
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
				Map<String, Object> map = new HashMap<String, Object>();
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
	private List<Map<String, Object>> commonQuery(String column, String table, String where) {
		List<String> nameList = new ArrayList<String>();
		List<Map<String, Object>> list = new ArrayList<>();
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
				Map<String, Object> map = new HashMap<String, Object>();
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
}
