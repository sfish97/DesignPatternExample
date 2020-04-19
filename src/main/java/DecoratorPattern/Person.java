package main.java.DecoratorPattern;

import java.util.ArrayList;

public interface Person {   
    public ArrayList<PowerInfo> getPowersInfo();              //Get all the powers the person has
    public void setPowerInfo(String string, int level);
    public String getPersonType();
    public void damagePerson(double value);
    public double getHitpoints();
    public String getName();
    
}
