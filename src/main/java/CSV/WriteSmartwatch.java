package CSV;



import models.Smartwatch;
import persistence.SmartwatchRepository;
import service.SmartwatchService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class WriteSmartwatch {

    private static final WriteSmartwatch wr_csv = null;

    private WriteSmartwatch() {
    }

    public static WriteSmartwatch getInstance() {
        return wr_csv;
    }

    private static void SmartwatchWR(SmartwatchService service) throws IOException {
        SmartwatchRepository rolexRepository = new SmartwatchRepository();
        try (PrintWriter writer = new PrintWriter("src/main/java/CSV/SmartwatchWrite.csv")) {
            List<Smartwatch> list = service.getSmartwatches();
            String header = "brand, model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap, display," +
                    " RAM_Memory, resolution, processor_freq, battery_capacity, storage_memory, sim, gps, bluetooth";
            writer.println(header);

            for (Smartwatch smartwatch : list) {
                writer.println(smartwatch.toString());
            }
        }

    }

    public static void writeToFiles(SmartwatchService smartwatchService) {
        try {
            AuditLog.log("Uploading Smartwatches...");
            SmartwatchWR(smartwatchService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
