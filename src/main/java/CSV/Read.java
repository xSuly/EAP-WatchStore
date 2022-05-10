package CSV;

import models.Rolex;
import service.RolexService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Read {

    private static final Read rw_csv = null;

    private Read() {
    }

    public static Read getInstance() {
        return rw_csv;
    }

    private static void watchesR(RolexService service) throws IOException {
        File file = new File("src/main/java/CSV/ceasurile.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String[] tempArray = null;
        line = br.readLine();
        line = null;
        while((line = br.readLine()) != null) {
            tempArray = line.split(",");
            service.addRolex(new Rolex(tempArray[0], Double.parseDouble(tempArray[1].trim()), Integer.parseInt(tempArray[2].trim()),
                    Boolean.parseBoolean(tempArray[3].trim()),Boolean.parseBoolean(tempArray[4].trim()), tempArray[5].trim(), tempArray[6].trim()));
        }
        br.close();
    }

    public static void loadClasses(RolexService rolexService) {
        try {
            watchesR(rolexService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
