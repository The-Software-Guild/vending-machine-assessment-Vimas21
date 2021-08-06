/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine.DAO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vending.machine.DTO.FoodStuff;

/**
 *
 * @author Samma
 */
public class VendingDAOTest {
    
    public VendingDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of take method, of class VendingDAO.
     */
    @Test
    public void testTake() {
        System.out.println("take");
        String food = "";
        VendingDAO instance = new VendingDAOImpl();
        instance.take(food);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnFood method, of class VendingDAO.
     */
    @Test
    public void testReturnFood() {
        System.out.println("returnFood");
        String food = "";
        VendingDAO instance = new VendingDAOImpl();
        FoodStuff expResult = null;
        FoodStuff result = instance.returnFood(food);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of allKeys method, of class VendingDAO.
     */
    @Test
    public void testAllKeys() {
        System.out.println("allKeys");
        VendingDAO instance = new VendingDAOImpl();
        ArrayList expResult = null;
        ArrayList result = instance.allKeys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromFile method, of class VendingDAO.
     */
    @Test
    public void testFromFile() throws Exception {
        System.out.println("fromFile");
        VendingDAO instance = new VendingDAOImpl();
        instance.fromFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toFile method, of class VendingDAO.
     */
    @Test
    public void testToFile() throws Exception {
        System.out.println("toFile");
        VendingDAO instance = new VendingDAOImpl();
        instance.toFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCosts method, of class VendingDAO.
     */
    @Test
    public void testReturnCosts() {
        System.out.println("returnCosts");
        VendingDAO instance = new VendingDAOImpl();
        Stream<BigDecimal> expResult = null;
        Stream<BigDecimal> result = instance.returnCosts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnInventory method, of class VendingDAO.
     */
    @Test
    public void testReturnInventory() {
        System.out.println("returnInventory");
        VendingDAO instance = new VendingDAOImpl();
        ArrayList expResult = null;
        ArrayList result = instance.returnInventory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class VendingDAOImpl implements VendingDAO {

        public void take(String food) {
        }

        public FoodStuff returnFood(String food) {
            return null;
        }

        public ArrayList allKeys() {
            return null;
        }

        public void fromFile() throws FileNotFoundException {
        }

        public void toFile() throws IOException {
        }

        public Stream<BigDecimal> returnCosts() {
            return null;
        }

        public ArrayList returnInventory() {
            return null;
        }
    }
    
}
