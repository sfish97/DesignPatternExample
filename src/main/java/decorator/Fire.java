package main.java.decorator;

import java.util.ArrayList;

public class Fire extends PersonDecorator {
    
    /**Constructor for Fire Power.
     * 
     * @param c The person who gets the power
     */
    public Fire(Person c) {
        super(c);
        super.setPowerInfo("Fire", 3);

    }
       
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}