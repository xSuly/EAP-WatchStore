package classes;

public class Rolex extends Watch implements Comparable<Rolex> {




    public Rolex(String brand, String model, float price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap) {
        super(brand="Rolex", model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap);

    }



    @Override
    public int compareTo(Rolex o) {
        if(this.getPrice() == o.getPrice())
            return 0;
        else if (this.getPrice() < o.getPrice())
            return -1;
        else return 1;
    }
}
