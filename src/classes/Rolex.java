package classes;

public class Rolex extends Watch {




    public Rolex(String brand, String model, float price, int fabrication_date, boolean smartwatch, boolean water_resistant, String mechanism, String strap) {
        super(brand="Rolex", model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap);

    }

    public void about_rolex ()
    {
        System.out.println("Rolex SA is a British-founded Swiss watch designer and manufacturer based in Geneva, Switzerland. Founded in 1905 as Wilsdorf and Davis by Hans Wilsdorf and Alfred Davis in London, England, the company registered the word 'Rolex' as the brand name of its watches in 1908, and it became Rolex Watch Co. Ltd. in 1915.");
    }

}
