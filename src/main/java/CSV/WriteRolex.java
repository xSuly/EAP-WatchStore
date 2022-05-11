package CSV;

import models.Rolex;
import persistence.RolexRepository;
import service.RolexService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeSet;


public class WriteRolex {
    private static final WriteRolex wr_csv = null;

    private WriteRolex() {
    }

    public static WriteRolex getInstance() {
        return wr_csv;
    }

    private static void watchesWR(RolexService service) throws IOException {
        RolexRepository rolexRepository = new RolexRepository();
        try (PrintWriter writer = new PrintWriter("src/main/java/CSV/RolexWrite.csv")) {
            TreeSet<Rolex> list = service.getRolexes();
            String header = "model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap";
            writer.println(header);

            for (Rolex rolex : list) {
                writer.println(rolex.toString());
            }
        }

    }

    public static void writeToFiles(RolexService rolexService) {
        try {
            AuditLog.log("Uploading Rolex watches...");
            watchesWR(rolexService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
