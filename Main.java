package vending;

import java.util.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        Machine machine = new Machine();

        machine.addProduct(new Product("Pepsi", 101, 40, 5, "Drink"));
        machine.addProduct(new Product("Chips", 102, 20, 10, "Snack"));
        machine.addProduct(new Product("Chocolate", 103, 30, 7, "Snack"));
        machine.addProduct(new Product("coke", 104, 40, 10, "Drink"));
        machine.addProduct(new Product("jelly", 105, 10, 20, "Snack"));
        machine.addProduct(new Product("milkshake", 106, 30, 20, "Drink"));

        int choice;

        do {
            System.out.println("\n--- VENDING MACHINE ---");
            System.out.println("1. Display Products");
            System.out.println("2. Insert Money");
            System.out.println("3. Buy Product");
            System.out.println("4. Return Change");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    machine.displayProducts();
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    if (!machine.insertMoney(amount)) {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    System.out.println("Select Payment Method:");
                    System.out.println("1. Cash");
                    System.out.println("2. UPI");
                    int payChoice = sc.nextInt();

                    payment p;

                    if (payChoice == 1) {
                        p = new Cash();
                    } else {
                        p = new Upi();
                    }

                    machine.purchaseProduct(id, p);
                    break;

                case 4:
                    machine.returnChange();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();

	}

}
