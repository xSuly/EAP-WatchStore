package models;

import CSV.*;
import JDBC.DBConn;
import JDBC.DBRead;
import exceptions.InvalidDataException;
import persistence.UserRepository;
import service.RolexService;
import service.SmartwatchService;
import service.UserService;
import service.WatchService;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidDataException, IOException {

        Watch watch1 = new Watch("Fossil", "Townsman", 935.50, 2018,
                false, true, "Mechanic", "Chain");
        Rolex rolex1 = new Rolex("Daytona", 4500, 2015, false,
                true, "Quartz", "Leather");
        Rolex rolex2 = new Rolex("Oyster Perpetual", 25675, 2018, false,
                true, "Quartz", "Chain");
        System.out.println("-------------------test rolex service-------------------");
        RolexService rolexService = new RolexService();
        rolexService.addRolex(rolex1);
        rolexService.addRolex(rolex2);
        rolexService.getAllRolex();
        rolexService.removeByModel("Daytona");
        rolexService.getAllRolex();
        rolexService.addRolex(rolex1);
        rolexService.updateModelByModel("Daytona", "DaytonaNew2025");
        rolexService.getAllRolex();
        System.out.println("------------------------finish------------------\n");


        List<Watch> watchList = new LinkedList<>();
        watchList.add(watch1);
        watchList.add(rolex1);
        System.out.println(watchList);

        User u1 = new User("xSuly", "parolaGrea", "xsuly2001@gmail.com",
                20, "B-dul 1 Dec. 1918", "Ramnicu Sarat", "Romania");
        User u2 = new User("BogdanelSuperMario", "Luigiisbetter", "bogdanelmario@yahoo.ro",
                15, "B-dul Iuliu Maniu", "Bucuresti", "Romania");

        List<User> userList = new LinkedList<>();
        userList.add(u1);
        userList.add(u2);


        UserService userService = new UserService();
        userService.registerNewUser(u1);
        userService.registerNewUser(u2);
        userService.getAllUsers();
        userService.getUserApp("xSuly");

        UserRepository userRepository = new UserRepository();
        userRepository.update(u1);

        userService.getAllUsers();


        Order o1 = new Order();
        u1.addWatchUser(o1, watch1);
        Order o2 = new Order();
        u2.addWatchUser(o2, rolex1);

        System.out.println(userList);

       Atlantic atlantic1 = new Atlantic("Seabase", 1147, 2020, false,
                true, "Analog", "Chain", true);
        Watch watch2 = new Watch("Breitling", "Superocean", 25500, 2010,
                false, true, "Analog", "Leather");
        watchList.add(atlantic1);
        watchList.add(watch2);
        GShock gShock1 = new GShock("G-Steel", 1587, 2019, false,
                true, "Quartz", "Leather");
        watchList.add(gShock1);
        Collections.sort((List<Watch>) watchList);
        System.out.println(watchList);

        Smartwatch smartwatch1 = new Smartwatch("Samsung", "Galaxy Watch Classic4",
                1099.99, 2019, true, true,
                "Digital", "Silicone", 1.36, 1.5, "450x450",
                1.18, 361, 16, false, true, true);
        Smartwatch smartwatch2 = new Smartwatch("Apple", "Series 7", 2000,
                2022, true, true, "Digital",
                "Silicone", 1.40, 2, "475x480", 1.25,
                355, 32, true, true, true);
        SmartwatchService smartwatchService = new SmartwatchService();
        smartwatchService.registerNewSmartwatch(smartwatch1);
        smartwatchService.registerNewSmartwatch(smartwatch2);
        smartwatchService.getAllSmartwatch();

        System.out.println(smartwatch1);

        AuditLog.clearLog();
        AuditLog.log("Initializing system...");


        RolexService rolexService1 = new RolexService();
        ReadRolex loader = ReadRolex.getInstance();
        ReadRolex.loadClasses(rolexService1);
        rolexService1.getAllRolex();
        rolexService1.addRolex(rolex1);
        rolexService1.addRolex(rolex2);
        rolexService1.removeByModel("Oyster Perpetual");
        WriteRolex write = WriteRolex.getInstance();
        WriteRolex.writeToFiles(rolexService1);
        //rolex1.time_show();



        SmartwatchService smartwatchService1 = new SmartwatchService();
        ReadSmartwatch loader2 = ReadSmartwatch.getInstance();
        ReadSmartwatch.loadClasses(smartwatchService1);
        smartwatchService1.getAllSmartwatch();
        smartwatchService1.registerNewSmartwatch(smartwatch1);
        smartwatchService1.registerNewSmartwatch(smartwatch2);
        WriteSmartwatch write2 = WriteSmartwatch.getInstance();
        WriteSmartwatch.writeToFiles(smartwatchService1);



        UserService userService1 = new UserService();
        ReadUser loader3 = ReadUser.getInstance();
        ReadUser.loadClasses(userService1);
        userService1.getAllUsers();
        userService1.registerNewUser(u1);
        userService1.registerNewUser(u2);
        WriteUser write3 = WriteUser.getInstance();
        WriteUser.writeToFiles(userService1);

        WatchService watchService = new WatchService();
        ReadWatch loader4 = ReadWatch.getInstance();
        ReadWatch.loadClasses(watchService);
        watchService.getAllWatches();
        watchService.addWatch(watch1);
        watchService.addWatch(watch2);
        watchService.removeByModel("Townsman");
        WriteWatch write4 = WriteWatch.getInstance();
        WriteWatch.writeToFiles(watchService);

        AuditLog.log("System is closing...");
        AuditLog.getBw().close();


        // database check
        AuditLog.clearLog();
        AuditLog.log("Initializing system...");

        DBConn dbConn = DBConn.getInstance();
        DBRead dbRead = DBRead.getInstance();

        boolean dummy = true;
        try {
            dbConn.startConnection();
            dbRead.loadingObjects(watchService, rolexService, smartwatchService, userService);
        } catch (Exception e){
            AuditLog.log("Can't access database ...");
            dummy = false;
        }

        if(dummy) dbConn.closeConnection();
        AuditLog.log("System is closing...");
        AuditLog.getBw().close();


    }
}
