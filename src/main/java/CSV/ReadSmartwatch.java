package CSV;

import exceptions.InvalidDataException;

import models.Smartwatch;

import service.SmartwatchService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadSmartwatch {

    private static final ReadSmartwatch rw_csv = null;

    private ReadSmartwatch() {
    }

    public static ReadSmartwatch getInstance() {
        return rw_csv;
    }

    private static void SmartwatchR(SmartwatchService service) throws IOException, InvalidDataException {
        File file = new File("src/main/java/CSV/SmartwatchText.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String[] tempArray = null;
        line = br.readLine();
        line = null;
        while((line = br.readLine()) != null) {
            tempArray = line.split(",");
            service.registerNewSmartwatch(new Smartwatch(tempArray[0].trim(), tempArray[1].trim(), Double.parseDouble(tempArray[2].trim()),
                    Integer.parseInt(tempArray[3].trim()), Boolean.parseBoolean(tempArray[4].trim()), Boolean.parseBoolean(tempArray[5].trim()),
                    tempArray[6].trim(), tempArray[7].trim(), Double.parseDouble(tempArray[8].trim()), Double.parseDouble(tempArray[9].trim()), tempArray[10],
                    Double.parseDouble(tempArray[11].trim()), Integer.parseInt(tempArray[12].trim()), Integer.parseInt(tempArray[13].trim()),
                    Boolean.parseBoolean(tempArray[14].trim()), Boolean.parseBoolean(tempArray[15].trim()), Boolean.parseBoolean(tempArray[16].trim())));

        }
        br.close();
    }

    public static void loadClasses(SmartwatchService smartwatchService) {
        try {
            AuditLog.log("Loading Smartwatches...");
            SmartwatchR(smartwatchService);
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InvalidDataException e) {
            throw new RuntimeException(e);
        }
    }
}
