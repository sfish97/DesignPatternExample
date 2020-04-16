package main.java;

public class PersonDecorator implements Person {
    private Person person; 
    
    
    public PersonDecorator(Person c) {
        this.person = c;
    }
    
    public String getPowers() {
        return person.getPowers();
    }

    public void setPower(String string) {
        person.setPower(string);
        
    }

}


