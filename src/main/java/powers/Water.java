package main.java.powers;

import main.java.Person;
import main.java.PersonDecorator;

public class Water extends PersonDecorator {
    
    public Water(Person c) {
        super(c);
        super.setPowerInfo("Water", 2);
        
    }

    public String getPowersInfo() {
        return super.getPowersInfo();
    }
}
