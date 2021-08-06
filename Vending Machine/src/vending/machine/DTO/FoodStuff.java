package vending.machine.DTO;
import java.math.*;
/**
 * This Class Acts as a single item available from a vending machine.
 * It will contain a value for its name, its cost, and the number of stock.
 */
public class FoodStuff {
    
    String name;
    BigDecimal price;
    int amount;
    
    public FoodStuff(String nName, BigDecimal nPrice, int nAmount){
        name = nName;
        price = nPrice;
        amount = nAmount;
    }
    
    public String getName(){
        return name;
    }
    
    public void decrement(){
        amount=amount-1;
    }
    
    public BigDecimal getPrice(){
        return price;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public boolean isStocked(){
        if(amount>0)
            return true;
        return false;
    }
    
}
