package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Water extends PersonDecorator {
    
    public Water(Person c) {
        super(c);
        super.setPowerInfo("Water", 2);
        
    }

    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
