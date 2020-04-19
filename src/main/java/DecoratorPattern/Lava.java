package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Lava extends PersonDecorator {
    public Lava(Person c) {
        super(c);
        super.setPowerInfo("Lava", 4);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
