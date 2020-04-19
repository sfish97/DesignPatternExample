package main.java.powers;

import java.util.ArrayList;

import main.java.Person;
import main.java.PersonDecorator;
import main.java.PowerInfo;

public class Fire extends PersonDecorator{
    
    public Fire(Person c) {
        super(c);
        super.setPowerInfo("Fire", 3);

    }
       
    public ArrayList<PowerInfo> getPowersInfo() {
        return super.getPowersInfo();
    }
}