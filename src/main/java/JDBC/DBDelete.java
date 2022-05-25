package JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class DBDelete {
    private static DBDelete dbDelete = null;
    private final DBConn dbConn = DBConn.getInstance();

    public DBDelete(){
    }

    public static DBDelete getInstance(){
        if(dbDelete == null)
            dbDelete = new DBDelete();
        return dbDelete;
    }

    public void delete(String clasa, String condition){
        if(dbConn.getConnection()!=null){
            try {
                Statement statement = dbConn.getConnection().createStatement();
                statement.execute("DELETE FROM " + clasa + " WHERE Brand=" + condition);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
