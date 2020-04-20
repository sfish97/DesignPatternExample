package main.java.decorator;

import java.util.ArrayList;

public class Lava extends PersonDecorator {
    
    /**Constructor for Lava Power.
     * 
     * @param c The person who gets the power
     */
    public Lava(Person c) {
        super(c);
        super.setPowerInfo("Lava", 4);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
