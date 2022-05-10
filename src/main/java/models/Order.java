package models;

import java.util.LinkedList;

public class Order {
    private static int order_id = 1;
    private LinkedList<Watch> watches;

    public Order(int order_id, LinkedList<Watch> watches) {
        order_id++;
        this.watches = watches;
    }

    public void addWatch(Watch watch)
    {
        watches.add(watch);
    }

    public Order()
    {
        watches = new LinkedList<>();
    }

    public void removeWatch(Watch watch)
    {
        watches.remove(watch);
    }

    public int TotalCost()
    {
        int cost=0;
        for(Watch watch : watches)
            cost+= watch.getPrice();
        return cost;
    }

    public static int getOrder_id() {
        return order_id;
    }


    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", watches=" + watches +
                '}';
    }
}
