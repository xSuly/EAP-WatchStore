package CSV;

import models.Smartwatch;
import models.User;
import persistence.SmartwatchRepository;
import persistence.UserRepository;
import service.SmartwatchService;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteUser {

    private static final WriteUser wr_csv = null;

    private WriteUser() {
    }

    public static WriteUser getInstance() {
        return wr_csv;
    }

    private static void UserWR(UserService service) throws IOException {
        UserRepository userRepository = new UserRepository();
        try (PrintWriter writer = new PrintWriter("src/main/java/CSV/UserWrite.csv")) {
            List<User> list = service.getUsers();
            String header = "username, password, email, age, address, city, country";
            writer.println(header);

            for (User user : list) {
                writer.println(user.toString());
            }
        }

    }

    public static void writeToFiles(UserService userService) {
        try {
            AuditLog.log("Uploading Users...");
            UserWR(userService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
