package main.java.powers;

import main.java.Person;
import main.java.PersonDecorator;

public class Water extends PersonDecorator {
    
    public Water(Person c) {
        super(c);
        giveWaterPower();
        
    }
    
    public void giveWaterPower() {
        super.setPower("Water");
    }
    
    public String getPowers() {
        return super.getPowers();
    }
}
