package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Lightning extends PersonDecorator {
    public Lightning(Person c) {
        super(c);
        super.setPowerInfo("Lightning", 4);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
