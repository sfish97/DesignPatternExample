package main.java;

public class PersonDecorator implements Person {
    private Person person; 
    
    
    public PersonDecorator(Person c) {
        this.person = c;
    }
    
    public String getPowers() {
        return person.getPowers();
    }7

    public void setPower(String string) {
        person.setPower(string);
        
    }

}

class Fire extends PersonDecorator{
    public Fire(Person c) {
        super(c);
        giveFirePower();
    }
    
    public void giveFirePower() {
        super.setPower("Fire");
    }
    
    public String getPowers() {
        return super.getPowers();
    }
}
