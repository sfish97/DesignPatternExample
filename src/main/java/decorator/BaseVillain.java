package main.java.decorator;

import java.util.ArrayList;

public class BaseVillain implements Person {
    private ArrayList<PowerInfo> allPowers;
    private String personType;
    private double hitpoints;
    private String name;
    private boolean isResting;
    
    /** Base constructor that doesnt give a name.
     * 
     */
    public BaseVillain() {
        this.allPowers = new ArrayList<>();
        this.personType = "Villain";
        this.hitpoints = 100;
        this.isResting = false;
    }
    
    /** Constructor to give the villain a name based on the number.
     * 
     * @param villainNumber  The Number the villain gets
     */
    public BaseVillain(int villainNumber) {
        this.allPowers = new ArrayList<>();
        this.personType = "Villain";
        this.hitpoints = 100;
        this.name = "Villain" + villainNumber;
        this.isResting = false;
    }
    
    @Override
    public ArrayList<PowerInfo> getPowersInfo() {
        if (allPowers.size() == 0) {
            System.out.println("[BASEVILLAIN.getPowers()] Person Has No Powers. "
                    + "This shouldn't be a thing.");
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
        return this.name;
    }

    @Override
    public void setIsResting() {
        this.isResting = !this.isResting;
        
    }

    @Override
    public boolean getIsResting() {
        // TODO Auto-generated method stub
        return this.isResting;
    }

    @Override
    public void resetHitpoints() {
        this.hitpoints = 100.0;
        
    }

}
