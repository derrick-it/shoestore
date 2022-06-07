package main;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {
    private Customer customer;
    private int totalPrice;
    public CustomerMenu(Customer customer) {
        this.customer = customer;
    }

    Scanner sc = new Scanner(System.in);
    public void menu(){
        String choose;
        boolean flagCheck;
        int idChosen = 0;
        do{
            flagCheck = false;
            tableShoes(Operate.shoesArrayList);
            System.out.printf(" %-25s %-37s %-38s %20s \n", "[0] Profile", "[Enter] Checkout", "[-] Cart", "[=] Log Out");
            System.out.println("Choose Id Shoes to add to cart or choose option:");
            System.out.print(">> ");
            choose = sc.nextLine();
            switch(choose){
                case "-":
                    cart();
                    break;
                case "":
                    if(Operate.cartArrayList.size() != 0){
                        checkOut();
                    }
                    break;
                case "0":
                    editProfile();
                    break;
                case "=":
                    System.out.println("Thank you for shopping shoes here");
                    return;
                default:
                    int qty;
                    for(int i = 0; i < Operate.shoesArrayList.size(); i++){
                        if(Operate.shoesArrayList.get(i).getId().equals(choose)){
                            idChosen = i;
                            flagCheck = true;
                            break;
                        }
                    }
                    if(flagCheck) {
                        int sizeChoose = 0;
                        do{
                            System.out.println("Size: ");
                            System.out.print(">> ");
                            sizeChoose = sc.nextInt();
                            if(sizeChoose >= Operate.shoesArrayList.get(idChosen).getSizeMin() && sizeChoose <= Operate.shoesArrayList.get(idChosen).getSizeMax()){
                                break;
                            }else{
                                System.out.println("Size must be at range " + Operate.shoesArrayList.get(idChosen).getSizeMin() + " to " + Operate.shoesArrayList.get(idChosen).getSizeMax());
                            }
                        }while(true);
                        do {
                            System.out.println("Qty:");
                            System.out.print(">> ");
                            qty = sc.nextInt();
                            sc.nextLine();
                            if (qty <= 0) {
                                continue;
                            } else {
                                Operate.cartArrayList.add(new Cart(Operate.shoesArrayList.get(idChosen), qty, sizeChoose));
                                break;
                            }
                        } while (true);

                    }else{
                        System.out.println("There's no Shoes or Option like that...");
                    }
                    System.out.println("Press Enter to Continue....");
                    sc.nextLine();
                    break;
            }
        }while(true);
    }

    private void checkOut(){
        String choose;
        do{
            tableCart(Operate.cartArrayList, 0);
            System.out.printf(" %-36s %-20s %58s \n", "[Enter] Checkout", "", "[-] Back");
            System.out.println("option:");
            System.out.print(">> ");
            choose = sc.nextLine();
            if(choose.isEmpty()){
                chooseShipping();
                break;
            }else if(choose.equals("-")){
                break;
            }
        }while(true);
        System.out.println("Press Enter to Continue....");
        sc.nextLine();
    }
    
    private void chooseShipping(){
        String choose, chooseValidate;
        boolean flagCheck;
        int idChoosen = 0;
        do {
            flagCheck = false;
            tableShipping(Operate.shippingArrayList);
            System.out.printf(" %s \n", "[-] Back");
            System.out.println("Choose Shipping id or go back:");
            System.out.print(">> ");
            choose = sc.nextLine();
            if(!choose.equals("-")){
                for(int i = 0; i < Operate.shippingArrayList.size(); i++){
                    if(Operate.shippingArrayList.get(i).getId().equals(choose)){
                        idChoosen = i;
                        flagCheck = true;
                        break;
                    }
                }
                if(flagCheck){
                    totalPrice = Operate.shippingArrayList.get(idChoosen).getPrice();
                    do{
                        System.out.println("Are you sure to Checkout? [y (yes) | n (no)]");
                        System.out.print(">> ");
                        chooseValidate = sc.nextLine();
                        if(chooseValidate.equals("y") || chooseValidate.equals("yes")){
                            tableCart(Operate.cartArrayList, totalPrice);
                            System.out.println();
                            System.out.println("Cart has been checkout");
                            ArrayList<Cart> valueCart = new ArrayList<>(Operate.cartArrayList);
                            Operate.orderArrayList.add(new Order(this.customer, valueCart));
                            Operate.cartArrayList.clear();
                            return;
                        }else if(chooseValidate.equals("n") || chooseValidate.equals("no")){
                            break;
                        }
                    }while(true);
                }else{
                    System.out.println("There's no Shipping id like that...");
                    System.out.println("Press Enter to Continue....");
                    sc.nextLine();
                }
            }else {
                return;
            }
        }while(true);
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
    private void editProfile(){
        String name, address, choose, username, password;
        System.out.println("Id: " + customer.getId());
        System.out.println("Name: " + customer.getName());
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Address: " + customer.getAddress());
        do{
            System.out.println("[-] Back                       [1] Edit");
            System.out.print(">> ");
            choose= sc.nextLine();
            if(choose.equals("0")){
                return;
            }else if(choose.equals("1")){
                name = editProfileString("Name",customer.getName(),customer.getName());
                username = editProfileString("UserName", customer.getUsername(), customer.getUsername());
                address = editProfileString("Address",customer.getAddress(), customer.getAddress());
                password = editProfileString("Password", "", customer.getPassword());
                customer.setName(name);
                customer.setAddress(address);
                customer.setUsername(username);
                customer.setPassword(password);
                break;
            }
        }while(true);
        System.out.println("Press Enter to Continue....");
        sc.nextLine();
    }
    private String editProfileString(String title, String dataShow, String data){
        String input;
        do {
            String show = dataShow.isEmpty() ? " " : " (current: " + dataShow + ")";
            System.out.println(title + ":" + show);
            System.out.println("[-] Ignore");
            System.out.print(">> ");
            input = sc.nextLine();
            if(!input.isEmpty()){
                if(input.equals("-")){
                    return data;
                }else{
                    return input;
                }
            }
        }while(true);
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
    public void tableCart(ArrayList<Cart> cartShoes, int totalPrice){
        System.out.println("\tCart List");
        System.out.println("====================");
        System.out.println();
        for(int i = 0; i < 119; i++){
            if(i < 118){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        System.out.println("| Id     | Shoe Name                                          | brand                | Size | Qty | Price            |");
        for(int i = 0; i < 119; i++){
            if(i < 118){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        if(cartShoes.size() > 0){
            for(int i = 0; i < cartShoes.size(); i++){
                System.out.printf("| %-6s | %-50s | %-20s | %-4d | %-3s | Rp. %-12d |\n", cartShoes.get(i).getShoes().getId(), cartShoes.get(i).getShoes().getName(), cartShoes.get(i).getShoes().getBrand(), cartShoes.get(i).getSize(), cartShoes.get(i).getQty(), cartShoes.get(i).getShoes().getPrice() * cartShoes.get(i).getQty());
                totalPrice += cartShoes.get(i).getShoes().getPrice() * cartShoes.get(i).getQty();
                if(i < cartShoes.size() - 1){
                    for(int j = 0; j < 119; j++){
                        if(j < 118){
                            System.out.print("-");
                        }else{
                            System.out.print("\n");
                        }
                    }
                }
            }
        }else{
            System.out.printf("%70s\n","There's no shoes in cart");
        }
        for(int i = 0; i < 119; i++){
            if(i < 118){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }
        System.out.printf("| %-95s | Rp. %-12d |\n", "Total ", totalPrice);
        for(int i = 0; i < 119; i++){
            if(i < 118){
                System.out.print("=");
            }else{
                System.out.print("\n");
            }
        }

    }
    private void cart(){
        String choose;
        boolean flagCheck;
        do{
            tableCart(Operate.cartArrayList, 0);
            System.out.printf(" %-42s %-30s %42s \n", "[0] Delete", "[=] Edit qty", "[-] Back");
            System.out.println("option:");
            System.out.print(">> ");
            choose = sc.nextLine();
            switch(choose){
                case "-":
                    return;
                case "=":
                    if(Operate.cartArrayList.size() > 0){
                        editQty(Operate.cartArrayList);
                    }
                    break;
                case "0":
                    if(Operate.cartArrayList.size() > 0){
                        delete(Operate.cartArrayList);
                    }
                    break;
                default:

            }
        }while(true);

    }
    private void delete(ArrayList<Cart> cartShoes){
        String chooseId = "", validationRemove;
        boolean flagCheck;
        int idChosen = 0;
        do{
            tableCart(cartShoes, 0);
            System.out.println("Choose Id:");
            System.out.print(">> ");
            chooseId = sc.nextLine();
            flagCheck = false;
            if(chooseId.equals("0")){
                return;
            }else{
                for(int i = 0; i < cartShoes.size(); i++){
                    if(cartShoes.get(i).getShoes().getId().equals(chooseId)){
                        idChosen = i;
                        flagCheck = true;
                        break;
                    }
                }
                if(flagCheck){
                    do {
                        System.out.println("Are you sure to remove " + cartShoes.get(idChosen).getShoes().getId() + "? [y (yes) | n (no)]");
                        System.out.print(">> ");
                        validationRemove = sc.nextLine();
                        validationRemove.toLowerCase();
                        if(validationRemove.equals("y") || validationRemove.equals("yes")){
                            cartShoes.remove(idChosen);
                            break;
                        }else if(validationRemove.equals("n") || validationRemove.equals("no")){
                            return;
                        }
                    }while(true);
                    System.out.println("Press Enter to Continue....");
                    sc.nextLine();
                    return;
                }else{
                    System.out.println("There's no Shoes id like that...");
                    System.out.println("Press Enter to Continue....");
                    sc.nextLine();
                }
            }
        }while(true);
    }
    private void editQty(ArrayList<Cart> cartShoes){
        String chooseId = "";
        boolean flagCheck;
        int idChosen = 0;
        int qty;
        do{
            tableCart(cartShoes, 0);
            System.out.printf(" %s \n", "[-] Back");
            System.out.println("Choose Id:");
            System.out.print(">> ");
            chooseId = sc.nextLine();
            flagCheck = false;
            if(chooseId.equals("-")){
                return;
            }else{
                for(int i = 0; i < cartShoes.size(); i++){
                    if(cartShoes.get(i).getShoes().getId().equals(chooseId)){
                        idChosen = i;
                        flagCheck = true;
                        break;
                    }
                }
                if(flagCheck){
                    System.out.println("Qty:");
                    System.out.print(">> ");
                    qty = sc.nextInt();
                    sc.nextLine();
                    if(qty <= 0){
                        cartShoes.remove(idChosen);
                    }else{
                        cartShoes.get(idChosen).setQty(qty);
                    }
                    System.out.println("Press Enter to Continue....");
                    sc.nextLine();
                    break;
                }else{
                    System.out.println("There's no Shoes id like that...");
                    System.out.println("Press Enter to Continue....");
                    sc.nextLine();
                }
            }
        }while(true);
    }
}
