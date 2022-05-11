package CSV;

import exceptions.InvalidDataException;
import models.User;
import service.UserService;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadUser {

    private static final ReadUser rw_csv = null;

    private ReadUser() {
    }

    public static ReadUser getInstance() {
        return rw_csv;
    }

    private static void userR(UserService service) throws IOException, InvalidDataException {
        File file = new File("src/main/java/CSV/UserText.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String[] tempArray = null;
        line = br.readLine();
        line = null;
        while((line = br.readLine()) != null) {
            tempArray = line.split(",");
            User ReadU = new User(tempArray[0], tempArray[1].trim(),
                    tempArray[2].trim(), Integer.parseInt(tempArray[3].trim()),
                    tempArray[4].trim(), tempArray[5].trim(), tempArray[6].trim());
            service.registerNewUser(ReadU);

        }
        br.close();
    }

    public static void loadClasses(UserService userService) {
        try {
            //AuditLog.log("Loading users...");
            userR(userService);
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }

}
