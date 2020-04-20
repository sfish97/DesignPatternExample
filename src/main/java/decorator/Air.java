package main.java.decorator;

import java.util.ArrayList;

public class Air extends PersonDecorator {
    
    /**Constructor for Air Power.
     * 
     * @param c The person who gets the power
     */
    public Air(Person c) {
        super(c);
        super.setPowerInfo("Air", 2);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }

}
