package main.java;

public class PowerInfo{
    private String power;
    private int level;
    
    public PowerInfo(String power, int level) {
        this.power = power;
        this.level = level;
    }
    
    public String getPower() {
        return power;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void addLevel(int amount) {
        level += amount;
    }
    
}
