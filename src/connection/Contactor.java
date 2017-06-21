package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Contactor {
    private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=";
    private String userName = "sa";
    private String userPwd = "";
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement sql = null;

    /**
     * @function 连接数据库
     * @param dataBaseName
     * @return Connection
     */
    public Connection connect(String dataBaseName) {
        try {
            Class.forName(this.driverName);
            this.conn = DriverManager.getConnection(this.dbURL + dataBaseName, this.userName, this.userPwd);
            System.out.println("Coneection complished!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return this.conn;
    }
  
    /**
     * @function 关闭数据库连接
     */
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getSql() {
        return sql;
    }

    public void setSql(PreparedStatement sql) {
        this.sql = sql;
    }

    public static void main(String[] args) {
    }
}
