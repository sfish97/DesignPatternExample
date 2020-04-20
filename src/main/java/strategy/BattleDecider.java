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
        Person winner = fight.battle();
        
        //Winner gets the defeated powers
        if (winner == hero) {
            
            for (PowerInfo pi : villian.getPowersInfo()) {
                winner.setPowerInfo(pi.getPower(), pi.getLevel());
            }
            
            return winner;
        } else {
            for (PowerInfo pi : hero.getPowersInfo()) {
                winner.setPowerInfo(pi.getPower(), pi.getLevel());
            }
          
            return winner;
        }

    }
    
}
