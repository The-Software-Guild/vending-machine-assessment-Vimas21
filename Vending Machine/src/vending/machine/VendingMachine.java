
package vending.machine;

import java.io.FileNotFoundException;
import vending.machine.DAO.*;
import vending.machine.IO.*;

/**
 *
 * @author Samma
 */
public class VendingMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        VendingDAO dao = new VendingDAOImp("VendingInven.txt");
        VendingIO io = new VendingConsoleIOImpl();
        VendingController cont = new VendingController(io, dao);
        cont.run();
    }
    
}
