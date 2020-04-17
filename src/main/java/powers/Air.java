package main.java.powers;

import main.java.Person;
import main.java.PersonDecorator;

public class Air extends PersonDecorator {

    public Air(Person c) {
        super(c);
        super.setPowerInfo("Air", 2);
        
    }
        
    public String getPowersInfo() {
        return super.getPowersInfo();
    }

}
