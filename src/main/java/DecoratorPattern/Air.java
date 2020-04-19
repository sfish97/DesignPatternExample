package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Air extends PersonDecorator {

    public Air(Person c) {
        super(c);
        super.setPowerInfo("Air", 2);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }

}
