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

import model.Administrater;
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
     * @throws SQLException
     * 
     */
    public List<Map<String, Object>> commonQuery(String column, String table) throws SQLException {
        List<String> nameList = new ArrayList<String>();
        List<Map<String, Object>> list = new ArrayList<>();
        connect();

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

        closeConnection();
        return list;
    }

    /**
     * 通用连接方法,返回一个List<Map>，Map中存放的是列名和值。
     * 
     * @throws SQLException
     * 
     */
    public List<Map<String, Object>> commonQuery(String column, String table, String where) throws SQLException {
        List<String> nameList = new ArrayList<String>();
        List<Map<String, Object>> list = new ArrayList<>();
        connect();

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

        closeConnection();
        return list;
    }

    /**
     * 
     * @param column
     * @param table
     * @return
     * @throws SQLException
     */
    public List query(String column, String table) throws SQLException {
        List<Map<String, Object>> temp = commonQuery(column, table);
        List list = new ArrayList();

        switch (table) {
        case "ADMINISTRATER":
            for (Map map : temp) {
                Administrater admin = new Administrater(map);
                list.add(admin);
            }
            break;
        case "FIX":
            for (Map map : temp) {
                Fix fix = new Fix(map);
                list.add(fix);
            }
            break;
        case "MANAGEMENT":
            for (Map map : temp) {
                Management management = new Management(map);
                list.add(management);
            }
            break;
        case "STUDENT":
            for (Map map : temp) {
                Student student = new Student(map);
                list.add(student);
            }
            break;

        }
        return list;

    }

    /**
     * 
     * @param column
     * @param table
     * @param where
     * @return
     * @throws SQLException
     */
    public List query(String column, String table, String where) throws SQLException {
        List<Map<String, Object>> temp = commonQuery(column, table, where);
        List list = new ArrayList();
        switch (table) {
        case "ADMINISTRATER":
            for (Map map : temp) {
                Administrater admin = new Administrater(map);
                list.add(admin);
            }
            break;
        case "FIX":
            for (Map map : temp) {
                Fix fix = new Fix(map);
                list.add(fix);
            }
            break;
        case "MANAGEMENT":
            for (Map map : temp) {
                Management management = new Management(map);
                list.add(management);
            }
            break;
        case "STUDENT":
            for (Map map : temp) {
                Student student = new Student(map);
                list.add(student);
            }
            break;

        }
        return list;

    }

    /**
     * 
     * @param table
     * @param where
     */
    public void delete(String table, String where) {
        connect();
        try {
            stmt.execute("delete from " + table + " where " + where);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    /**
     * 
     * @param table
     * @param map
     */
    public void insert(String table, Map<String, Object> map) {
        connect();
        String keys = "";
        String values = "";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            keys += entry.getKey();
            keys += ",";
            values += "'";
            values += entry.getValue();
            values += "',";
        }

        System.out.println(keys);
        keys = keys.replaceAll(",$", "");
        values = values.replaceAll(",$", "");

        System.out.println(keys);
        System.out.println(values);
        System.out.println("insert into " + table + "(" + keys + ") values " + "(" + values + ");");
        try {
            stmt.execute("insert into " + table + "(" + keys + ") values " + "(" + values + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }

    /**
     * 
     * @param admin
     */
    public void insert(Administrater admin) {

        String keys = "";
        String values = "";
        String sql;

        if (admin.getEMPID() != null) {
            keys += "EMPID,";
            values += "'" + admin.getEMPID() + "',";
        }
        if (admin.getEMPJOB() != null) {
            keys += "EMPJOB,";
            values += "'" + admin.getEMPJOB() + "',";
        }
        if (admin.getEMPNAME() != null) {
            keys += "EMPNAME,";
            values += "'" + admin.getEMPNAME() + "',";
        }
        if (admin.getEMPNO() != null) {
            keys += "EMPNO,";
            values += "'" + admin.getEMPNO() + "',";
        }
        if (admin.getEMPPASWD() != null) {
            keys += "EMPPASWD,";
            values += "'" + admin.getEMPPASWD() + "',";
        }
        if (admin.getEMPPHONE() != null) {
            keys += "EMPPHONE,";
            values += "'" + admin.getEMPPHONE() + "',";
        }
        if (admin.getEMPSEX() != null) {
            keys += "EMPSEX,";
            values += "'" + admin.getEMPSEX() + "',";
        }

        System.out.println(keys);
        keys = keys.replaceAll(",$", "");
        values = values.replaceAll(",$", "");

        sql = "insert into ADMINISTRATER(" + keys + ") values " + "(" + values + ");";
        executeSql(sql);

    }

    /**
     * 
     * @param student
     */
    public void insert(Student student) {

        String keys = "";
        String values = "";
        String sql;

        if (student.getSBNO() != null) {
            keys += "SBNO,";
            values += "'" + student.getSBNO() + "',";
        }
        if (student.getSCLASS() != null) {
            keys += "SCLASS,";
            values += "'" + student.getSCLASS() + "',";
        }
        if (student.getSDNO() != null) {
            keys += "SDNO,";
            values += "'" + student.getSDNO() + "',";
        }
        if (student.getSGRADE() != null) {
            keys += "SGRADE,";
            values += "'" + student.getSGRADE() + "',";
        }
        if (student.getSMAJOR() != null) {
            keys += "SMAJOR,";
            values += "'" + student.getSMAJOR() + "',";
        }
        if (student.getSNAME() != null) {
            keys += "SNAME,";
            values += "'" + student.getSNAME() + "',";
        }
        if (student.getSNO() != null) {
            keys += "SNO,";
            values += "'" + student.getSNO() + "',";
        }
        if (student.getSSEX() != null) {
            keys += "SSEX,";
            values += "'" + student.getSSEX() + "',";
        }

        keys = keys.replaceAll(",$", "");
        values = values.replaceAll(",$", "");

        sql = "insert into STUDENT(" + keys + ") values " + "(" + values + ");";
        executeSql(sql);

    }

    /**
     * 
     * @param fix
     */
    public void insert(Fix fix) {

        String keys = "";
        String values = "";
        String sql;

        if (fix.getEMPNO() != null) {
            keys += "EMPNO,";
            values += "'" + fix.getEMPNO() + "',";
        }
        if (fix.getFDATE() != null) {
            keys += "FDATE,";
            values += "'" + fix + "',";
        }
        if (fix.getFNAME() != null) {
            keys += "FNAME,";
            values += "'" + fix.getFNAME() + "',";
        }
        if (fix.getSNO() != null) {
            keys += "SNO,";
            values += "'" + fix.getSNO() + "',";
        }

        keys = keys.replaceAll(",$", "");
        values = values.replaceAll(",$", "");

        sql = "insert into FIX(" + keys + ") values " + "(" + values + ");";
        executeSql(sql);

    }
    /**
     * 
     * @param management
     */
    public void insert(Management management) {

        String keys = "";
        String values = "";
        String sql;

        if (management.getEMPNO() != null) {
            keys += "EMPNO,";
            values += "'" + management.getEMPNO() + "',";
        }
        if (management.getSNO() != null) {
            keys += "SNO,";
            values += "'" + management.getSNO() + "',";
        }

        keys = keys.replaceAll(",$", "");
        values = values.replaceAll(",$", "");

        sql = "insert into MANAGEMENT(" + keys + ") values " + "(" + values + ");";
        executeSql(sql);

    }

    /**
     * 
     * @param admin
     * @param where
     */
    public void update(Administrater admin, String where) {
        String expression = "";
        String sql;
        if (admin.getEMPID() != null) {
            expression += " " + "EMPID" + "=" + admin.getEMPID() + ",";
        }
        if (admin.getEMPJOB() != null) {
            expression += " " + "EMPJOB" + "=" + admin.getEMPJOB() + ",";
        }
        if (admin.getEMPNAME() != null) {
            expression += " " + "EMPNAME" + "=" + admin.getEMPNAME() + ",";
        }
        if (admin.getEMPNO() != null) {
            expression += " " + "EMPNO" + "=" + admin.getEMPNO() + ",";
        }
        if (admin.getEMPPASWD() != null) {
            expression += " " + "EMPPASWD" + "=" + admin.getEMPPASWD() + ",";
        }
        if (admin.getEMPPHONE() != null) {
            expression += " " + "EMPPHONE" + "=" + admin.getEMPPHONE() + ",";
        }
        if (admin.getEMPSEX() != null) {
            expression += " " + "EMPSEX" + "=" + admin.getEMPSEX() + ",";
        }

        expression = expression.replaceAll(",$", " ");
        sql = "update ADMINISTRATER set " + expression + " where " + where + ";";
        executeSql(sql);
    }

    /**
     * 
     * @param management
     * @param where
     */
    public void update(Management management, String where) {
        String expression = "";
        String sql;
        if (management.getEMPNO() != null) {
            expression += " " + "EMPNO" + "=" + management.getEMPNO() + ",";
        }
        if (management.getSNO() != null) {
            expression += " " + "SNO" + "=" + management.getSNO() + ",";
        }
        expression = expression.replaceAll(",$", " ");
        sql = "update MANAGEMENT set " + expression + " where " + where + ";";
        executeSql(sql);
    }

    /**
     * 
     * @param fix
     * @param where
     */
    public void update(Fix fix, String where) {
        String expression = "";
        String sql;
        if (fix.getEMPNO() != null) {
            expression += " " + "EMPNO" + "=" + fix.getEMPNO() + ",";
        }
        if (fix.getFDATE() != null) {
            expression += " " + "FDATE" + "=" + fix.getFDATE() + ",";
        }
        if (fix.getFNAME() != null) {
            expression += " " + "FNAME" + "=" + fix.getFNAME() + ",";
        }
        if (fix.getSNO() != null) {
            expression += " " + "SNO" + "=" + fix.getSNO() + ",";
        }
        expression = expression.replaceAll(",$", " ");
        sql = "update FIX set " + expression + " where " + where + ";";
        executeSql(sql);
    }

    /**
     * 
     * @param student
     * @param where
     */
    public void update(Student student, String where) {
        String expression = "";
        String sql;
        if (student.getSBNO() != null) {
            expression += " " + "SBNO" + "=" + student.getSBNO() + ",";
        }
        if (student.getSCLASS() != null) {
            expression += " " + "SCLASS" + "=" + student.getSCLASS() + ",";
        }
        if (student.getSDNO() != null) {
            expression += " " + "SDNO" + "=" + student.getSDNO() + ",";
        }
        if (student.getSGRADE() != null) {
            expression += " " + "SGRADE" + "=" + student.getSGRADE() + ",";
        }
        if (student.getSMAJOR() != null) {
            expression += " " + "SMAJOR" + "=" + student.getSMAJOR() + ",";
        }
        if (student.getSNAME() != null) {
            expression += " " + "SNAME" + "=" + student.getSNAME() + ",";
        }
        if (student.getSNO() != null) {
            expression += " " + "SNO" + "=" + student.getSNO() + ",";
        }
        if (student.getSSEX() != null) {
            expression += " " + "SSEX" + "=" + student.getSSEX() + ",";
        }

        expression = expression.replaceAll(",$", " ");
        sql = "update STUDENT set " + expression + " where " + where + ";";
        executeSql(sql);

    }

    /**
     * 通过map来update表
     * 
     * @param table
     * @param map
     */
    public void update(String table, Map<String, String> map, String where) {
        String expression = "";
        String sql;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            expression += " " + entry.getKey() + "=" + entry.getValue() + ",";

        }
        expression = expression.replaceAll(",$", " ");
        sql = "update " + table + " set " + expression + " where " + where + ";";
        executeSql(sql);
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
        try {
            List tmp = conn.query("*", "STUDENT");
            Student student = (Student) tmp.get(1);
            conn.insert(student);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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
