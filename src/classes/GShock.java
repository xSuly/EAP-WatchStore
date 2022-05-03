package classes;

public class GShock extends Watch{
    public GShock(String brand, String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap) {
        super(brand, model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap);
        setBrand("GSHOCK");
    }

    public GShock(String model, double price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap) {
        super(model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap);
        setBrand("GSHOCK");
    }
    public void about_gshock ()
    {
        System.out.println("The G-Shock is a line of watches manufactured by the Japanese electronics company Casio, designed to resist mechanical stress, shock and vibration. G-Shock is an abbreviation for Gravitational Shock. The watches in the G-Shock line are designed primarily for sports, military and outdoors-oriented activities; nearly all G-Shocks are chronographs, with either a digital display or a combination of analogue and digital.");
    }

}
