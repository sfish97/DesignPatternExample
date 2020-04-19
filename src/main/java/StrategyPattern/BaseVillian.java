package main.java.StrategyPattern;

import java.util.ArrayList;

import main.java.DecoratorPattern.Person;
import main.java.DecoratorPattern.PowerInfo;

public class BaseVillian implements Person {
    private ArrayList<PowerInfo> allPowers;
    private String personType;
    private double hitpoints;
    private String name;
    
    public BaseVillian() {
        this.allPowers = new ArrayList<>();
        this.personType = "Villian";
        this.hitpoints = 100;
    }
    
    public BaseVillian(int villianNumber) {
        this.allPowers = new ArrayList<>();
        this.personType = "Villian";
        this.hitpoints = 100;
        this.name = "Villian" + villianNumber;
    }
    
    @Override
    public ArrayList<PowerInfo> getPowersInfo() {
        if(allPowers.size() == 0) {
            System.out.println( "[BASEVILLIAN.getPowers()] Person Has No Powers. This shouldn't be a thing.");
            System.exit(0);
        }
              
        return allPowers;
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
    public void damagePerson(double value) {
        this.hitpoints -= value;
        
    }


    @Override
    public double getHitpoints() {
        return this.hitpoints;
    }
    
    @Override
    public String getName() {
        return name;
    }

}
