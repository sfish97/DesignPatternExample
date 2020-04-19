package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Water extends PersonDecorator {
    
    public Water(Person c) {
        super(c);
        super.setPowerInfo("Water", 2);
        
    }

    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
