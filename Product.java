package vending;

public class Product {
              private final String product;
              private final int prod_id;
              private double price;
              private int quantity;
              private String category;
              public Product(String p,int p_id,double price,int q,String cat){
            	  this.product=p;
            	  this.prod_id=p_id;
            	  this.price=price;
            	  this.category=cat;
            	  if(q>=0) {
            	  this.quantity=q;
            	  }else {
            		  this.quantity=0;
            	  }
              }
              public String getName() {
            	  return product;
              }
              public int getId() {
            	  return prod_id;
              }
              public double getPrice() {
            	  return price;
              }
              public int getQuantity() {
            	  return quantity;
              }
              public String getCategory() {
            	  return category;
              }
              
              public boolean updateQuantity(int newstock) {
            	  if(newstock>0) {
            		  this.quantity+=newstock;
            		  return true;
            	  }else {
            		  return false;
            	  }
              }
              
              public boolean reduceQuantity(int removed) {
            	  if(removed>0 && quantity>=removed) {
            		  this.quantity-=removed;
            		  return true;
            	  }else {
            		  return false;
            	  }
              }
              
              public void display() {
            	  System.out.println("["+category+"] ID:"+prod_id+"|"+product+"|"+"Rs"+price+"| stock-"+quantity);
              }
}
