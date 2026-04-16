package vending;

public class Cash implements payment{
             public boolean pay(double price) {
            	 System.out.println("payment successful via Cash: "+"Rs"+price);
             	return true;
             }
}
