package CSV;

import models.Rolex;
import service.RolexService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadRolex {

    private static ReadRolex rw_csv = null;

    private ReadRolex() {
    }

    public static ReadRolex getInstance() {
        if(rw_csv == null)
            rw_csv = new ReadRolex();
        return rw_csv;
    }

    private static void watchesR(RolexService service) throws IOException {
        File file = new File("src/main/java/CSV/RolexText.csv");
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
            AuditLog.log("Loading Rolex watches...");
            watchesR(rolexService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
