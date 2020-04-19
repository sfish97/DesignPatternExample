package main.java;

import java.util.ArrayList;
import java.util.Random;

import main.java.DecoratorPattern.Air;
import main.java.DecoratorPattern.BaseHero;
import main.java.DecoratorPattern.BaseVillian;
import main.java.DecoratorPattern.Earth;
import main.java.DecoratorPattern.Fire;
import main.java.DecoratorPattern.Lava;
import main.java.DecoratorPattern.Lightning;
import main.java.DecoratorPattern.Metal;
import main.java.DecoratorPattern.Person;
import main.java.DecoratorPattern.PowerInfo;
import main.java.DecoratorPattern.Water;
import main.java.StrategyPattern.BattleDecider;

public class Main {
      static String[]  city_names = {"Aberdeen", "Abilene", "Akron", "Albany", "Albuquerque", "Alexandria", "Allentown", "Amarillo", "Anaheim", "Anchorage", 
                      "Ann Arbor", "Antioch", "Apple Valley", "Appleton", "Arlington", "Arvada", "Asheville", "Athens", "Atlanta", "Atlantic City", 
                      "Augusta", "Aurora", "Austin", "Bakersfield", "Baltimore", "Barnstable", "Baton Rouge", "Beaumont", "Bel Air", "Bellevue", 
                      "Berkeley", "Bethlehem", "Billings", "Birmingham", "Bloomington", "Boise", "Boise City", "Bonita Springs", "Boston", "Boulder", 
                      "Bradenton", "Bremerton", "Bridgeport", "Brighton", "Brownsville", "Bryan", "Buffalo", "Burbank", "Burlington", "Cambridge", 
                      "Canton", "Cape Coral", "Carrollton", "Cary", "Cathedral City", "Cedar Rapids", "Champaign", "Chandler", "Charleston", "Charlotte",
                      "Chattanooga", "Chesapeake", "Chicago", "Chula Vista", "Cincinnati", "Clarke County", "Clarksville", "Clearwater", "Cleveland", "College Station", 
                      "Colorado Springs", "Columbia", "Columbus", "Concord", "Coral Springs", "Corona", "Corpus Christi", "Costa Mesa", "Dallas", "Daly City", "Danbury", 
                      "Davenport", "Davidson County", "Dayton", "Daytona Beach", "Deltona", "Denton", "Denver", "Des Moines", "Detroit", "Downey", "Duluth", "Durham", 
                      "El Monte", "El Paso", "Elizabeth", "Elk Grove", "Elkhart", "Erie", "Escondido", "Eugene", "Evansville", "Fairfield", "Fargo", "Fayetteville", 
                      "Fitchburg", "Flint", "Fontana", "Fort Collins", "Fort Lauderdale", "Fort Smith", "Fort Walton Beach", "Fort Wayne", "Fort Worth", "Frederick", 
                      "Fremont", "Fresno", "Fullerton", "Gainesville", "Garden Grove", "Garland", "Gastonia", "Gilbert", "Glendale", "Grand Prairie", "Grand Rapids", 
                      "Grayslake", "Green Bay", "GreenBay", "Greensboro", "Greenville", "Gulfport-Biloxi", "Hagerstown", "Hampton", "Harlingen", "Harrisburg", "Hartford",
                      "Havre de Grace", "Hayward", "Hemet", "Henderson", "Hesperia", "Hialeah", "Hickory", "High Point", "Hollywood", "Honolulu", "Houma", "Houston", 
                      "Howell", "Huntington", "Huntington Beach", "Huntsville", "Independence", "Indianapolis", "Inglewood", "Irvine", "Irving", "Jackson", "Jacksonville", 
                      "Jefferson", "Jersey City", "Johnson City", "Joliet", "Kailua", "Kalamazoo", "Kaneohe", "Kansas City", "Kennewick", "Kenosha", "Killeen", "Kissimmee", 
                      "Knoxville", "Lacey", "Lafayette", "Lake Charles", "Lakeland", "Lakewood", "Lancaster", "Lansing", "Laredo", "Las Cruces", "Las Vegas", "Layton", 
                      "Leominster", "Lewisville", "Lexington", "Lincoln", "Little Rock", "Long Beach", "Lorain", "Los Angeles", "Louisville", "Lowell", "Lubbock", "Macon", 
                      "Madison", "Manchester", "Marina", "Marysville", "McAllen", "McHenry", "Medford", "Melbourne", "Memphis", "Merced", "Mesa", "Mesquite", "Miami", 
                      "Milwaukee", "Minneapolis", "Miramar", "Mission Viejo", "Mobile", "Modesto", "Monroe", "Monterey", "Montgomery", "Moreno Valley", "Murfreesboro", 
                      "Murrieta", "Muskegon", "Myrtle Beach", "Naperville", "Naples", "Nashua", "Nashville", "New Bedford", "New Haven", "New London", "New Orleans",
                      "New York", "New York City", "Newark", "Newburgh", "Newport News", "Norfolk", "Normal", "Norman", "North Charleston", "North Las Vegas", "North Port",
                      "Norwalk", "Norwich", "Oakland", "Ocala", "Oceanside", "Odessa", "Ogden", "Oklahoma City", "Olathe", "Olympia", "Omaha", "Ontario", "Orange", "Orem",
                      "Orlando", "Overland Park", "Oxnard", "Palm Bay", "Palm Springs", "Palmdale", "Panama City", "Pasadena", "Paterson", "Pembroke Pines", "Pensacola", 
                      "Peoria", "Philadelphia", "Phoenix", "Pittsburgh", "Plano", "Pomona", "Pompano Beach", "Port Arthur", "Port Orange", "Port Saint Lucie", "Port St. Lucie",
                      "Portland", "Portsmouth", "Poughkeepsie", "Providence", "Provo", "Pueblo", "Punta Gorda", "Racine", "Raleigh", "Rancho Cucamonga", "Reading", "Redding",
                      "Reno", "Richland", "Richmond", "Richmond County", "Riverside", "Roanoke", "Rochester", "Rockford", "Roseville", "Round Lake Beach", "Sacramento", "Saginaw",
                      "Saint Louis", "Saint Paul", "Saint Petersburg", "Salem", "Salinas", "Salt Lake City", "San Antonio", "San Bernardino", "San Buenaventura", "San Diego",
                      "San Francisco", "San Jose", "Santa Ana", "Santa Barbara", "Santa Clara", "Santa Clarita", "Santa Cruz", "Santa Maria", "Santa Rosa", "Sarasota", "Savannah", 
                      "Scottsdale", "Scranton", "Seaside", "Seattle", "Sebastian", "Shreveport", "Simi Valley", "Sioux City", "Sioux Falls", "South Bend", "South Lyon", "Spartanburg",
                      "Spokane", "Springdale", "Springfield", "St. Louis", "St. Paul", "St. Petersburg", "Stamford", "Sterling Heights", "Stockton", "Sunnyvale", "Syracuse", 
                      "Tacoma", "Tallahassee", "Tampa", "Temecula", "Tempe", "Thornton", "Thousand Oaks", "Toledo", "Topeka", "Torrance", "Trenton", "Tucson", "Tulsa", "Tuscaloosa",
                      "Tyler", "Utica", "Vallejo", "Vancouver", "Vero Beach", "Victorville", "Virginia Beach", "Visalia", "Waco", "Warren", "Washington", "Waterbury", "Waterloo",
                      "West Covina", "West Valley City", "Westminster", "Wichita", "Wilmington", "Winston", "Winter Haven", "Worcester", "Yakima", "Yonkers", "York", "Youngstown"};
      
      static ArrayList<String> allCities = new ArrayList<>();
      
      static String[] powers = {"Water", "Fire", "Earth", "Air", "Lightning", "Metal", "Lava"};
      static ArrayList<Person> allPersons = new ArrayList<>();
      static ArrayList<Person> allHeroes = new ArrayList<>();
      static ArrayList<Person> allVillians = new ArrayList<>();
    
      
      
      
      public static void gameInitialize() {
          //Tick based: Initialize the world then: 
          Random rand = new Random();
          
          int heroValue = 1;
          int villianValue = 1;
          for(int x = 0; x < 20; x++) {
              Person h;
              
              //Chose a random number to determine if a villian or hero gets made
              int num = rand.nextInt((1 - 0) + 1) + 0;

              if(num == 1) {
                 h = new BaseHero(heroValue++);
                 allHeroes.add(h);
              }
              else {
                  h = new BaseVillian(villianValue++);
                  allVillians.add(h);
              }
              
              //Get the index of powers 2
              int index = rand.nextInt(((powers.length-1)) + 1);
              
              if(powers[index].equals("Water")) {
                  h = new Water(h);       
              }
              else if(powers[index].equals("Fire")) {
                  h = new Fire(h);  
              }
              else if(powers[index].equals("Earth")) {
                  h = new Earth(h);
              }
              else if(powers[index].equals("Air")){
                  h = new Air(h);
              }
              else if(powers[index].equals("Metal")) {
                  h = new Metal(h);  
              }
              else if(powers[index].equals("Lightning")) {
                  h = new Lightning(h);
              }
              else if(powers[index].equals("Lava")){
                  h = new Lava(h);
              }
              
              allPersons.add(h);
              
          }
          
          System.out.println("The World Has Been Initialized Randomly.\n There are " + allHeroes.size() + " Heroes and " + allVillians.size() + " Villians.");
          
          
//          for(Person p : allPersons) {
//              System.out.println("----Person----");
//              System.out.println("Person Type: " + p.getPersonType());
//              System.out.println("Person Name: " + p.getName());
//              System.out.println("Hitpoints: " + p.getHitpoints());
//              System.out.println(p.getPowersInfo() + "\n\n");
//          }
          
      }
      
      public static void battle() {
          Random rand = new Random();
          int day = 1;
          
          while(allHeroes.size() != 0 || allVillians.size() != 0) {
              Person hero = null;
              Person villian = null;
              int getHero;
              int getVillian;
              
              System.out.println("\nDay " + day);

              getHero = rand.nextInt(((allHeroes.size()-1)) + 1);
              getVillian = rand.nextInt(((allVillians.size()-1)) + 1); 


            
            
              hero = allHeroes.get(getHero);
              villian = allVillians.get(getVillian);
            
              BattleDecider test = new BattleDecider(hero, villian);
              Person winner = test.initBattle();
    
              if(winner == hero) {            
                  allVillians.remove(villian);
              }
              else {              
                  allHeroes.remove(hero);
              }
              
              if(allHeroes.size() == 0 || allVillians.size()==0) {
                  break;
              }
            
              day++;
            
          } 

      }
      
      
      public static void printWinner() {
          if(allHeroes.size() == 0) {
              System.out.println("\n\nTHE VILLIANS HAVE OVERTAKEN THE HEROES! THE WORLD IS NOW ENTERING A NEW AGE...OF DARKNESS");
          }
          
          if(allVillians.size() == 0) {
              System.out.println("\n\nALL THE VILLIANS HAVE BEEN DEFEATED! CHAOS AROUND THE WORLD IS FINALLY COMING TO A HALT. A NEW AGE OF LIGHT IS HERE");
          }
      }
      
      
      
      public static void main(String[] args) {
          gameInitialize();
          battle();
          printWinner();
  
      }
    

}
