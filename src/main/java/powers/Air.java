package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Air extends PersonDecorator {

    public Air(Person c) {
        super(c);
        super.setPowerInfo("Air", 2);
        
    }
        
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }

}
