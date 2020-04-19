package main.java.DecoratorPattern;

import java.util.ArrayList;

public class Fire extends PersonDecorator{
    
    public Fire(Person c) {
        super(c);
        super.setPowerInfo("Fire", 3);

    }
       
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}