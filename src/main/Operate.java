package main;

import model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Operate {
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<User> userArrayList = new ArrayList<>();
    public static ArrayList<Order> orderArrayList = new ArrayList<>();
    public static ArrayList<Cart> cartArrayList = new ArrayList<>();
    public static ArrayList<Shoes> shoesArrayList = new ArrayList<>();
    public static ArrayList<Shipping> shippingArrayList = new ArrayList<>();


    private static void initializeUsers(){
        Admin admin = new Admin("admin", "admin", "Manager-chan");
        Customer customer = new Customer("user", "user", "Udin", "Jalan Soekarno Hatta no.20");

        userArrayList.add(admin);
        userArrayList.add(customer);
    }
    private static void initializeShoes(){
        Shoes shoes1 = new Shoes("Abibas Adizero Boston 10 Running Shoes", "Abibas", 40, 45, 10, 1500000);
        Shoes shoes2 = new Shoes( "Abibas Adilette Comfort Men's Slides Sandals", "Abibas", 38, 43, 6, 1000000);
        Shoes shoes3 = new Shoes( "Zuma Smash V2 Sneaker Black", "Zuma", 40, 45, 10, 1500000);
        Shoes shoes4 = new Shoes( "Kike Air Max Infinity 2 Men's Sneaker", "Kike", 40, 45, 20, 800000);
        Shoes shoes5 = new Shoes( "Old Imbalance 100 Men's Sandals", "Old Imbalance", 40, 45, 10, 1200000);

        shoesArrayList.add(shoes1);
        shoesArrayList.add(shoes2);
        shoesArrayList.add(shoes3);
        shoesArrayList.add(shoes4);
        shoesArrayList.add(shoes5);
    }
    private static void initializeShipping(){
        Shipping shoes1 = new Shipping("JEN", 15000);
        Shipping shoes2 = new Shipping("Sang Cepat",  17000);
        Shipping shoes3 = new Shipping("I&U", 10000);

        shippingArrayList.add(shoes1);
        shippingArrayList.add(shoes2);
        shippingArrayList.add(shoes3);
    }

    public static void menu() {
        initializeShoes();
        initializeUsers();
        initializeShipping();
        int menu = 0;
        do{
            System.out.println("Shoe Store");
            System.out.println("=========================");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print(">> ");
            menu = sc.nextInt();
            sc.nextLine();
        }while(menu < 0 || menu > 3);

        switch(menu){
            case 1: login(); break;
            case 2: register(); break;
            case 3: return;
            default: break;
        }

        menu();
    }

    private static void register() {
        String username, password, name, address;

        do{
            System.out.print("Username [0 to cancel] : ");
            username = sc.nextLine();
            if(username.equals("0")){
                return;
            }
        }while(username.isEmpty() || checkUsername(username));

        do{
            System.out.print("Password [0 to cancel] : ");
            password = sc.nextLine();
            if(password.equals("0")){
                return;
            }
        }while(password.isEmpty());

        do{
            System.out.print("Name [0 to cancel] : ");
            name = sc.nextLine();
            if(name.equals("0")){
                return;
            }
        }while(name.isEmpty());

        do{
            System.out.print("Address [0 to cancel] : ");
            address = sc.nextLine();
            if(address.equals("0")){
                return;
            }
        }while(address.isEmpty());

        Customer customer = new Customer( username, password, name, address);
        Operate.userArrayList.add(customer);
    }

    private static boolean checkUsername(String username) {
        for(User user : Operate.userArrayList){
            if(user.getUsername().equals(username)){
                System.out.println("Username is already taken");
                return true;
            }
        }
        return false;
    }

    private static void login() {
        String username, password;

        do{
            System.out.print("Username [0 to cancel] : ");
            username = sc.nextLine();
            if(username.equals("0")){
                return;
            }
        }while(getUser(username) == null);

        do{
            System.out.print("Password [0 to cancel] : ");
            password = sc.nextLine();
            if(password.equals("0")){
                return;
            }
        }while(!checkPassword(username, password));

        User user = getUser(username);

        if(user instanceof Admin){
            // go to page admin
        	AdminMenu adminMenu = new AdminMenu((Admin) user);
        	adminMenu.menu();
            System.out.println("Redirecting to admin");
        }else{
            CustomerMenu customerMenu = new CustomerMenu((Customer) user);
            customerMenu.menu();
            System.out.println("Redirecting to customer");
        }
    }
    private static User getUser(String username) {
        if(!username.isEmpty()){
            for(User user : Operate.userArrayList){
                if(user.getUsername().equals(username)){
                    return user;
                }
            }
            System.out.println("User doesn't exist");
        }
        return null;
    }

    private static boolean checkPassword(String username, String password) {
        User user = getUser(username);
        if(user.getPassword().equals(password)) {
            return true;
        }
        System.out.println("Wrong password.");
        return false;
    }


}
