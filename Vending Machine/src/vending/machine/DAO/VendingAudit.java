package vending.machine.DAO;
import java.io.IOException;
import java.time.*;
import java.util.ArrayList;
import vending.machine.DTO.dateEventTup;
/**
 * This interface will be responsible for:
 * Keeping track of every interaction that happened between the user and the vending machine, at what time.
 * This includes:
 * Inserting money.
 * Buying something.
 * Being unable to buy something.
 * Getting your change.
 */
public interface VendingAudit {
    ArrayList<dateEventTup> auditList = new ArrayList<dateEventTup>();
    
    public void addChangeInserted();
    
    public void addButtonsPushed();
    
    public void addVended(boolean succeeded);
    
    public void addNoMoney();
    
    public void addNoStock();
    
    public void addChangeGiven();
    
    public void endStep() throws IOException;
    
}
