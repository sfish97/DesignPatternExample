package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Lava extends PersonDecorator {
    public Lava(Person c) {
        super(c);
        super.setPowerInfo("Lava", 4);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
