package main.java.powers;

import main.java.Person;
import main.java.PersonDecorator;

public class Air extends PersonDecorator {

    public Air(Person c) {
        super(c);
        giveAirPower();
        
    }
    
    public void giveAirPower() {
        super.setPower("Air");
    }
    
    public String getPowers() {
        return super.getPowers();
    }

}
