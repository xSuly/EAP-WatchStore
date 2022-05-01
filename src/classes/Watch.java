package classes;

public class Watch {

    private String brand;
    private String model;
    private double price;
    private int fabrication_date;
    private boolean smartwatch;
    private boolean water_resistant;
    private String mechanism;
    private String strap;

    public Watch(String brand, String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.fabrication_date = fabrication_date;
        this.smartwatch = smartwatch;
        this.water_resistant = water_resistant;
        this.mechanism = mechanism;
        this.strap = strap;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getFabrication_date() {
        return fabrication_date;
    }

    public boolean isSmartwatch() {
        return smartwatch;
    }

    public boolean isWater_resistant() {
        return water_resistant;
    }

    public String getMechanism() {
        return mechanism;
    }

    public String getStrap() {
        return strap;
    }

    @Override
    public String toString() {
        return "Watch{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price + " RON" +
                ", fabrication_date=" + fabrication_date +
                ", smartwatch=" + smartwatch +
                ", water_resistant=" + water_resistant +
                ", mechanism='" + mechanism + '\'' +
                ", strap='" + strap + '\'' +
                '}';
    }
}
