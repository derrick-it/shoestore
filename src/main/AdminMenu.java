package main;

import java.util.Scanner;
import model.*;

import java.util.ArrayList;
import java.util.Random;

public class AdminMenu {
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    
    private Admin admin;
    public AdminMenu(Admin admin) {
    	this.admin = admin;
    }
    
    public void menu() {
    	while(true) {
	    	System.out.println("Welcome, " + admin.getName());
	    	System.out.println("[1] Insert new shoes");
	    	System.out.println("[2] Delete new shoes");
	    	System.out.println("[3] Insert new shipping method");
	    	System.out.println("[4] Delete shipping method");
	    	System.out.println("[0] Log out");
	    	
	    	int input = sc.nextInt(); sc.nextLine();
	    	
	    	switch(input) {
	    	case 1:
	    		insertShoe();
	    		break;
	    	case 2:
	    		deleteShoe();
	    		break;
	    	case 3:
	    		insertShipping();
	    		break;
	    	case 4:
	    		deleteShipping();
	    		break;
	    	case 0:
	    		return;
	    	default:
	    		continue;
	    	}
    	}
    	
    }
    
    public void insertShipping() {
    	String name;
        while(true) {
            System.out.printf("Input new shipping name: ");
            name = sc.nextLine();
            if(!name.isEmpty()) {
                break;
            }
            System.out.println("Name cannot be blank");
        }
        
        int price;
        while(true) {
            System.out.printf("Input price: ");
            price = sc.nextInt(); sc.nextLine();
            if(price > 0) {
                break;
            }
        }
        Operate.shippingArrayList.add(new Shipping(name, price));
    }
    
    public void deleteShipping() {
    	String id;
        boolean flag = false;
        int ctr = 0;
     
        tableShipping(Operate.shippingArrayList);
        while(true) {
            System.out.println("Input shipping id to delete: ");
            id = sc.nextLine();
            for(Shipping i : Operate.shippingArrayList) {
                if(i.getName().equals(id)) {
                    flag = true;
                    break;
                }
                ctr++;
            }
            if(flag == false) {
                System.out.println("Shipping id is invalid!");
                continue;
            }
            System.out.println("Delete Success");
            Operate.shippingArrayList.remove(ctr);
            break;
        }
    }
    
    private void tableShoes(ArrayList<Shoes> shoes){
        System.out.println("\tShoes List");
        System.out.println("====================");
        System.out.println();
        for(int i = 0; i < 126; i++){
            if(i < 125){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        System.out.println("| Id     | Shoes Name                                         | brand                | Size      | Stock | Price            |");
        for(int i = 0; i < 126; i++){
            if(i < 125){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        for(int i = 0; i < shoes.size(); i++){
            System.out.printf("| %-6s | %-50s | %-20s | %3d - %-3d | %-5s | Rp. %-12d |\n", shoes.get(i).getId(), shoes.get(i).getName(), shoes.get(i).getBrand(), shoes.get(i).getSizeMin(), shoes.get(i).getSizeMax(), shoes.get(i).getStock(), shoes.get(i).getPrice());
            if(i < shoes.size() - 1){
                for(int j = 0; j < 126; j++){
                    if(j < 125){
                        System.out.print("-");
                    }else{
                        System.out.print("\n");
                    }
                }
            }
        }
        for(int i = 0; i < 126; i++){
            if(i < 125){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }

    }
    
    private void tableShipping(ArrayList<Shipping> shippings){
        System.out.println("\tShipping List");
        System.out.println("======================");
        System.out.println();
        for(int i = 0; i < 66; i++){
            if(i < 65){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        System.out.println("| Id     | Shipping Name                     | Price            |");
        for(int i = 0; i < 66; i++){
            if(i < 65){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        for(int i = 0; i < shippings.size(); i++){
            System.out.printf("| %-6s | %-33s | Rp. %-12d |\n", shippings.get(i).getId(), shippings.get(i).getName(), shippings.get(i).getPrice());
            if(i < shippings.size() - 1){
                for(int j = 0; j < 66; j++){
                    if(j < 65){
                        System.out.print("-");
                    }else{
                        System.out.print("\n");
                    }
                }
            }
        }
        for(int i = 0; i < 66; i++){
            if(i < 65){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
    }
    
    public void deleteShoe() {
        String id;
        boolean flag = false;
        int ctr = 0;
        
     
        tableShoes(Operate.shoesArrayList);
        while(true) {
            System.out.println("Input shoe id to delete: ");
            id = sc.nextLine();
            for(Shoes i : Operate.shoesArrayList) {
                if(i.getName().equals(id)) {
                    flag = true;
                    break;
                }
                ctr++;
            }
            if(flag == false) {
                System.out.println("Shoe id is invalid!");
                continue;
            }
            System.out.println("Delete Success");
            Operate.shoesArrayList.remove(ctr);
            break;
        }

    }
    public void insertShoe() {
        String name;
        while(true) {
            System.out.printf("Input shoe name: ");
            name = sc.nextLine();
            if(!name.isEmpty()) {
                break;
            }
            System.out.println("Name cannot be blank");
        }

        String brand;
        while(true) {
            System.out.printf("Input brand: ");
            brand = sc.nextLine();
            if(!brand.isEmpty()) {
                break;
            }
            System.out.println("Brand cannot be blank");
        }

        int minsize;
        while(true) {
            System.out.printf("Input size lower bound: ");
            minsize = sc.nextInt(); sc.nextLine();
            if(minsize > 0) {
                break;
            }
        }

        int maxsize;
        while(true) {
            System.out.printf("Input size upper bound: ");
            maxsize = sc.nextInt(); sc.nextLine();
            if(maxsize > minsize) {
                break;
            }
        }

        int stock;
        while(true) {
            System.out.printf("Input stock: ");
            stock = sc.nextInt(); sc.nextLine();
            if(stock > 0) {
                break;
            }
        }

        int price;
        while(true) {
            System.out.printf("Input price: ");
            price = sc.nextInt(); sc.nextLine();
            if(price > 0) {
                break;
            }
        }

        Operate.shoesArrayList.add(new Shoes(name, brand, minsize, maxsize, stock, price));
    }

}