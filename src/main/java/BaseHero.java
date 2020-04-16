package main.java;

import java.util.ArrayList;

public class BaseHero implements Person {
    private ArrayList<String> allPowers;
    
    public BaseHero() {
        allPowers = new ArrayList<>();
    }
    
    
    
    
    @Override
    public String getPowers() {
        if(allPowers.size() == 0) {
            return "[BASEHERO.getPowers()] Person Has No Powers. This shouldn't be a thing.";
        }
        
        String temp = "";
        for(String iter : allPowers) {
            temp += iter;
        }
        return temp;
    }



    @Override
    public void setPower(String string) {
        allPowers.add(string);
        
    }
    
    
    
}
