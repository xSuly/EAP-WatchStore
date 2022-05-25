package JDBC;

import models.Rolex;
import models.Smartwatch;
import models.User;
import models.Watch;

import java.sql.SQLException;
import java.sql.Statement;

public class DBWrite {

    private static DBWrite dbWrite = null;
    private final DBConn dbConn = DBConn.getInstance();
    private Statement statement = null;

    private DBWrite(){
    }

    public static DBWrite getInstance(){
        if(dbWrite == null)
            dbWrite = new DBWrite();
        return dbWrite;
    }

    public void watches(Watch watch){
        if(dbConn.getConnection()!=null){
            try{
                statement = dbConn.getConnection().createStatement();
                statement.execute("INSERT INTO Watches VALUES(" + watch.getBrand() + watch.getBrand()
                + watch.getPrice() + watch.getFabrication_date() + watch.isSmartwatch() + watch.isWater_resistant() +
                        watch.getMechanism() + watch.getStrap());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void rolexes(Rolex rolex){
        if(dbConn.getConnection()!=null){
            try{
                statement = dbConn.getConnection().createStatement();
                statement.execute("INSERT INTO Rolexes VALUES(" + rolex.getModel() + rolex.getPrice() +
                        rolex.getFabrication_date() + rolex.isSmartwatch() + rolex.isWater_resistant() +
                        rolex.getMechanism() + rolex.getStrap());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void smartwatches(Smartwatch smartwatch){
        if(dbConn.getConnection()!=null){
            try{
                statement = dbConn.getConnection().createStatement();
                statement.execute("INSERT INTO Smartwatches VALUES(" + smartwatch.getBrand() + smartwatch.getModel()+
                        smartwatch.getPrice() + smartwatch.getFabrication_date() + smartwatch.isSmartwatch()+
                        smartwatch.isWater_resistant() + smartwatch.getMechanism() + smartwatch.getStrap()+
                        smartwatch.getDisplay() + smartwatch.getResolution() + smartwatch.getProcessor_freq()+
                        smartwatch.getBattery_capacity() + smartwatch.getStorage_memory() + smartwatch.isSim() +
                        smartwatch.isGps() + smartwatch.isBluetooth());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void users(User user){
        if(dbConn.getConnection()!=null){
            try {
                statement = dbConn.getConnection().createStatement();
                statement.execute("INSERT INTO Users VALUES(" + user.getUsername() +
                        user.getPassword() + user.getEmail() + user.getAdress() + user.getCity() + user.getCountry());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
