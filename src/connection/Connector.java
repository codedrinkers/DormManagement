package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Connector {
	public static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static final String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=";
	public static final String userName = "sa";
	public static final String userPwd = "";
	public static final String database = "test";
	private Connection conn = null;
	private ResultSet result = null;
	private Statement sql = null;

	public Connector() {
		try {
			Class.forName(this.driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List commonQuery(String column,String table){
		List nameList=new ArrayList<String>();
		List list=new ArrayList<>();
		connect();
		try {
			result=sql.executeQuery("select "+column+" from "+table+";");
			ResultSetMetaData rsmd=result.getMetaData();
			int columnCount=rsmd.getColumnCount();
			for(int i=1;i<=columnCount;i++){
				String columnName=rsmd.getColumnName(i);
				nameList.add(columnName);
			}
			while(result.next()){
				Map map=new HashMap();
				for(int i=1;i<=nameList.size();i++){
					Object temp=result.getObject(i);
					map.put(nameList.get(i-1), temp);
				}
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
		return list;
		
	}
	
	
	

	

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}
	
	public Statement getSql() {
		return sql;
	}

	public void setSql(Statement sql) {
		this.sql = sql;
	}
	
	/**
	 * @function 连接数据库
	 * 
	 */
	private void connect() {
		try {
			this.conn = DriverManager.getConnection(dbURL + database, userName, userPwd);
			this.sql=conn.createStatement();
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
			sql.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		Connector conn = new Connector();
		conn.commonQuery("*", "one");
	}
}
