package main.java.strategy;

import java.util.Random;

import main.java.decorator.Person;
import main.java.decorator.PowerInfo;

public class HeatwaveBattle implements Battles {
    
    private Person attacker1;
    private Person attacker2;
    
    /** The Hero and Villian fight in a Heatwave.
     * 
     * @param hero      The hero
     * @param villian   The villian
     */
    public HeatwaveBattle(Person hero, Person villian) {       
        //Roll the dice to see who hits first
        Random rand = new Random();
        int num = rand.nextInt((1 - 0) + 1) + 0;
        if (num == 0) {
            this.attacker1 = hero;
            this.attacker2 = villian;
        } else {
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
        
        System.out.println("\n------  BATTLE BETWEEN " + attacker1.getName() 
                            + " AND " + attacker2.getName() + " IN A HEATWAVE!!!  ------");
        System.out.println(attacker1.getName() + " PowerInfo");
        
        for (PowerInfo pi : attacker1.getPowersInfo()) {
            System.out.println(pi.getPower() + "   " + pi.getLevel());
        }
        
        System.out.println("\n" + attacker2.getName() + " PowerInfo");
        
        for (PowerInfo pi : attacker2.getPowersInfo()) {
            System.out.println(pi.getPower() + "   " + pi.getLevel());
        }
        
        
        while (true) {
            //Attacker 1 Hits
            damage = getDamageAmount(attacker1Level);
            attacker2.damagePerson(damage);
            
            //System.out.println(attacker1.getName() + " hit " + attacker2.getName() + " for " 
            //                  + damage + " hitpoints!" + attacker2.getName() 
            //                  + " HAS " + attacker2.getHitpoints() + " LEFT!");
            
            winner = checkWinner(2);
            if (winner) {
                System.out.println("\nAND THE WINNER IS " + attacker1.getName() 
                                    + " AND GAINS THE POWER OF THE DEFEATED!");
                System.out.println("-------------------------------------------"
                                    + "-----------------------------\n");
                return attacker1;
            }
            
            //Attacker 2 Hits
            damage = getDamageAmount(attacker2Level);
            
            attacker1.damagePerson(damage);
            //System.out.println(attacker2.getName() + " hit " + attacker1.getName() + " for " \
            //                  + damage + " hitpoints!" + attacker1.getName() + " HAS " 
            //                  + attacker1.getHitpoints() + " LEFT!");
            
            winner = checkWinner(1);
            if (winner) {
                System.out.println("\nAND THE WINNER IS " + attacker2.getName() 
                                    + " AND GAINS THE POWER OF THE DEFEATED!");
                System.out.println("------------------------------------------"
                                    + "------------------------------\n");
                return attacker2;
            }
        }

    }
    
    /** Checks the hitpoints of the Person that got damaged.
     * 
     * @param indicator  To indicate if it was Attacker1 or Attacker2
     * @return           True or false if the Person is dead (has Zero hitpoints)
     */
    public boolean checkWinner(int indicator) {
        if (indicator == 1) {
            if (attacker1.getHitpoints() <= 0) {
                return true;
            }
        } else {
            if (attacker2.getHitpoints() <= 0) {
                return true;
            }
        }
        
        return false;
    }

    
    /** Look through the attacker Powers and Levels and adds them up
     *  Some powers are diminished or enhanced because its in a middle of  
     *  a Heatwave.
     * 
     * @param attacker  The attacker whose powers are getting looked at
     * @return          The real power that will be used during the fight
     * 
     */
    public int getAttackersLevel(Person attacker) {
        int level = 0;
        
        for (PowerInfo iter : attacker.getPowersInfo()) {
            String powerName = iter.getPower();
            
            if (powerName.equals("Water")) {             //Give 1 point for having a Water Level
                level += 1;
            } else if (powerName.equals("Fire")) {          //Double the Fire Level
                level += iter.getLevel() * 2;
            } else if (powerName.equals("Air")) {          //Air Level stays the same
                level += iter.getLevel();
            } else if (powerName.equals("Earth")) {        //Earth Level is diminished
                level += iter.getLevel() / 2;
            } else if (powerName.equals("Metal")) {        //Metal Level is diminished
                level += iter.getLevel() / 2;
            } else if (powerName.equals("Lava")) {         //Lava Level stays the same
                level += iter.getLevel();;
            } else if (powerName.equals("Lightning")) {    //Lightning Power is slightly diminshed 
                level += iter.getLevel() / 4;
            }

        }
        
        return level;
    }
    
    /** Rolls 2 dice and uses the Attackers level to determine
     *  how much damage is dealt.
     *  Equation:  Level^(Dice1^Dice2)
     *  To get a good damage output, Dice1 needs to be high, while
     *  Dice2 needs to be low. 
     * 
     * @param attackerLevel     The summation of the attackers power levels 
     * @return                  The damage the attacker did
     */
    public double getDamageAmount(int attackerLevel) {
        Random rand = new Random();
        
        double dice1 = rand.nextInt((6 - 1) + 1) + 1;     //Dice roll 1-6
        double dice2 = rand.nextInt((6 - 1) + 1) + 1;     //Dice roll 1-6
       
        //Convert the dice to a decimal value: 6 --> .6
        double diceDecimal1 = dice1 / 10;
        double diceDecimal2 = dice2 / 10;
        
        double innerExponent = Math.pow(diceDecimal1, diceDecimal2);
        double damage = Math.pow(attackerLevel, innerExponent);
        
        return damage;
    }

}
