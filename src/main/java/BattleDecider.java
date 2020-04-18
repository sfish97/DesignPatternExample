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
        initBattle();
    }
    
    public void chooseRandomBattle() {
        Random rand = new Random();
        int num = rand.nextInt((1 - 0) + 1) + 0;
        
        if(num == 0) {
            setBattle(new BlizzardBattle());
        }
        else {
            setBattle(new MeteorShowerBattle());
        }
    }
    
    public void setBattle(Battles battle) {
        this.fight = battle;
    }
    
    public void initBattle() {
        fight.battle(hero, villian);
    }
    
}
