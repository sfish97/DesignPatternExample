package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Metal extends PersonDecorator {
    
    /**Constructor for Metal Power.
     * 
     * @param c The person who gets the power
     */
    public Metal(Person c) {
        super(c);
        super.setPowerInfo("Metal", 3);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
