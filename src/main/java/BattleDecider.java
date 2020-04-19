package main.java;

import java.util.Random;

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
        setBattle(new BlizzardBattle(hero, villian));
        
//        Random rand = new Random();
//        int num = rand.nextInt((1 - 0) + 1) + 0;
//        
//        if(num == 0) {
//            setBattle(new BlizzardBattle(hero, villian));
//        }
//        else {
//            setBattle(new MeteorShowerBattle(hero, villian));
//        }
    }
    
    public void setBattle(Battles battle) {
        this.fight = battle;
    }
    
    public Person initBattle() {
        return fight.battle();
    }
    
}
