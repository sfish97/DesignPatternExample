package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Metal extends PersonDecorator {
    
    public Metal(Person c) {
        super(c);
        super.setPowerInfo("Metal", 3);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
