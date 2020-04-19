package main.java.StrategyPattern;

import java.util.Random;

import main.java.DecoratorPattern.Person;
import main.java.DecoratorPattern.PowerInfo;

public class BattleDecider {
    private Battles fight;
    private Person hero;
    private Person villian;
    
    public BattleDecider(Person hero, Person villian) {
        this.hero = hero;
        this.villian = villian;
        
        chooseRandomBattle();
    }
    
    public void chooseRandomBattle() {
       
        Random rand = new Random();
        int num = rand.nextInt((1 - 0) + 1) + 0;
        
        if(num == 0) {
            setBattle(new BlizzardBattle(hero, villian));
        }
        else {
            setBattle(new HeatwaveBattle(hero, villian));
        }
    }
    
    public void setBattle(Battles battle) {
        this.fight = battle;
    }
    
    public Person initBattle() {
        Person winner = fight.battle();
        
        //Winner gets the defeated powers
        if(winner == hero) {
            
            for(PowerInfo pi : villian.getPowersInfo()) {
                winner.setPowerInfo(pi.getPower(), pi.getLevel());
            }
            
            return winner;
        }
        else {
            for(PowerInfo pi : hero.getPowersInfo()) {
                winner.setPowerInfo(pi.getPower(), pi.getLevel());
            }
          
            return winner;
        }

    }
    
}
