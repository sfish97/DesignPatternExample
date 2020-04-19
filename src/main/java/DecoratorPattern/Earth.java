package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Earth extends PersonDecorator {
    
    public Earth(Person c) {
        super(c);
        super.setPowerInfo("Earth", 2);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
