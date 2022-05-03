package persistence;

import classes.Smartwatch;
import classes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartwatchRepository implements GenericRepository<Smartwatch> {

    private List<Smartwatch> smartwatches = new ArrayList<>();

    @Override
    public void add(Smartwatch entity) {
        smartwatches.add(entity);
    }

    @Override
    public Smartwatch get(int id) {
        return smartwatches.get(id);
    }

    @Override
    public void update(Smartwatch entity) {
        Scanner read = new Scanner(System.in);
        System.out.println("What would you like to change?:");
        System.out.println("Press -1- for model.");
        System.out.println("Press -2- for strap.");
        System.out.println("Press -3- for price.");
        System.out.println("Press -4- to Processor frequency.");
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
                System.out.println("Enter the CPU Speed: ");
                Double newFreq;
                newFreq = read.nextDouble();
                entity.setProcessor_freq(newFreq);
            }
            if (choice == 5)
            {
                System.out.println("Your changes have been saved!");
                break;
            }
            choice = read.nextInt();
        }
        save(entity);
    }

    private void save(Smartwatch entity) {
        for (int i = 0; i < smartwatches.size(); i ++)
            if(smartwatches.get(i).getModel() == entity.getModel())
            {
                smartwatches.set(i, entity);
                break;
            }
    }

    @Override
    public void delete(Smartwatch entity) {
        smartwatches.remove(entity);

    }

    @Override
    public int getSize() {
        return smartwatches.size();
    }

}
