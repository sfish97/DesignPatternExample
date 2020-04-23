package main.java.strategy;

import java.util.Random;

import main.java.decorator.Person;
import main.java.decorator.PowerInfo;

public class BattleDecider {
    private Battles fight;
    private Person hero;
    private Person villain;
    
    /** Constructor when a Battle needs to happen.
     * 
     * @param hero  The hero 
     * @param villain   The villian
     */
    public BattleDecider(Person hero, Person villain) {
        this.hero = hero;
        this.villain = villain;

        chooseRandomBattle();
    }
    
    /** Chooses a random battle.
     * 
     */
    public void chooseRandomBattle() {
       
        Random rand = new Random();
        int num = rand.nextInt((2 - 0) + 2) + 0;
        
        if (num == 0) {
            setBattle(new BlizzardBattle(hero, villain));
        } else if(num == 1) {
            setBattle(new HeatwaveBattle(hero, villain));
        } else {
            setBattle(new SolarEclipseBattle(hero, villain));
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
        if (hero.getIsResting() && !villain.getIsResting()) {
            winner = villain;
            
            System.out.println(villain.getName() + " ATTACKED " + hero.getName() 
                                + " WHILE HE WAS RESTING! THE HERO WAS KILLED INSTANTLY");
            
        } else if (!hero.getIsResting() && villain.getIsResting()) {
            winner = hero;
            
            System.out.println(hero.getName() + " ATTACKED " + villain.getName() 
                                + " WHILE HE WAS RESTING! THE VILLIAN HAS BEEN ELIMINATED");
            
        } else if (hero.getIsResting() && villain.getIsResting()) {
            winner = hero;
            
            System.out.println(hero.getName() + " AND " + villain.getName() + " WERE BOTH RESTING "
                                + "IN THE PARK UNTIL THEY STUMBLED UPON EACH OTHER! "
                                + "THE HERO TOOK THE UPPER HAND AND DEFEATED THE VILLIAN");
        } else {
            winner = fight.battle();
        }
        
        //Winner gets the defeated powers
        if (winner == hero) {
            
            for (PowerInfo pi : villain.getPowersInfo()) {
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
