package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Earth extends PersonDecorator {
    
    public Earth(Person c) {
        super(c);
        super.setPowerInfo("Earth", 2);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
