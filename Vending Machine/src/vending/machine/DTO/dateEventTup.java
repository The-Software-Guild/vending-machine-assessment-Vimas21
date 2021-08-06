/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending.machine.DTO;

import java.time.LocalTime;

public class dateEventTup {
    
    LocalTime time;
    String event;
    
    public dateEventTup(LocalTime time, String event){
        this.time = time;
        this.event = event;
    }
    
    public LocalTime getTime(){
        return time;
    }
    
    public String getLog(){
        return event;
    }
    
}
