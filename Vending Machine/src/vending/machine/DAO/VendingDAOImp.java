
package vending.machine.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import vending.machine.DTO.FoodStuff;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Samma
 */
public class VendingDAOImp implements VendingDAO {
    HashMap<String, FoodStuff> machineStorage = new HashMap<String, FoodStuff>();
    
    private String FILENAME = "VendingInven.txt";
    
    public VendingDAOImp(String filename){
        this.FILENAME = filename;
    }
    
    public void take(String food){
        machineStorage.get(food).decrement();
    }
    
    public FoodStuff returnFood(String food){
        return machineStorage.get(food);
    }
    
    public ArrayList allKeys(){
        ArrayList<String> all = new ArrayList<String>();
        for(String k : machineStorage.keySet()){
            all.add(k);
        }
        return all;
    }
    
    public void fromFile() throws FileNotFoundException{
        HashMap<String, FoodStuff> vend = new HashMap<>();
        Scanner sc = new Scanner(new BufferedReader(new FileReader(FILENAME)));
        
        while (sc.hasNextLine()) {
            FoodStuff freshFood = nameBreakdown(sc.nextLine());
            machineStorage.put(freshFood.getName(), freshFood);
        }
    }
    
    private static FoodStuff nameBreakdown(String full) {
        String[] splitted = full.split("\"");
        FoodStuff newby = new FoodStuff(splitted[0], new BigDecimal(splitted[1]).setScale(2, RoundingMode.HALF_UP), Integer.valueOf(splitted[2]));
        return newby;
    }
    
    public void toFile() throws IOException{
        PrintWriter out = new PrintWriter(new FileWriter(FILENAME));
        for(String k : machineStorage.keySet()){
            FoodStuff food = machineStorage.get(k);
            out.println(k + "\"" + food.getPrice().toString() + "\"" + food.getAmount());
        }
        out.flush();
        out.close();
    }

    @Override
    public Stream<BigDecimal> returnCosts() {
        //ArrayList<String> all = new ArrayList<String>();
        Stream<FoodStuff> all = machineStorage.values().stream();
        Stream<BigDecimal> bdStream = all.map((p) -> p.getPrice());
        return bdStream;
    }

    @Override
    public ArrayList returnInventory() {
        ArrayList<String> all = new ArrayList<String>();
        for(String k : machineStorage.keySet()){
            all.add(Integer.toString(machineStorage.get(k).getAmount()));
        }
        return all;
    }
}
