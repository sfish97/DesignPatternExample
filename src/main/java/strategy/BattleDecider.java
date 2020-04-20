package main.java.strategy;

import java.util.Random;

import main.java.decorator.Person;
import main.java.decorator.PowerInfo;

public class BattleDecider {
    private Battles fight;
    private Person hero;
    private Person villian;
    
    /** Constructor when a Battle needs to happen.
     * 
     * @param hero  The hero 
     * @param villian   The villian
     */
    public BattleDecider(Person hero, Person villian) {
        this.hero = hero;
        this.villian = villian;

        chooseRandomBattle();
    }
    
    /** Chooses a random battle.
     * 
     */
    public void chooseRandomBattle() {
       
        Random rand = new Random();
        int num = rand.nextInt((1 - 0) + 1) + 0;
        
        if (num == 0) {
            setBattle(new BlizzardBattle(hero, villian));
        } else {
            setBattle(new HeatwaveBattle(hero, villian));
        }
    }
    
    public void setBattle(Battles battle) {
        this.fight = battle;
    }
    
    /** This will make the hero and villian fight and after the battle.
     *  the winner gets the losers power
     * 
     * @return The winner of the fight
     */
    public Person initBattle() {
        Person winner;
        
        //Checks if the hero/villian is resting
        // If their both resting, the hero wins
        if (hero.getIsResting() && !villian.getIsResting()) {
            winner = villian;
            
            System.out.println(villian.getName() + " ATTACKED " + hero.getName() 
                                + " WHILE HE WAS RESTING! THE HERO WAS KILLED INSTANTLY");
            
        } else if (!hero.getIsResting() && villian.getIsResting()) {
            winner = hero;
            
            System.out.println(hero.getName() + " ATTACKED " + villian.getName() 
                                + " WHILE HE WAS RESTING! THE VILLIAN HAS BEEN ELIMINATED");
            
        } else if (hero.getIsResting() && villian.getIsResting()) {
            winner = hero;
            
            System.out.println(hero.getName() + " AND " + villian.getName() + " WERE BOTH RESTING "
                                + "IN THE PARK UNTIL THEY STUMBLED UPON EACH OTHER! "
                                + "THE HERO TOOK THE UPPER HAND AND DEFEATED THE VILLIAN");
        } else {
            winner = fight.battle();
        }
        
        //Winner gets the defeated powers
        if (winner == hero) {
            
            for (PowerInfo pi : villian.getPowersInfo()) {
                winner.setPowerInfo(pi.getPower(), pi.getLevel());
            }
            
            winner.setIsResting();  //The winner starts resting
            return winner;
        } else {
            for (PowerInfo pi : hero.getPowersInfo()) {
                winner.setPowerInfo(pi.getPower(), pi.getLevel());
            }
            
            winner.setIsResting(); //The winner start resting
            return winner;
        }

    }
    
}
