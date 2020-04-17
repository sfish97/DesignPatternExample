package main.java;

import java.util.ArrayList;

public class BaseVillian implements Person {
    private ArrayList<PowerInfo> allPowers;
    
    public BaseVillian() {
        allPowers = new ArrayList<>();
    }
    
    @Override
    public String getPowersInfo() {
        if(allPowers.size() == 0) {
            return "[BASEVILLIAN.getPowers()] Person Has No Powers. This shouldn't be a thing.";
        }
        
        String temp = "";
        
        for(int iter = 0; iter < allPowers.size(); iter++) {
            temp += allPowers.get(iter).getPower() + " ";
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

}
