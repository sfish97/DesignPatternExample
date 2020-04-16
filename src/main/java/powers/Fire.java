package main.java.powers;

import main.java.Person;
import main.java.PersonDecorator;

public class Fire extends PersonDecorator{
    public Fire(Person c) {
        super(c);
        giveFirePower();
    }
    
    public void giveFirePower() {
        super.setPower("Fire");
    }
    
    public String getPowers() {
        return super.getPowers();
    }
}