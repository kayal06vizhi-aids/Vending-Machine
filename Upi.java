package vending;

public class Upi implements payment{
                    public boolean pay(double price) {
                    	System.out.println("payment successful via UPI: "+"Rs"+price);
                    	return true;
                    }
}
