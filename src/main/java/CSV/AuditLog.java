package CSV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class AuditLog {

    private static File f = new File("src/main/java/CSV/ActionsTimestamp.csv");
    private static FileWriter fw;

    static {
        try {
            fw = new FileWriter(f,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedWriter bw = new BufferedWriter(fw);

    private static Timestamp ts;

    private static final AuditLog l = null;

    public AuditLog() throws IOException {
        if(!f.exists()){
            f.getParentFile().mkdirs();
            f.createNewFile();
        }
    }

    public static AuditLog getInstance() {
        return l;
    }

    public static BufferedWriter getBw() {
        return bw;
    }

    public static void log(String msg) throws IOException {
        ts = new Timestamp(System.currentTimeMillis());
        bw.write(msg + "," + ts + ",");
        bw.newLine();
    }

    public static void clearLog() throws IOException {
        fw = new FileWriter(f, false);
        bw = new BufferedWriter(fw);
        bw.write("");
    }

}
