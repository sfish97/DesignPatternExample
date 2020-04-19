package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Lightning extends PersonDecorator {
    public Lightning(Person c) {
        super(c);
        super.setPowerInfo("Lightning", 4);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}
