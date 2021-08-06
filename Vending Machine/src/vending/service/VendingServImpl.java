/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import vending.machine.DAO.*;
import vending.machine.DTO.*;

/**
 *
 * @author Samma
 */
public class VendingServImpl implements VendingServ {

    public VendingDAO dao;
    public VendingAudit aud;

    public VendingServImpl(VendingDAO dao) throws FileNotFoundException {
        this.dao = dao;
        dao.fromFile();
        this.aud = new VendingAuditImpl();
    }

    @Override
    public boolean canAfford(BigDecimal cost, BigDecimal has) {
        int affordability = cost.compareTo(has);
        if (affordability < 1) {
            return true;
        }
        return false;
    }

    @Override
    public BigDecimal coinToValue(CoinEnum coin) {
        return coin.getBD();
    }

    public ArrayList<CoinEnum> stringDecoder(ArrayList<String> list) {
        ArrayList<CoinEnum> finalList = new ArrayList<CoinEnum>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase("q")) {
                finalList.add(CoinEnum.QUARTER);
                //System.out.println("I found a quarter!");
            } else if (list.get(i).equalsIgnoreCase("d")) {
                finalList.add(CoinEnum.DIME);
                //System.out.println("I found a dime!");
            } else if (list.get(i).equalsIgnoreCase("n")) {
                finalList.add(CoinEnum.NICKEL);
                //System.out.println("I found a Nickel!");
            } else if (list.get(i).equalsIgnoreCase("p")) {
                finalList.add(CoinEnum.PENNY);
                //System.out.println("I found a penny!");
            }
        }
        return finalList;
    }

    @Override
    public BigDecimal coinListToValue(ArrayList<CoinEnum> coinList) {
        BigDecimal values = new BigDecimal(".00").setScale(2, RoundingMode.HALF_UP);
        for (CoinEnum coin : coinList) {
            values = values.add(coin.getBD());
        }
        return values;
    }

    @Override
    public int[] valueToCoinList(int totalVal) {
        int leftOver = totalVal % 25;
        int times = totalVal / 25; // Fun fact, int drops the floor, so we can literally just do this.
        int[] change = {0, 0, 0, 0};
        change[0] = times;
        times = leftOver / 10;
        leftOver = leftOver % 10;
        change[1] = times;
        times = leftOver / 5;
        leftOver = leftOver % 5;
        change[2] = times;
        change[3] = leftOver;
        aud.addChangeGiven();
        return change;
    }

    public void processCoins() {
        aud.addChangeInserted();
    }

    public ArrayList<String> fetchString(String type) {
        if (type.equalsIgnoreCase("Names")) {
            return dao.allKeys();
        }
        if (type.equalsIgnoreCase("Costs")) {
            Stream<BigDecimal> bdStream = dao.returnCosts();
            return new ArrayList<String>(bdStream.map((p) -> p.toString()).collect(Collectors.toList()));
        }
        if (type.equalsIgnoreCase("Inventory")) {
            return dao.returnInventory();
        }
        return null;
    }

    public boolean processPurchase(String name, BigDecimal moolah) {
        try {
            if (!this.canAfford(dao.returnFood(name).getPrice(), moolah)) {
                aud.addNoMoney();
                throw new OutOfStockException("Item is out of stock.");
            }
        } catch (OutOfStockException error) {
            return false;
        }
            try {
                if (dao.returnFood(name).getAmount() < 1) {
                    aud.addNoStock();
                    throw new InsufficientFundsException("You lack the required funds for this transaction.");
                }
            } catch (InsufficientFundsException err) {
                return false;
            }
                dao.take(name);
                aud.addVended(true);
                return true;
    }

    public int[] processChange(String choice, BigDecimal moolah) {
        int totalVal = (moolah).subtract(dao.returnFood(choice).getPrice()).multiply(new BigDecimal("100")).intValue();
        return this.valueToCoinList(totalVal);
    }

    public void endStep() {
        try {
            dao.toFile();
            aud.endStep();
        } catch (IOException ex) {
            Logger.getLogger(VendingServImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    boolean canAfford(BigDecimal setScale) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
