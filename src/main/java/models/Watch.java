package models;

public class Watch implements Comparable<Watch> {

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

    public Watch(String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap) {
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

    @Override
    public int compareTo(Watch o) {
        if(this.getPrice() == o.getPrice())
            return 0;
        else if (this.getPrice() < o.getPrice())
            return -1;
        else return 1;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStrap(String strap) {
        this.strap = strap;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
