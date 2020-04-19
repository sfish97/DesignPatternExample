package main.java;

import java.util.Random;

public class MeteorShowerBattle implements Battles {
    
    Person attacker1;
    Person attacker2;
    
    public MeteorShowerBattle(Person hero, Person villian) {
        System.out.println("Meteor Shower Battle");
        
        //Roll the dice to see who hits first
        Random rand = new Random();
        int num = rand.nextInt((1 - 0) + 1) + 0;
        if(num == 0) {
            this.attacker1 = hero;
            this.attacker2 = villian;
        }
        else {
            this.attacker1 = villian;
            this.attacker2 = hero;
        }
    }

    @Override
    public Person battle() {
        return null;
    }

}
