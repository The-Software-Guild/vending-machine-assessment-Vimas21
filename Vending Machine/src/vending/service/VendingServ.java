package vending.service;
import java.math.BigDecimal;
import java.util.ArrayList;
import vending.machine.DAO.*;
import vending.machine.DTO.*;
/**
 * Controller shouldn't be doing math. Vending Serve should. This will include:
 * Checking whether or not they have enough money.
 * The amount of change to return.
 * Translating coins to cents.
 * Translating cents to coins.
 * Service also is the only thing that messes with the DAO, so all code passes
 * thru here
 */
public interface VendingServ {
    
    boolean canAfford(BigDecimal cost, BigDecimal has);
    
    BigDecimal coinToValue(CoinEnum coin);
    
    BigDecimal coinListToValue(ArrayList<CoinEnum> coinList);
    
    int[] valueToCoinList(int totalVal);
    
    ArrayList<String> fetchString(String type);
    
    ArrayList<CoinEnum> stringDecoder(ArrayList<String> list);
    
    boolean processPurchase(String name, BigDecimal moolah);
    
    int[] processChange(String choice, BigDecimal moolah);
    
    public void processCoins();
    
    void endStep();
    
}
