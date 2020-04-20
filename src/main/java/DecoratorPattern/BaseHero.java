package main.java.DecoratorPattern;

import java.util.ArrayList;

public class BaseHero implements Person {
    private ArrayList<PowerInfo> allPowers;
    private String personType;
    private double hitpoints;
    private String name;
    
    /** Base Constructor that doesnt give a unique hero name.
     * 
     */
    public BaseHero() {
        this.allPowers = new ArrayList<>();
        this.personType = "Hero";
        this.hitpoints = 100;
    }
    
    /**Constructor that takes in a number and appends.
     *  it to the Heroes name so each hero is unique
     * 
     * @param heroNumber The Heros number
     */
    public BaseHero(int heroNumber) {
        this.allPowers = new ArrayList<>();
        this.personType = "Hero";
        this.hitpoints = 100;
        this.name = "Hero" + heroNumber;
    }
    
    
    
    @Override
    public ArrayList<PowerInfo> getPowersInfo() {
        if (allPowers.size() == 0) {
            System.out.println("[BASEHERO.getPowers()] Person Has No Powers."
                    + " This shouldn't be a thing.");
            System.exit(0);
        }
              
        return allPowers;
    }



    @Override
    public void setPowerInfo(String string, int level) {
        //Look to see if the person contains the power already. If so, add the level
        for (int iter = 0; iter < allPowers.size(); iter++) {
            PowerInfo temp = allPowers.get(iter);
            if (temp.getPower().equals(string)) {
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
