/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine.DAO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import vending.machine.DTO.dateEventTup;

public class VendingAuditImpl implements VendingAudit{

    public VendingAuditImpl(){
        auditList.add(new dateEventTup(LocalTime.now(), "Audit Startup."));
    }
    
    public void addChangeInserted() {
        auditList.add(new dateEventTup(LocalTime.now(), "Change Inserted."));
    }

    @Override
    public void addButtonsPushed() {
        auditList.add(new dateEventTup(LocalTime.now(), "Selection Made."));
    }

    @Override
    public void addVended(boolean succeeded) {
        if(succeeded)
            auditList.add(new dateEventTup(LocalTime.now(), "Item Succesfully Vended."));
        else
            auditList.add(new dateEventTup(LocalTime.now(), "Item Vending Unsuccesful- not enough change."));
    }

    @Override
    public void addChangeGiven() {
        auditList.add(new dateEventTup(LocalTime.now(), "Change Returned."));
    }
    
    public void endStep() throws IOException{
        auditList.add(new dateEventTup(LocalTime.now(), "Audit Closed."));
        PrintWriter out = new PrintWriter(new FileWriter("VendingAudit.txt"));
        for(int i = 0; i < auditList.size(); i++){
           out.println(auditList.get(i).getTime() + " | " + auditList.get(i).getLog());
        }
        out.flush();
        out.close();
    }

    @Override
    public void addNoMoney() {
        auditList.add(new dateEventTup(LocalTime.now(), "Purchase failed, insufficient funds."));
    }

    @Override
    public void addNoStock() {
        auditList.add(new dateEventTup(LocalTime.now(), "Purchase failed, item out of stock."));
    }
    
}
