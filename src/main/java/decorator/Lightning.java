package main.java.decorator;

import java.util.ArrayList;

public class Lightning extends PersonDecorator {
    
    /**Constructor for Lightning Power.
     * 
     * @param c The person who gets the power
     */
    public Lightning(Person c) {
        super(c);
        super.setPowerInfo("Lightning", 4);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
