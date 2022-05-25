package JDBC;

import CSV.AuditLog;
import exceptions.InvalidDataException;
import models.Rolex;
import models.Smartwatch;
import models.User;
import models.Watch;
import service.RolexService;
import service.SmartwatchService;
import service.UserService;
import service.WatchService;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBRead {

    private static DBRead dbRead = null;

    private DBRead(){
    }

    public static DBRead getInstance(){
        if(dbRead == null)
            dbRead = new DBRead();
        return dbRead;
    }

    private void loadWatches(WatchService watchService, Statement statement) {
        try{
            ResultSet resultSet = statement.executeQuery("SELECT * from Watch");
            while (resultSet.next()){
                watchService.addWatch(new Watch(resultSet.getString("brand"),
                        resultSet.getString("model"), resultSet.getDouble("price"),
                        resultSet.getInt("fabrication_date"), resultSet.getBoolean("smartwatch"),
                        resultSet.getBoolean("water_resistant"), resultSet.getString("mechanism"),
                        resultSet.getString("strap")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadRolexWatches(RolexService rolexService, Statement statement){
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * from Rolex");
            while (resultSet.next()){
                rolexService.addRolex(new Rolex(
                        resultSet.getString("model"), resultSet.getDouble("price"),
                        resultSet.getInt("fabrication_date"), resultSet.getBoolean("smartwatch"),
                        resultSet.getBoolean("water_resistant"), resultSet.getString("mechanism"),
                        resultSet.getString("strap")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadSmartwatches(SmartwatchService smartwatchService, Statement statement) {
        try{
            ResultSet resultSet = statement.executeQuery("SELECT * from Smartwatch");
            while (resultSet.next()){
                smartwatchService.registerNewSmartwatch(new Smartwatch(resultSet.getString("brand"),
                        resultSet.getString("model"), resultSet.getDouble("price"),
                        resultSet.getInt("fabrication_date"), resultSet.getBoolean("smartwatch"),
                        resultSet.getBoolean("water_resistant"), resultSet.getString("mechanism"),
                        resultSet.getString("strap"), resultSet.getDouble("display"),
                        resultSet.getDouble("RAM_Memory"), resultSet.getString("resolution"),
                        resultSet.getDouble("processor_freq"), resultSet.getInt("battery_capacity"),
                        resultSet.getInt("storage_memory"), resultSet.getBoolean("sim"),
                        resultSet.getBoolean("gps"), resultSet.getBoolean("bluetooth")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadUsers(UserService userService, Statement statement){
        try{
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            while(resultSet.next()){
                userService.registerNewUser(new User(resultSet.getString("username"),
                        resultSet.getString("password"),resultSet.getString("email"),
                        resultSet.getInt("age"),resultSet.getString("adress"),
                        resultSet.getString("city"),resultSet.getString("country")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadingObjects(WatchService watchService, RolexService rolexService, SmartwatchService smartwatchService, UserService userService) throws IOException {
        try {
            AuditLog.log("Loading objects from database ... (please wait)");

            DBConn dbConn = DBConn.getInstance();
            Statement statement = dbConn.getConnection().createStatement();

            loadWatches(watchService, statement);
            loadRolexWatches(rolexService, statement);
            loadSmartwatches(smartwatchService, statement);
            loadUsers(userService, statement);

            AuditLog.log("Loading completed!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    }

