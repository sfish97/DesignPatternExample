package main.java.decorator;

import java.util.ArrayList;

public interface Person {   
    public ArrayList<PowerInfo> getPowersInfo();
    
    public void setPowerInfo(String string, int level);
    
    public String getPersonType();
    
    public void damagePerson(double value);
    
    public double getHitpoints();
    
    public void resetHitpoints();
    
    public String getName();
    
    public void setIsResting();
    
    public boolean getIsResting();
}
