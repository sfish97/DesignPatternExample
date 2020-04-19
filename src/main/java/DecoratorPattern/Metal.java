package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Metal extends PersonDecorator {
    
    public Metal(Person c) {
        super(c);
        super.setPowerInfo("Metal", 3);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
