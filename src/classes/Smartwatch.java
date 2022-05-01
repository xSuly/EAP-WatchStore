package classes;

public class Smartwatch extends Watch{
    private double display;
    private double RAM_Memory;
    private String resolution;
    private double processor_freq;
    private int battery_capacity;
    private int storage_memory;
    private boolean sim;
    private boolean gps;
    private boolean bluetooth;

    public Smartwatch(String brand, String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap, double display, double RAM_Memory, String resolution, double processor_freq, int battery_capacity, int storage_memory, boolean sim, boolean gps, boolean bluetooth) {
        super(brand, model, price, fabrication_date, smartwatch=true, water_resistant, mechanism, strap);
        this.display = display;
        this.RAM_Memory = RAM_Memory;
        this.resolution = resolution;
        this.processor_freq = processor_freq;
        this.battery_capacity = battery_capacity;
        this.storage_memory = storage_memory;
        this.sim = sim;
        this.gps = gps;
        this.bluetooth = bluetooth;
    }

    public double getDisplay() {
        return display;
    }

    public double getRAM_Memory() {
        return RAM_Memory;
    }

    public String getResolution() {
        return resolution;
    }

    public double getProcessor_freq() {
        return processor_freq;
    }

    public int getBattery_capacity() {
        return battery_capacity;
    }

    public int getStorage_memory() {
        return storage_memory;
    }

    public boolean isSim() {
        return sim;
    }

    public boolean isGps() {
        return gps;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    @Override
    public String toString() {
        return "Smartwatch{" +
                "brand=" + getBrand() +
                ",model=" + getModel() +
                ",price=" + getPrice() +
                ",fabrication date=" + getFabrication_date() +
                ",water resistant?: " + isWater_resistant() +
                ",mechanism=" + getMechanism() +
                ",strap type=" + getStrap() +
                ",display=" + display +
                ", RAM_Memory=" + RAM_Memory + " GB" +
                ", resolution=" + resolution +
                ", processor_freq=" + processor_freq + " GHz" +
                ", battery_capacity=" + battery_capacity + " mAh" +
                ", storage_memory=" + storage_memory + " GB" +
                ", sim=" + sim +
                ", gps=" + gps +
                ", bluetooth=" + bluetooth +
                '}';
    }
}
