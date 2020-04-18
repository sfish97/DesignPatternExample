package main.java;


public interface Person {   
    public String getPowersInfo();              //Get all the powers the person has
    public void setPowerInfo(String string, int level);
    public String getPersonType();
    public void damagePerson(int value);
    public int getHitpoints();
    public String getName();
    
}
