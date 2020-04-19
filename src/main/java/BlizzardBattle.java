package main.java;

import java.util.Random;

public class BlizzardBattle implements Battles {
    
    private Person attacker1;
    private Person attacker2;
    
    public BlizzardBattle(Person hero, Person villian) {       
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
        boolean winner = false;
        double damage = 0;
        
        //START BATTLE
        
        //Get the attack full power.
        int attacker1Level = getAttackersLevel(attacker1);
        int attacker2Level = getAttackersLevel(attacker2);
        
        //START BATTLE
        //Attacker1 hits first, check health, Attacker 2 hits, check health
        
        System.out.println("\n------  BATTLE BETWEEN " + attacker1.getName() + " AND " + attacker2.getName() + " IN A BLIZZARD STORM!!!  ------");
        System.out.println(attacker1.getName() + " PowerInfo");
        
        for(PowerInfo pi : attacker1.getPowersInfo()) {
            System.out.println(pi.getPower() + "   " + pi.getLevel());
        }
        
        System.out.println("\n" + attacker2.getName() + " PowerInfo");
        
        for(PowerInfo pi : attacker2.getPowersInfo()) {
            System.out.println(pi.getPower() + "   " + pi.getLevel());
        }
        
        
        while(true) {
            //Attacker 1 Hits
            damage = getDamageAmount(attacker1Level);
            attacker2.damagePerson(damage);
            
            //System.out.println(attacker1.getName() + " hit " + attacker2.getName() + " for " + damage + " hitpoints!" + attacker2.getName() + " HAS " + attacker2.getHitpoints() + " LEFT!");
            
            winner = checkWinner(2);
            if(winner) {
                System.out.println("\nAND THE WINNER IS " + attacker1.getName() + " AND GAINS THE POWER OF THE DEFEATED!");
                System.out.println("------------------------------------------------------------------------");
                return attacker1;
            }
            
            //Attacker 2 Hits
            damage = getDamageAmount(attacker2Level);
            
            attacker1.damagePerson(damage);
            //System.out.println(attacker2.getName() + " hit " + attacker1.getName() + " for " + damage + " hitpoints!" + attacker1.getName() + " HAS " + attacker1.getHitpoints() + " LEFT!");
            
            winner = checkWinner(1);
            if(winner) {
                System.out.println("\nAND THE WINNER IS " + attacker2.getName() + " AND GAINS THE POWER OF THE DEFEATED!");
                System.out.println("------------------------------------------------------------------------");
                return attacker2;
            }
        }

    }
    
    public boolean checkWinner(int indicator) {
        if(indicator == 1) {
            if(attacker1.getHitpoints() <= 0) {
                return true;
            }
        }
        else {
            if(attacker2.getHitpoints() <= 0) {
                return true;
            }
        }
        
        return false;
    }

    
    //If the Person has Water power, their level is doubled. If the Person has Fire power, that power is cut to 1;
    public int getAttackersLevel(Person attacker) {
        int level = 0;
        
        for(PowerInfo iter : attacker.getPowersInfo()) {
            if(iter.getPower().equals("Water")) {
                level += iter.getLevel() * 2;
            }
            else if(iter.getPower().equals("Fire")){
                level += 1;
            }
            else {
                level += iter.getLevel();
            }
        }
        
        return level;
    }
    
    public double getDamageAmount(int attackerLevel) {
        Random rand = new Random();
        
        double dice1 = rand.nextInt((6-1) + 1) + 1;     //Dice roll 1-6
        double dice2 = rand.nextInt((6-1) + 1) + 1;     //Dice roll 1-6
       
        //Convert the dice to a decimal value: 6 --> .6
        double diceDecimal1 = dice1/10;
        double diceDecimal2 = dice2/10;
        
        double innerExponent = Math.pow(diceDecimal1, diceDecimal2);
        double damage = Math.pow(attackerLevel, innerExponent);
        
        return damage;
    }

}
