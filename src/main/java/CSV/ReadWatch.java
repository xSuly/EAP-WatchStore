package CSV;

import exceptions.InvalidDataException;
import models.Watch;
import service.WatchService;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadWatch {

    private static final ReadWatch rw_csv = null;

    private ReadWatch() {
    }

    public static ReadWatch getInstance() {
        return rw_csv;
    }

    private static void WatchR(WatchService service) throws IOException {
        File file = new File("src/main/java/CSV/WatchText.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String[] tempArray = null;
        line = br.readLine();
        line = null;
        while((line = br.readLine()) != null) {
            tempArray = line.split(",");
            service.addWatch(new Watch(tempArray[0].trim(), tempArray[1].trim(), Double.parseDouble(tempArray[2].trim()),
                    Integer.parseInt(tempArray[3].trim()), Boolean.parseBoolean(tempArray[4].trim()), Boolean.parseBoolean(tempArray[5].trim()),
                    tempArray[6].trim(), tempArray[7].trim()));
        }
        br.close();
    }

    public static void loadClasses(WatchService watchService) {
        try {
            AuditLog.log("Loading watches...");
            WatchR(watchService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
