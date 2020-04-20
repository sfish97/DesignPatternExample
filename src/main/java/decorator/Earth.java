package main.java.decorator;

import java.util.ArrayList;

public class Earth extends PersonDecorator {
    
    /**Constructor for Earth Power.
     * 
     * @param c The person who gets the power
     */
    public Earth(Person c) {
        super(c);
        super.setPowerInfo("Earth", 2);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
