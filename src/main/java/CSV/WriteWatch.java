package CSV;

import models.Watch;
import persistence.WatchRepository;
import service.WatchService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteWatch {

    private static final WriteWatch wr_csv = null;

    private WriteWatch() {
    }

    public static WriteWatch getInstance() {
        return wr_csv;
    }

    private static void WatchWR(WatchService service) throws IOException {
        WatchRepository watchRepository = new WatchRepository();
        try (PrintWriter writer = new PrintWriter("src/main/java/CSV/WatchWrite.csv")) {
            List<Watch> list = service.getWatches();
            String header = "brand, model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap";
            writer.println(header);

            for (Watch watch : list) {
                writer.println(watch.toString());
            }
        }

    }

    public static void writeToFiles(WatchService watchService) {
        try {
            AuditLog.log("Uploading Watches...");
            WatchWR(watchService);
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}
