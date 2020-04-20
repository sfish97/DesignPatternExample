package main.java;

import java.util.ArrayList;
import java.util.Random;

import main.java.decorator.Air;
import main.java.decorator.BaseHero;
import main.java.decorator.BaseVillian;
import main.java.decorator.Earth;
import main.java.decorator.Fire;
import main.java.decorator.Lava;
import main.java.decorator.Lightning;
import main.java.decorator.Metal;
import main.java.decorator.Person;
import main.java.decorator.PowerInfo;
import main.java.decorator.Water;
import main.java.strategy.BattleDecider;

public class Main {
   
    static String[] powers = {"Water", "Fire", "Earth", "Air", "Lightning", "Metal", "Lava"};
    static ArrayList<Person> allPersons = new ArrayList<>();
    static ArrayList<Person> allHeroes = new ArrayList<>();
    static ArrayList<Person> allVillians = new ArrayList<>();
    static int heroValue = 1;
    static int villianValue = 1;
      
    /** Initialize the game world by created a random number of
     *  heroes and villians. Then give each hero/villian 1 Random Power
     * 
     */
    public static void gameInitialize() {
        //Tick based: Initialize the world then: 
        Random rand = new Random();

        for (int x = 0; x < 20; x++) {
            Person h;
              
            //Chose a random number to determine if a villian or hero gets made
            int num = rand.nextInt((1 - 0) + 1) + 0;

            if (num == 1) {
                h = new BaseHero(heroValue++);
                allHeroes.add(h);
            } else {
                h = new BaseVillian(villianValue++);
                allVillians.add(h);
            }
              
            //Get a random index from the array of powers to give to the hero/villian
            int index = rand.nextInt(((powers.length - 1)) + 1);
              
            if (powers[index].equals("Water")) {
                h = new Water(h);       
            } else if (powers[index].equals("Fire")) {
                h = new Fire(h);  
            } else if (powers[index].equals("Earth")) {
                h = new Earth(h);
            } else if (powers[index].equals("Air")) {
                h = new Air(h);
            } else if (powers[index].equals("Metal")) {
                h = new Metal(h);  
            } else if (powers[index].equals("Lightning")) {
                h = new Lightning(h);
            } else if (powers[index].equals("Lava")) {
                h = new Lava(h);
            }
              
            allPersons.add(h);
            
        }
          
        System.out.println("The World Has Been Initialized Randomly.");
        System.out.println("There are " + allHeroes.size() + " Heroes and " 
                            + allVillians.size() + " Villians.");
                
          
          
        //for(Person p : allPersons) {
        //System.out.println("----Person----");
        //System.out.println("Person Type: " + p.getPersonType());
        //System.out.println("Person Name: " + p.getName());
        //System.out.println("Hitpoints: " + p.getHitpoints());
        //System.out.println(p.getPowersInfo() + "\n\n");}
          
    }
    
    /** Battle function that chooses 1 random hero/villian
     *  and makes them fight with in a random Battle.
     * 
     */
    public static void battle() {
        Random rand = new Random();
        int day = 1;
        int daysUntilEvoulution = 5;
        int timeEvoulutionHappened = 1;
        
        while (allHeroes.size() != 0 || allVillians.size() != 0) {
            System.out.println("\nDay " + day);
            
            //If Harmonic Evoulution is here, create new heroes and villians
            if (daysUntilEvoulution == 0) {
                System.out.println("HARMONIC EVOULUTION IS HERE.");
                
                harmonicEvoulution();
                
                day++;          
                timeEvoulutionHappened++;      
                daysUntilEvoulution = 5 * timeEvoulutionHappened;
                continue;
            }
            
            
            //Select a hero and villian. Will try 5 times to get a pair where both are NOT RESTING
            // On the last try, it will just grab whoever and put them up against each other.
            int getHero;
            int getVillian;
            Person hero = selectPerson(0);
            Person villian = selectPerson(1);

          
            //Have the two battle it out
            BattleDecider test = new BattleDecider(hero, villian);
            Person winner = test.initBattle();
            
            //Check who the winner is and remove the loser
            if (winner == hero) {            
                allVillians.remove(villian);
            } else {              
                allHeroes.remove(hero);
            }
              
            //Check if all heroes/villians have been defeated
            if (allHeroes.size() == 0 || allVillians.size() == 0) {
                break;
            }
            
            //Every 4 days, heal the resting
            if(day % 4 == 0) {
                healRested();
            }
            
            //Increase the Day and decrease the days until Evoulution
            day++;
            daysUntilEvoulution--;
        } 
    
    }
      
    public static Person selectPerson(int indicator) {
        Random rand = new Random();
        
        Person person = null;
        int index;
        
        for (int tries = 0; tries < 4; tries++) {
            
            if (indicator == 0) {
                index = rand.nextInt(((allHeroes.size() - 1)) + 1);   
                
                //If its on the last try to match a hero and villian, then make them fight
                if (tries == 3) {
                    return allHeroes.get(index);
                }
                
                person = allHeroes.get(index);
                
                if (person.getIsResting()) {
                    person = null;
                    continue;
                }
        
                return person;
                
            } else {
                index = rand.nextInt(((allVillians.size() - 1)) + 1);   
                
                //If its on the last try to match a hero and villian, then make them fight
                if (tries == 3) {
                    return allVillians.get(index); 
                }
                
                person = allVillians.get(index);
                
                if (person.getIsResting()) {
                    person = null;
                    continue;
                }
        
                return person;
            }
        }
        
        return person;
    }
    
    public static void healRested() {
        
        for (Person p : allPersons) {
            if(p.getIsResting()) {
                p.resetHitpoints();
                p.setIsResting();
            }
        }
        
    }
    
    /** Harmonic Evoulution is a way new Heroes and Villians appear
     *  As of now, random amount of people become Heroes and get a base power
     *  Random amount of Villians are made but their a direct clone
     *  of a random villian. Each new villian will inherit all powers 
     *  of the "parent" but the power level will be at base level.
     * 
     */
    public static void harmonicEvoulution() {
        Random rand = new Random();
        
        //Select a random number of new heroes from 5-10
        int amount = rand.nextInt((10 - 5) + 1) + 5;
        
        System.out.println(amount + " NEW HEROES HAVE JOINED THE FIGHT AGAINST THE VILLIANS");
        
        for (int iter = 0; iter < amount; iter++) {
            Person newHero = new BaseHero(heroValue++);
            
            //Select a random power for the Hero
            int index = rand.nextInt(((powers.length - 1)) + 1);
            
            if (powers[index].equals("Water")) {
                newHero = new Water(newHero);       
            } else if (powers[index].equals("Fire")) {
                newHero = new Fire(newHero);  
            } else if (powers[index].equals("Earth")) {
                newHero = new Earth(newHero);
            } else if (powers[index].equals("Air")) {
                newHero = new Air(newHero);
            } else if (powers[index].equals("Metal")) {
                newHero = new Metal(newHero);  
            } else if (powers[index].equals("Lightning")) {
                newHero = new Lightning(newHero);
            } else if (powers[index].equals("Lava")) {
                newHero = new Lava(newHero);
            }
              
            allHeroes.add(newHero);
            allPersons.add(newHero);
        }
        
        //Select a random number of villians to create from 5-10
        amount = rand.nextInt((10 - 5) + 1) + 5;
        System.out.println(amount + " NEW VILLIAN HAVE JOINED THE FIGHT TO DEFEAT THE HEROES");
        
        //For every new villian, grab a random villian inside the ArrayList and copy all 
        // its powers, but each power starts at base level
        for (int iter = 0; iter < amount; iter++) {
            Person newVillian = new BaseVillian(villianValue++);
            
            int index = rand.nextInt(((allVillians.size() - 1)) + 1);
            
            for (PowerInfo pi : allVillians.get(index).getPowersInfo()) {
                if (pi.getPower().equals("Water")) {
                    newVillian = new Water(newVillian);       
                } else if (pi.getPower().equals("Fire")) {
                    newVillian = new Fire(newVillian);  
                } else if (pi.getPower().equals("Earth")) {
                    newVillian = new Earth(newVillian);
                } else if (pi.getPower().equals("Air")) {
                    newVillian = new Air(newVillian);
                } else if (pi.getPower().equals("Metal")) {
                    newVillian = new Metal(newVillian);  
                } else if (pi.getPower().equals("Lightning")) {
                    newVillian = new Lightning(newVillian);
                } else if (pi.getPower().equals("Lava")) {
                    newVillian = new Lava(newVillian);
                }
            }
            
            allVillians.add(newVillian);
            allPersons.add(newVillian);
    
        }
        
    }
    
    /** Print out who won. Either the Heroes for a New Age of Light
     *  Or the Villians, who bring a New Age of Darkness
     * 
     */
    public static void printWinner() {
        if (allHeroes.size() == 0) {
            System.out.println("\n\nTHE VILLIANS HAVE OVERTAKEN THE HEROES! "
                    + "THE WORLD IS NOW ENTERING A NEW AGE...OF DARKNESS");
        }
          
        if (allVillians.size() == 0) {
            System.out.println("\n\nALL THE VILLIANS HAVE BEEN DEFEATED! CHAOS AROUND THE WORLD "
                    + "IS FINALLY COMING TO A HALT. A NEW AGE OF LIGHT IS HERE");
        }
    }
      
      
    /** Main Function that Initializes the game with heroes/villians
    * Then battles all the heroes/villians until one group is defeated
    * Lastly it will print the winner.
    * 
    * @param args If any arugments get passed
    */
    public static void main(String[] args) {
        
        
        gameInitialize();
        battle();
        printWinner();
  
    }
    

}
