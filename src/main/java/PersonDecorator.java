package main.java;

public class PersonDecorator implements Person {
    private Person person; 
    
    
    public PersonDecorator(Person c) {
        this.person = c;
    }
    
    public String getPowersInfo() {
        return person.getPowersInfo();
    }

    public void setPowerInfo(String string, int level) {
        person.setPowerInfo(string, level);
        
    }
    
    

}


