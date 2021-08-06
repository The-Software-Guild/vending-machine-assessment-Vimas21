package vending.machine.IO;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Samma
 */
public class VendingConsoleIOImpl implements VendingIO {

    Scanner inputCheck = new Scanner(System.in);
    
    @Override
    public int readInt(String prompt){
        String choice;
        int choiceInt = 0;
        boolean parsed = false;
        System.out.print(prompt + "       ");
        do{
            System.out.print(prompt);
            choice = inputCheck.nextLine();
            try{
                choiceInt = Integer.parseInt(choice);
                parsed = true;
            }
            catch(NumberFormatException except){
                System.out.println("Error, not a number. Try again.");
            }
        }while(parsed == false);
        return choiceInt;
    }

    @Override
    public String readString(String prompt) {
        System.out.print(prompt + "       ");
        return inputCheck.nextLine();
    }

    @Override
    public void print(String string) {
        System.out.println(string);
    }

    @Override
    public void print(int integer) {
        System.out.println(Integer.toString(integer));
    }

    @Override
    public void showAllItems(ArrayList nameList, ArrayList priceList, ArrayList<String> stockList) {
        System.out.println("<<>><<>><<>><<>><<>><<>><<>>>");
        System.out.println("The following items are for sale:");
        
        for(int i = 0; i < nameList.size(); i++){
            if(Integer.parseInt(stockList.get(i)) > 0){
                System.out.println("Item " + Integer.toString(i+1) + ": " + nameList.get(i) + ". Price: " + priceList.get(i) + ". There are " + stockList.get(i) + " remaining!");
                System.out.println();
            }
            else{
                System.out.println(nameList.get(i) + " IS OUT OF STOCK.");
                System.out.println();
            }
            System.out.println("<<>><<>><<>><<>><<>><<>><<>>>");
        }
    }
    
    @Override
    public ArrayList<String> inputChange(){
        System.out.println("Time to insert your coins. To insert a quarter, type q. To insert a dime, type d. To insert a nickel, type n. To inser a penny, type p.");
        System.out.println("If you'd like to add multiple of the same coin at the same time, add a one-digit number to the froint, i.e. 9d for nine dimes.");
        System.out.println("When you're done, type f.");
        ArrayList<String> changeBuffer = new ArrayList<String>();
        boolean done=false;
        String input = "";
        int multiple = 1;
        do{
            input = inputCheck.nextLine();
            if(input.length()==2){
                multiple = Integer.valueOf(input.substring(0, 1));
                if(multiple < 1 || multiple > 9)
                    multiple = 1;
                input = input.substring(1,2);
            }
            if(input.equalsIgnoreCase("q")){
                for(int i = 0; i<multiple; i++){
                    changeBuffer.add("q");
                }
            }
            else if(input.equalsIgnoreCase("d")){
                for(int i = 0; i<multiple; i++){
                    changeBuffer.add("d");
                }
            }
            else if(input.equalsIgnoreCase("n")){
                for(int i = 0; i<multiple; i++){
                    changeBuffer.add("n");
                }
            }
            else if(input.equalsIgnoreCase("p")){
                for(int i = 0; i<multiple; i++){
                    changeBuffer.add("p");
                }
            }
            else if(input.equalsIgnoreCase("f")){
                done = true;
            }
            else{
                System.out.println("Not parsed.");   
            }
            multiple = 1;
        }while(done == false);
        return changeBuffer;
    }

    public String takeOrder(ArrayList<String> names) {
        System.out.println("Now then, what would you like to order?");
        int i = 0;
        for(i = 0; i < names.size(); i++){
            System.out.println((i+1) + ": " + names.get(i));
        }
        int input = 0;
        String sInput = "";
        boolean valid = false;
        do{
            input = inputCheck.nextInt();
            if(input > 0 && input < i+1){
                System.out.println("Please confirm you chose " + names.get(input-1) + " by typing y.");
                sInput = inputCheck.next();
                if(sInput.equalsIgnoreCase("y"))
                    return names.get(input-1);
                System.out.println("Make a new selection, please.");
            }
            else{
                System.out.println("I could not parse, try again.");
            }
        }while(valid == false);
        return null;
    }
    
    public void toChange(int[] array){
        System.out.println(">><<>><<>>><<>>><<>><<>><<>><<>><<");
        System.out.println("Your change is:");
        System.out.println(array[0] + " quarters.");
        System.out.println(array[1] + " dimes.");
        System.out.println(array[2] + " nickles.");
        System.out.println(array[3] + " pennies.");
    }
    
}
