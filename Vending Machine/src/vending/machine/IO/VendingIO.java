package vending.machine.IO;

import java.util.ArrayList;

/**
 * This file is responsible for reading input and writing output.
 * Required functionalities include:
 * Reading in the number of coins inserted.
 * Displaying the change left over.
 * Displaying all the options for items. (Needs the info to be given from controller)
 */
public interface VendingIO {
    
    public int readInt(String Prompt);
    
    public String readString(String Prompt);
    
    public void print(String string);
    
    public void print(int integer);
    
    public void showAllItems(ArrayList nameList, ArrayList priceList, ArrayList<String> stockList);
    
    public ArrayList<String> inputChange();
    
    public String takeOrder(ArrayList<String> names);
    
    public void toChange(int[] array);
    
}
