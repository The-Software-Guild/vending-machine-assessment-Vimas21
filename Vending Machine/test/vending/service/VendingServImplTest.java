package vending.service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vending.machine.DAO.VendingDAOImp;
import vending.machine.DTO.CoinEnum;


public class VendingServImplTest {
    
    VendingServImpl instance;
            
    public VendingServImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws FileNotFoundException {
        VendingServImpl instance = new VendingServImpl(new VendingDAOImp("TestInven.txt"));
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of canAfford method, of class VendingServImpl.
     */
    @Test
    public void testCanAfford() {
        boolean expResult = false;
        boolean result = instance.canAfford(new BigDecimal(".01").setScale(2, RoundingMode.HALF_UP), new BigDecimal(".10").setScale(2, RoundingMode.HALF_UP));
        assertEquals(expResult, result, ".01 is less than .10");
        result = instance.canAfford(new BigDecimal(".00").setScale(2, RoundingMode.HALF_UP), new BigDecimal("10.00").setScale(2, RoundingMode.HALF_UP));
        assertEquals(expResult, result, ".00 is less than 10.00");
        expResult = true;
        result = instance.canAfford(new BigDecimal(".10").setScale(2, RoundingMode.HALF_UP), new BigDecimal(".01").setScale(2, RoundingMode.HALF_UP));
        assertEquals(expResult, result, ".10 is greater than .01.");
        result = instance.canAfford(new BigDecimal("1.00").setScale(2, RoundingMode.HALF_UP), new BigDecimal("0.00").setScale(2, RoundingMode.HALF_UP));
        assertEquals(expResult, result, "1.00 is greater than .00");
        result = instance.canAfford(new BigDecimal("10.00").setScale(2, RoundingMode.HALF_UP), new BigDecimal("10.00").setScale(2, RoundingMode.HALF_UP));
        assertEquals(expResult, result, "10.00 is equal to 10.00S");
    }

    /**
     * Test of coinToValue method, of class VendingServImpl.
     */
    @Test
    public void testCoinToValue() {
        System.out.println("coinToValue");
        CoinEnum coin = CoinEnum.PENNY;
        BigDecimal expResult = new BigDecimal(".01").setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = instance.coinToValue(coin);
        assertEquals(expResult, result);
        coin = CoinEnum.NICKEL;
        expResult = new BigDecimal(".05").setScale(2, RoundingMode.HALF_UP);
        result = instance.coinToValue(coin);
        assertEquals(expResult, result);
        coin = CoinEnum.DIME;
        expResult = new BigDecimal(".10").setScale(2, RoundingMode.HALF_UP);
        result = instance.coinToValue(coin);
        assertEquals(expResult, result);
        coin = CoinEnum.QUARTER;
        expResult = new BigDecimal(".25").setScale(2, RoundingMode.HALF_UP);
        result = instance.coinToValue(coin);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringDecoder method, of class VendingServImpl.
     */
    @Test
    public void testStringDecoder() {
        System.out.println("stringDecoder");
        List<String> inList = Arrays.asList("p","p","p","p","p","p","p","p","p","p","p","p","p","p","p","d","n","q");
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(inList);
        List<CoinEnum> enumList = Arrays.asList(CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,
                CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,
                CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.DIME,
                CoinEnum.NICKEL, CoinEnum.QUARTER);
        ArrayList<CoinEnum> expResult = new ArrayList<CoinEnum>();
        expResult.addAll(enumList);
        ArrayList<CoinEnum> result = instance.stringDecoder(list);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of coinListToValue method, of class VendingServImpl.
     */
    @Test
    public void testCoinListToValue() {
        System.out.println("coinListToValue");
         List<CoinEnum> enumList = Arrays.asList(CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,
                CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,
                CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.PENNY,CoinEnum.DIME,
                CoinEnum.NICKEL, CoinEnum.QUARTER);
        ArrayList<CoinEnum> coinList = new ArrayList<CoinEnum>();
        coinList.addAll(enumList);
        BigDecimal expResult = new BigDecimal(".55").setScale(2, RoundingMode.HALF_UP);
        BigDecimal result = instance.coinListToValue(coinList);
        assertEquals(expResult, result);
    }

    /**
     * Test of valueToCoinList method, of class VendingServImpl.
     */
    @Test
    public void testValueToCoinList() {
        System.out.println("valueToCoinList");
        int totalVal = 66;
        int[] expResult = new int[]{2, 3, 1, 1};
        int[] result = instance.valueToCoinList(totalVal);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of fetchString method, of class VendingServImpl.
     */
    @Test
    public void testFetchString() {
        System.out.println("fetchString");
        String type = "";
        VendingServImpl instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.fetchString(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processPurchase method, of class VendingServImpl.
     */
    @Test
    public void testProcessPurchase() {
        System.out.println("processPurchase");
        String name = "";
        BigDecimal moolah = null;
        VendingServImpl instance = null;
        boolean expResult = false;
        boolean result = instance.processPurchase(name, moolah);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processChange method, of class VendingServImpl.
     */
    @Test
    public void testProcessChange() {
        System.out.println("processChange");
        String choice = "";
        BigDecimal moolah = null;
        int[] expResult = null;
        int[] result = instance.processChange(choice, moolah);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
