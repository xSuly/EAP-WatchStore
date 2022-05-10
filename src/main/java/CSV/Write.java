package CSV;

import models.Rolex;
import persistence.RolexRepository;
import service.RolexService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class Write {
    private static final Write wr_csv = null;

    private Write() {
    }

    public static Write getInstance() {
        return wr_csv;
    }

    private static void watchesWR(RolexService service) throws IOException {
        RolexRepository rolexRepository = new RolexRepository();
        try (PrintWriter writer = new PrintWriter("src/main/java/CSV/ceasurileWrite.csv")) {
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
            watchesWR(rolexService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
