package main.java.powers;

import main.java.Person;
import main.java.PersonDecorator;

public class Fire extends PersonDecorator{
    public Fire(Person c) {
        super(c);
        super.setPowerInfo("Fire", 3);

    }
       
    public String getPowersInfo() {
        return super.getPowersInfo();
    }
}