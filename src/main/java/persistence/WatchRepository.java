package persistence;

import models.Rolex;
import models.Smartwatch;
import models.Watch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class WatchRepository  {

    private List<Watch> watchList = new ArrayList<>();


    public void save(Watch watch){
        watchList.add(watch);
    }

    public void delete(Watch watch){
        watchList.remove(watch);
    }

    public void update(int index, String attribute, String newValue) {
        List<Watch> watchList1 = new ArrayList<Watch>(this.watchList);


        switch(attribute) {

            case "models":
                watchList1.get(index).setModel(newValue);
                break;
            case "strap":
                watchList1.get(index).setStrap(newValue);
                break;
            default:
                System.out.println("Nothing to update");
                break;
        }
        this.watchList = new ArrayList<>(watchList1);
    }

    public void update2(Watch entity) {
        Scanner read = new Scanner(System.in);
        System.out.println("What would you like to change?:");
        System.out.println("Press -1- for model.");
        System.out.println("Press -2- for strap.");
        System.out.println("Press -3- for price.");
        System.out.println("Press -4- for brand.");
        System.out.println("Press -5- to exit.");

        int choice = read.nextInt();

        while (choice != 5){
            if(choice == 1)
            {
                System.out.println("Enter the new model name: ");
                String newModel = new String();
                newModel = read.next();
                entity.setModel(newModel);
            }
            if (choice == 2)
            {
                System.out.println("Enter the new strap type: ");
                String newStrap = new String();
                newStrap = read.next();
                entity.setStrap(newStrap);
            }
            if (choice == 3)
            {
                System.out.println("Enter the new price of model: ");
                Double newPrice;
                newPrice = read.nextDouble();
                entity.setPrice(newPrice);
            }
            if (choice == 4)
            {
                System.out.println("Enter the new brand: ");
                String newBrand;
                newBrand = read.next();
                entity.setBrand(newBrand);
            }
            if (choice == 5)
            {
                System.out.println("Your changes have been saved!");
                break;
            }
            choice = read.nextInt();
        }
        save2(entity);
    }

    private void save2(Watch entity) {
        for (int i = 0; i < watchList.size(); i ++)
            if(watchList.get(i).getModel() == entity.getModel())
            {
                watchList.set(i, entity);
                break;
            }
    }





    public List<Watch> getAll() {
        return watchList;
    }


}
