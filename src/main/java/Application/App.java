package Application;

import models.Smartwatch;
import models.User;
import exceptions.InvalidDataException;
import service.SmartwatchService;
import service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class App {
    private Scanner keyboard = new Scanner(System.in);
    private UserService userService = new UserService();
    private SmartwatchService smartwatchService = new SmartwatchService();

    public static void main(String [] args) throws InvalidDataException, IOException {
        App app = new App();
        while (true){
            app.showMenu();
            int option = app.readOption();
            app.execute(option);
        }
    }

    private void execute(int option) throws InvalidDataException, IOException {
        switch (option){
            case 1:
                addUser();
                break;
            case 2:
                selectUser();
                break;
            case 3:
                selectAllUsers();
                break;
            case 4:
                sortUsers();
                break;
            case 5:
                addSmartwatch();
                break;
            case 6:
                selectSmartwatch();
                break;
            case 7:
                selectAllSmartwatches();
                break;
            case 8:
                sortSmartwatches();
                break;
            case 9:
                System.exit(0);
                break;
        }
    }

    private void addUser() throws InvalidDataException{
        String username, pass, email, address, city, country;
        int age;
        System.out.printf("Hello and welcome to WatchStore! Please, enter your username: ");
        username = keyboard.next();
        System.out.printf("Now enter a password: ");
        pass = keyboard.next();
        System.out.println("What's your email address?: ");
        email = keyboard.next();
        System.out.println("What's your age?: ");
        age = keyboard.nextInt();
        System.out.println("What's your address?: ");
        address = keyboard.next();
        System.out.println("In which city do you live?: ");
        city = keyboard.next();
        System.out.println("What country is that?: ");
        country = keyboard.next();
        User newUser = new User(username, pass, email, age, address, city, country);
        userService.registerNewUser(newUser);
    }

    private void selectUser(){
        String username = new String();
        System.out.println("What username do you search for?: "); //not a good practice, not going to show password
        username = keyboard.nextLine();
        if(userService.getUserApp(username)!= null)
            System.out.println(userService.getUserApp(username));
        else
            System.out.println("Invalid username!");
    }

    private void selectAllUsers(){
        userService.getAllUsers();
    }

    private void sortUsers(){
        System.out.println(userService.sortAll());
    }

    private void addSmartwatch() throws InvalidDataException, IOException {
        String brand;
        String model; double price; int fabrication_date; boolean smartwatch=true;
        boolean water_resistant; String mechanism; String strap; double display;
        double RAM_Memory; String resolution; double processor_freq; int battery_capacity;
        int storage_memory; boolean sim=false; boolean gps=true; boolean bluetooth=true;
        System.out.printf("Please, enter the brand name: ");
        brand = keyboard.next();
        System.out.printf("Now enter a model: ");
        model = keyboard.next();
        System.out.println("What's the price?: ");
        price = keyboard.nextDouble();
        System.out.println("When was is built?: ");
        fabrication_date = keyboard.nextInt();
        System.out.println("Is it water resistant?: ");
        water_resistant = keyboard.nextBoolean();
        System.out.println("What mechanism does it have?: ");
        mechanism = keyboard.next();
        System.out.println("What strap type?: ");
        strap = keyboard.next();
        System.out.println("How many inches does the display has?: ");
        display = keyboard.nextDouble();
        System.out.println("Memory RAM?: ");
        RAM_Memory = keyboard.nextDouble();
        System.out.println("What's the resolution?: ");
        resolution = keyboard.next();
        System.out.println("CPU Speed?: ");
        processor_freq = keyboard.nextDouble();
        System.out.println("Battery capacity?: ");
        battery_capacity = keyboard.nextInt();
        System.out.println("Storage memory?: ");
        storage_memory = keyboard.nextInt();
        Smartwatch newSmartwatch = new Smartwatch(brand, model, price, fabrication_date, smartwatch, water_resistant, mechanism, strap, display, RAM_Memory, resolution, processor_freq, battery_capacity, storage_memory, sim, gps, bluetooth);
        smartwatchService.registerNewSmartwatch(newSmartwatch);
    }

    private void selectSmartwatch() throws IOException {
        String model = new String();
        System.out.println("What model do you search for?: ");
        model = keyboard.nextLine();
        if(smartwatchService.getSmartApp(model)!= null)
            System.out.println(smartwatchService.getSmartApp(model));
        else
            System.out.println("Unknown model!");
    }

    private void selectAllSmartwatches(){
        smartwatchService.getAllSmartwatch();
    }

    private void sortSmartwatches(){
        System.out.println(smartwatchService.sortAll());
    }















    private int readOption() {
        try {
            int option = readInt();
            if (option >= 1 && option <= 9)
                return option;
        }catch (InvalidDataException invalid){

        }
        System.out.println("Invalid option. Try again");
        return readOption();
    }

    private int readInt() throws InvalidDataException {
        String line = keyboard.nextLine();
        if(line.matches("^\\d+$"))
            return Integer.parseInt(line);
        else {
            throw new InvalidDataException("Invalid option");
        }
    }

    private void showMenu() {
        System.out.println("What do you want to do?");
        System.out.println("Press -1- to add a new user.");
        System.out.println("Press -2- to search for an user.");
        System.out.println("Press -3- to display all users.");
        System.out.println("Press -4- to sort users.");
        System.out.println("Press -5- to add a new smartwatch.");
        System.out.println("Press -6- to search for a smartwatch.");
        System.out.println("Press -7- to display all smartwatches.");
        System.out.println("Press -8- to sort smartwatches.");
        System.out.println("Press -9- to exit the app.");
    }

}
