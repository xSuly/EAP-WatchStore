package JDBC;

import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdate {

    private static DBUpdate dbUpdate = null;
    private final DBConn dbConn = DBConn.getInstance();

    private DBUpdate(){
    }

    public static DBUpdate getInstance(){
        if(dbUpdate == null)
            dbUpdate = new DBUpdate();
        return dbUpdate;
    }

    public void update(String clasa, String sett, String valoare, String condition){
        if(dbConn.getConnection()!=null){
            try{
                Statement statement = dbConn.getConnection().createStatement();
                statement.execute("UPDATE " + clasa + " SET " + sett + " = " + valoare + " WHERE Brand=" + condition);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
