package main.java;

public class PersonDecorator implements Person {
    private Person person;
    
    public PersonDecorator(Person c) {
        this.person = c;
    }
    
    @Override
    public String getPowersInfo() {
        return person.getPowersInfo();
    }

    @Override
    public void setPowerInfo(String string, int level) {
        person.setPowerInfo(string, level);
    }

    @Override
    public String getPersonType() {
        return person.getPersonType();
    } 
    
    @Override
    public void damagePerson(int value) {
        person.damagePerson(value);
        
    }


    @Override
    public int getHitpoints() {
        return person.getHitpoints();
    }
    
    @Override
    public String getName() {
        return person.getName();
    }
    
}


