package vending.machine.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import vending.machine.DTO.FoodStuff;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * This File is responsible for where all the data goes.
 * This includes a hashMap of String, Food for each available food-thing.
 * A function for decrementing a foods stock by one.
 * A function for returning any and all information on any piece of food.
 * A function for returning all keys.
 * Loading in information from a file.
 * Printing info to a file.
 */
public interface VendingDAO {
    
    HashMap<String, FoodStuff> machineStorage = new HashMap<String, FoodStuff>();
    
    public void take(String food);
    
    public FoodStuff returnFood(String food);
    
    public ArrayList allKeys();
    
    public void fromFile()  throws FileNotFoundException;
    
    public void toFile() throws IOException;
    
    public Stream<BigDecimal> returnCosts();
    
    public ArrayList returnInventory();
    
}
