package main.java;

import java.util.ArrayList;

public class BaseHero implements Person {
    private ArrayList<PowerInfo> allPowers;
    private String personType;
    private int hitpoints;
    
    public BaseHero() {
        this.allPowers = new ArrayList<>();
        this.personType = "Hero";
        this.hitpoints = 100;
    }
    
    
    
    
    @Override
    public String getPowersInfo() {
        if(allPowers.size() == 0) {
            return "[BASEHERO.getPowers()] Person Has No Powers. This shouldn't be a thing.";
        }
        
        String temp = "";
        
        for(int iter = 0; iter < allPowers.size(); iter++) {
            temp += "Power: " + allPowers.get(iter).getPower() + "  Level: " + allPowers.get(iter).getLevel() + "\n";
        }
        
        return temp;
    }



    @Override
    public void setPowerInfo(String string, int level) {
        //Look to see if the person contains the power already. If so, add the level
        for(int iter = 0; iter < allPowers.size(); iter++) {
            PowerInfo temp = allPowers.get(iter);
            if(temp.getPower().equals(string)) {
                temp.addLevel(level);
                return;
            }
        }
        
        
        allPowers.add(new PowerInfo(string, level));
        
    }
    
    @Override
    public String getPersonType() {
        return this.personType;
    }




    @Override
    public void damagePerson(int value) {
        this.hitpoints -= value;
        
    }


    @Override
    public int getHitpoints() {
        return this.hitpoints;
    }
    
    
    
}
