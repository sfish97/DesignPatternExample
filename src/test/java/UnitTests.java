package test.java;

import static org.junit.Assert.assertEquals;

import main.java.decorator.Air;
import main.java.decorator.BaseHero;
import main.java.decorator.BaseVillain;
import main.java.decorator.Earth;
import main.java.decorator.Fire;
import main.java.decorator.Lava;
import main.java.decorator.Lightning;
import main.java.decorator.Metal;
import main.java.decorator.Person;
import main.java.decorator.Water;
import main.java.strategy.BattleDecider;
import main.java.strategy.BlizzardBattle;
import main.java.strategy.HeatwaveBattle;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;


public class UnitTests {
    
    Person waterHero = new BaseHero();
    Person fireHero = new BaseHero();
    Person earthHero = new BaseHero();
    Person airHero = new BaseHero();   
    Person lightningHero = new BaseHero();  
    Person metalHero = new BaseHero();  
    Person lavaHero = new BaseHero();
    
    Person waterVillian = new BaseVillain();
    Person fireVillian = new BaseVillain();
    Person earthVillian = new BaseVillain();
    Person airVillian = new BaseVillain();   
    Person lightningVillian = new BaseVillain();  
    Person metalVillian = new BaseVillain();  
    Person lavaVillian = new BaseVillain(); 
    
    
    /** Before a unit tests runs.
     * 
     * @throws Exception Any exception
     */
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
        //Add more water level to the heroes current water level
        waterHero.setPowerInfo("Water", 10);
        
        //Add more fire level to the villians current fire level
        fireVillian.setPowerInfo("Fire", 5);        
        
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
        //Create hero with a hero number of 1
        Person hero = new Water(new BaseHero(1)); 
        
        //Create villian with a villian number of 1
        Person villian = new Air(new BaseVillain(1));       
            
        //Checks to make sure the Person type and Number are combined correctly.
        assertEquals("Hero1", hero.getName());          
        assertEquals("Villain1", villian.getName());
  
    }

    @Test
    public void testBattleWinnerHasLosersPower() {
        BattleDecider decider1 = new BattleDecider(waterHero, waterVillian);
        decider1.setBattle(new BlizzardBattle(waterHero, waterVillian));
        
        BattleDecider decider2 = new BattleDecider(fireHero, fireVillian);
        decider2.setBattle(new HeatwaveBattle(fireHero, fireVillian));
        
        Person winner1 = decider1.initBattle();
        Person winner2 = decider2.initBattle();
        
        //Combining 2 base Water Level should give 4
        assertEquals(4, winner1.getPowersInfo().get(0).getLevel());
        
        //Combining 2 base Fire Levels should give 6
        assertEquals(6, winner2.getPowersInfo().get(0).getLevel());     
    }
    
     
}
