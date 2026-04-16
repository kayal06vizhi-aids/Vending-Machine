package vending;
import java.util.*;
public class Machine {
         Map<Integer,Product> products=new HashMap<>();
         double balance;
         
         public Machine() {
             products = new HashMap<>();
             balance = 0;
         }
         
         public void displayProducts() {
        	 for(Map.Entry<Integer, Product> e: products.entrySet()) {
        		 System.out.print(e.getKey()+"->");
        		 e.getValue().display();
        	 }
         }
         
         public boolean addProduct(Product p) {
        	    if (!products.containsKey(p.getId())) {
        	        products.put(p.getId(), p);
        	        return true;
        	    } else {
        	        return false;
        	    }
        	}
           public boolean insertMoney(double amount) {
        	    if (amount > 0) {
        	        balance += amount;
        	        return true;
        	    }
        	    return false;
        	}
         
           public void purchaseProduct(int id, payment p) {

               if (!products.containsKey(id)) {
                   System.out.println("Invalid product ID");
                   return;
               }

               Product prod = products.get(id);
               
               if (prod.getQuantity() == 0) {
                   System.out.println("Out of stock");
                   return;
               }

               if (balance < prod.getPrice()) {
                   System.out.println("Insufficient balance");
                   return;
               }

               boolean paid = p.pay(prod.getPrice());

               if (paid) {
                   prod.reduceQuantity(1);
                   balance -= prod.getPrice();

                   System.out.println("Product dispensed: " + prod.getName());
                   System.out.println("Remaining balance: " +"Rs"+ balance);
               } else {
                   System.out.println("Payment failed");
               }
           }

           public void returnChange() {
               if (balance > 0) {
                   System.out.println("Returning change: " +"Rs"+ balance);
                   balance = 0;
               } else {
                   System.out.println("No balance to return");
               }
           }
       }

