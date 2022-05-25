package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {

    private static DBConn dbConn = null;
    private Connection conn = null;

    private DBConn(){
    }

    public static DBConn getInstance(){
        if(dbConn == null)
            dbConn = new DBConn();
        return dbConn;
    }

    public void startConnection() throws SQLException, ClassNotFoundException {
        if(conn == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/eap-watchshop";
            String user = "root";
            String pass = "root";

            conn = DriverManager.getConnection(url, user, pass);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
