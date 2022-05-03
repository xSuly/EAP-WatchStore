package Application;

import classes.User;
import exceptions.InvalidDataException;
import service.UserService;

import java.util.Scanner;

public class App {
    private Scanner keyboard = new Scanner(System.in);
    private UserService userService = new UserService();

    public static void main(String [] args) throws InvalidDataException {
        App app = new App();
        while (true){
            app.showMenu();
            int option = app.readOption();
            app.execute(option);
        }
    }

    private void execute(int option) throws InvalidDataException {
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

    private int readOption() {
        try {
            int option = readInt();
            if (option >= 1 && option <= 5)
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
        System.out.println("Press -5- to exit the app.");
    }

}
