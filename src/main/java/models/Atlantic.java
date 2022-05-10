package models;

public class Atlantic extends Watch{

    boolean onStock;

    public Atlantic(String brand, String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap, boolean onStock) {
        super(brand="Atlantic", model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap);
        this.onStock = onStock;
        setBrand("Atlantic");
    }

    public Atlantic(String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap, boolean onStock) {
        super(model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap);
        this.onStock = onStock;
        setBrand("Atlantic");
    }

    public void about_atlantic()
    {
        System.out.println("The Atlantic company was established in Bettlach, a village near Grenchen Switzerland, in 1888. It was founded by Eduard Kummer, born March 26, 1845.");
    }


}
