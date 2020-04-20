package main.java.decorator;

import java.util.ArrayList;

public class Water extends PersonDecorator {
    
    /**Constructor for Water Power.
     * 
     * @param c The person who gets the power
     */
    public Water(Person c) {
        super(c);
        super.setPowerInfo("Water", 2);
        
    }

    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
