package test.java;




import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.DecoratorPattern.Air;
import main.java.DecoratorPattern.BaseHero;
import main.java.DecoratorPattern.BaseVillian;
import main.java.DecoratorPattern.Earth;
import main.java.DecoratorPattern.Fire;
import main.java.DecoratorPattern.Lava;
import main.java.DecoratorPattern.Lightning;
import main.java.DecoratorPattern.Metal;
import main.java.DecoratorPattern.Person;
import main.java.DecoratorPattern.Water;
import main.java.StrategyPattern.BattleDecider;
import main.java.StrategyPattern.BlizzardBattle;
import main.java.StrategyPattern.HeatwaveBattle;

public class UnitTests {
    
    Person waterHero = new BaseHero();
    Person fireHero = new BaseHero();
    Person earthHero = new BaseHero();
    Person airHero = new BaseHero();   
    Person lightningHero = new BaseHero();  
    Person metalHero = new BaseHero();  
    Person lavaHero = new BaseHero();
    
    Person waterVillian = new BaseVillian();
    Person fireVillian = new BaseVillian();
    Person earthVillian = new BaseVillian();
    Person airVillian = new BaseVillian();   
    Person lightningVillian = new BaseVillian();  
    Person metalVillian = new BaseVillian();  
    Person lavaVillian = new BaseVillian(); 
    
    @Before
    public void setUp() throws Exception {
        //Initialize an array with all the powers
        waterHero = new Water(waterHero);
        fireHero = new Fire(fireHero);
        earthHero = new Earth(earthHero);
        airHero = new Air(airHero);
        lightningHero = new Lightning(lightningHero);
        metalHero = new Metal(metalHero);
        lavaHero = new Lava(lavaHero);
    
        waterVillian = new Water(waterVillian);
        fireVillian = new Fire(fireVillian);
        earthVillian = new Earth(earthVillian);
        airVillian = new Air(airVillian);
        lightningVillian = new Lightning(lightningVillian);
        metalVillian = new Metal(metalVillian);
        lavaVillian = new Lava(lavaVillian);
    }
    
    @After
    public void tearDown() throws Exception {

    }
    
    //Create a person for each type of power
    @Test
    public void testIndividualPowers() {
        //Tests to make sure each hero created has thier respective power
        assertEquals("Water", waterHero.getPowersInfo().get(0).getPower());
        assertEquals("Fire", fireHero.getPowersInfo().get(0).getPower());
        assertEquals("Earth", earthHero.getPowersInfo().get(0).getPower());
        assertEquals("Air", airHero.getPowersInfo().get(0).getPower());
        assertEquals("Lightning", lightningHero.getPowersInfo().get(0).getPower());
        assertEquals("Metal", metalHero.getPowersInfo().get(0).getPower());
        assertEquals("Lava", lavaHero.getPowersInfo().get(0).getPower());
        
        //Tests to make sure each villian created has their respective power
        assertEquals("Water", waterVillian.getPowersInfo().get(0).getPower());
        assertEquals("Fire", fireVillian.getPowersInfo().get(0).getPower());
        assertEquals("Earth", earthVillian.getPowersInfo().get(0).getPower());
        assertEquals("Air", airVillian.getPowersInfo().get(0).getPower());
        assertEquals("Lightning", lightningVillian.getPowersInfo().get(0).getPower());
        assertEquals("Metal", metalVillian.getPowersInfo().get(0).getPower());
        assertEquals("Lava", lavaVillian.getPowersInfo().get(0).getPower());
    }
    
    @Test
    public void testCombinePowers() {
        waterHero.setPowerInfo("Water", 10);        //Add more water level to the heroes current water level
        fireVillian.setPowerInfo("Fire", 5);        //Add more fire level to the villians current fire level
        
        assertEquals(12, waterHero.getPowersInfo().get(0).getLevel(), .01);
        assertEquals(8, fireVillian.getPowersInfo().get(0).getLevel(), .01);
    }
    
    
    @Test
    public void testDamage() {
    
        waterHero.damagePerson(1);          //Damage the hero for 1 point of damage
        fireVillian.damagePerson(100);      //Damage the villian for 100 hitpoints
        
        assertEquals(99, waterHero.getHitpoints(), .01);       
        assertEquals(0, fireVillian.getHitpoints(), .01);
    }
    
    @Test
    public void testName() {
        Person hero = new Water(new BaseHero(1));           //Create hero with a hero number of 1
        Person villian = new Air(new BaseVillian(1));       //Create villian with a villian number of 1
            
        //Checks to make sure the Person type and Number are combined correctly.
        assertEquals("Hero1", hero.getName());          
        assertEquals("Villian1", villian.getName());
  
    }

    @Test
    public void testBattleWinnerHasLosersPower() {
        BattleDecider decider1 = new BattleDecider(waterHero, waterVillian);
        decider1.setBattle(new BlizzardBattle(waterHero, waterVillian));
        
        BattleDecider decider2 = new BattleDecider(fireHero, fireVillian);
        decider2.setBattle(new HeatwaveBattle(fireHero, fireVillian));
        
        Person winner1 = decider1.initBattle();
        Person winner2 = decider2.initBattle();
        
        assertEquals(4, winner1.getPowersInfo().get(0).getLevel());     //Combining 2 base Water Level should give 4
        assertEquals(6, winner2.getPowersInfo().get(0).getLevel());     //Combining 2 base Fire Levels should give 6
    }
    
     
}
