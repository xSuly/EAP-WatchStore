package persistence;

import classes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRepository implements  GenericRepository<User>{
    private List<User> users = new ArrayList<>();

    @Override
    public void add(User entity) {
        users.add(entity);
    }

    @Override
    public User get(int id) {
        return users.get(id);
    }

    @Override
    public void update(User entity) {
        Scanner read = new Scanner(System.in);
        System.out.println("Hello, " + entity.getUsername() + "! What would you like to change?:");
        System.out.println("Press -1- for address.");
        System.out.println("Press -2- for city.");
        System.out.println("Press -3- for country.");
        System.out.println("Press -4- to exit.");

        int choice = read.nextInt();

        while (choice != 4){
            if(choice == 1)
            {
                System.out.println("Enter the new address: ");
                String newAddress = new String();
                newAddress = read.next();
                entity.setAdress(newAddress);
            }
            if (choice == 2)
            {
                System.out.println("Enter the new city: ");
                String newCity = new String();
                newCity = read.next();
                entity.setCity(newCity);
            }
            if (choice == 3)
            {
                System.out.println("Enter the new country: ");
                String newCountry = new String();
                newCountry = read.next();
                entity.setCountry(newCountry);
            }
            if (choice == 4)
            {
                System.out.println("Your changes have been saved!");
                break;
            }
            choice = read.nextInt();
        }
        save(entity);
    }

    private void save(User entity) {
        for (int i = 0; i < users.size(); i ++)
            if(users.get(i).getUser_id() == entity.getUser_id())
            {
                users.set(i, entity);
                break;
            }
    }

    @Override
    public void delete(User entity) {
        users.remove(entity);

    }

    @Override
    public int getSize() {
        return users.size();
    }
}
