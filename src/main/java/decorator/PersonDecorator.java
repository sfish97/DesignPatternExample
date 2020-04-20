package main.java.decorator;

import java.util.ArrayList;

public class PersonDecorator implements Person {
    private Person person;
    
    public PersonDecorator(Person c) {
        this.person = c;
    }
    
    @Override
    public ArrayList<PowerInfo> getPowersInfo() {
        return person.getPowersInfo();
    }

    @Override
    public void setPowerInfo(String string, int level) {
        person.setPowerInfo(string, level);
    }

    @Override
    public String getPersonType() {
        return person.getPersonType();
    } 
    
    @Override
    public void damagePerson(double value) {
        person.damagePerson(value);
        
    }


    @Override
    public double getHitpoints() {
        return person.getHitpoints();
    }
    
    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public void setIsResting() {
        // TODO Auto-generated method stub
        person.setIsResting();
    }

    @Override
    public boolean getIsResting() {
        // TODO Auto-generated method stub
        return person.getIsResting();
    }

    @Override
    public void resetHitpoints() {
        person.resetHitpoints();
        
    }
    
}


