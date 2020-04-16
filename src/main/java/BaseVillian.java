package main.java;

import java.util.ArrayList;

public class BaseVillian implements Person {
    private ArrayList<String> allPowers;
    
    public BaseVillian() {
        allPowers = new ArrayList<>();
    }
    
    @Override
    public String getPowers() {
        if(allPowers.size() == 0) {
            return "[BASEVILLAN.getPowers()] Person Has No Powers. This shouldn't be a thing.";
        }
        
        return allPowers.toArray().toString();
    }

    @Override
    public void setPower(String string) {
        allPowers.add(string);
        
    }

}
