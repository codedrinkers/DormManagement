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
	 * ���������Ĺ��췽����ʹ�ô˷�������Ҫ��֮��ִ��setLoginInfo�������ݵ�½���ݿ���Ϣ
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
	 * ������Connector�ഫ�����ݿ��ַ����½��Ϣ��
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
		// List<Map<String, Object>> list = conn.commonQuery("*", "STUDENT");
		// Student student = Student.mapToStudent(list.get(1));
		conn.query("*", "ADMINISTRATER");
	}
	
	
	
	/**
	 * ͨ�����ӷ���,����һ��List<Map>��Map�д�ŵ���������ֵ��
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
	 * ͨ�����ӷ���,����һ��List<Map>��Map�д�ŵ���������ֵ��
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
	 * @function �������ݿ�
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
	 * @function �ر����ݿ�����
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
