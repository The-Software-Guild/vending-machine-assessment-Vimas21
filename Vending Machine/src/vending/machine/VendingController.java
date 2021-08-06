package vending.machine;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import vending.machine.DAO.VendingDAO;
import vending.machine.IO.VendingIO;
import vending.service.*;

/**
 * This is the boy who knows what's going on.
 * He's going to push things around to make sure everyone is doing what they should.
 * He's got a copy of the IO and the Serv and boy howdy he's gonna use em.
 */
public class VendingController{
    
    VendingIO io;
    VendingServ serv;
    
    public VendingController(VendingIO io, VendingDAO dao) throws FileNotFoundException{
        // Initialization. Here, we want to read in the file and prep the dao through service
        this.io = io;
        this.serv = new VendingServImpl(dao);
    }
    
    public void run(){
        // Main loop. Show the options, wait for coins to input.
        io.showAllItems(serv.fetchString("Names"), serv.fetchString("Costs"), serv.fetchString("Inventory"));
        
        // Okay, this is kind of an insane line here, so stick with me.
        // Input change gives us a string array list. StringDecoder changes that to a CoinEnum Arraylist, which we can then use.
        ArrayList change = serv.stringDecoder(io.inputChange());
        serv.processCoins(); // Just so we get an accurate audit list
        
        // Show them how much money they've got.
        io.print("You have input a total of " + serv.coinListToValue(change).toString() + ".");
        
        // Here's where we have them get their selection.
        String choice = io.takeOrder(serv.fetchString("Names"));
        
        // Process- can they buy it? And if they can, do it.
        // Nifty little trick- put it in the if statement to have it process AND return a bool. Saves a dead line.
        if(serv.processPurchase(choice, serv.coinListToValue(change)))
            // Show change, supposing we can.
            io.toChange(serv.processChange(choice, serv.coinListToValue(change)));
        else{
            io.print("Purchase could not be completed.");
        }
        // End step- Save our new files.
        serv.endStep();
        
        
        
    }
    
}
