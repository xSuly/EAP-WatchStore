package classes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Watch watch1 = new Watch("Fossil", "Townsman", 935.50, 2018, false, true, "Mechanic", "Chain");
        Rolex rolex1 = new Rolex("Daytona", 4500, 2015, false, true, "Quartz", "Leather");

        List<Watch> watchList = new LinkedList<>();
        watchList.add(watch1);
        watchList.add(rolex1);
        System.out.println(watchList);

        User u1 = new User("xSuly", "parolaGrea", "xsuly2001@gmail.com", 20, "B-dul 1 Dec. 1918", "Ramnicu Sarat", "Romania");
        User u2 = new User("BogdanelSuperMario", "Luigiisbetter", "bogdanelmario@yahoo.ro", 15, "B-dul Iuliu Maniu", "Bucuresti", "Romania");

        List<User> userList = new LinkedList<>();
        userList.add(u1);
        userList.add(u2);


        Order o1 = new Order();
        u1.addWatchUser(o1, watch1);
        Order o2 = new Order();
        u2.addWatchUser(o2, rolex1);

        System.out.println(userList);

        Atlantic atlantic1 = new Atlantic("Seabase", 1147, 2020, false, true, "Analog", "Chain", true);
        Watch watch2 = new Watch("Breitling", "Superocean", 25500, 2010, false, true, "Analog", "Leather");
        watchList.add(atlantic1);
        watchList.add(watch2);
        GShock gShock1 = new GShock("G-Steel", 1587, 2019, false, true, "Quartz", "Leather");
        watchList.add(gShock1);
        Collections.sort((List<Watch>) watchList);
        System.out.println(watchList);

        Smartwatch smartwatch1 = new Smartwatch("Samsung", "Galaxy Watch Classic4", 1099.99, 2019, true, true, "Digital", "Silicone", 1.36, 1.5, "450x450", 1.18, 361, 16, false, true, true);
        System.out.println(smartwatch1);
    }
}
