import java.util.ArrayList;

public class Player {
  private final String name;
  private int level, gems;
  private ArrayList<Weapon> armory = new ArrayList<>();
  private ArrayList<Item> inventory = new ArrayList<>();
  private ArrayList<Character> charList = new ArrayList<>();
  private static ArrayList<Player> playerList = new ArrayList<>();
  private static ArrayList<String> playerNameList = new ArrayList<>();
  
  public Player(String n){
    name = n;
    level = 1;
    gems = 5;
    playerList.add(this);
    playerNameList.add(name);
  }
  public Player(String n, int id){
    name = n;
    level = 1;
    gems = 5;
    playerList.add(this);
    playerNameList.add(name);
    Character starter = Character.getCharacter(id);
    charList.add(starter);
  }
  
  public String getName(){
    return name;
  }
  public int getlevel(){
    return level;
  }
  public int getGems(){
    return gems;
  }
  public ArrayList<Weapon> getArmory(){
    return armory;
  }
  public ArrayList<Item> getInventory(){
    return inventory;
  }
  public ArrayList<Character> getCharList(){
    return charList;
  }
  public static ArrayList<Player> getPlayerList(){
    return playerList;
  }
  public static ArrayList<String> getPlayerNameList(){
    return playerNameList;
  }
  
  public static Player changePlayer(String n){
      int idx = playerNameList.indexOf(n);
      return Player.playerList.get(idx);
  }
  public static Player createPlayer(String n) throws ExistingPlayerException{
      int idx = playerNameList.indexOf(n);
      if(idx==-1){
          new Player(n);
          int latest = Player.getPlayerList().size() - 1;
          return Player.getPlayerList().get(latest);
      }
      else throw new ExistingPlayerException(n + " is already an existing Player.");
  }
  /*
  public void useItem(Item item, Unit unit){
    //check if item is in inventory and if unit is in unitList; if either one of them is not in their respective ArrayLists, then the method is halted via custom Exception
    inventory.remove(item);
    if(item.getEffectType() == "heal")  unit.getHP() *= item.getEffectAmount();
    else if(item.getEffectType() == "atk boost") unit.atk *= item.getEffectAmount(); //item.getEffectDuration is also checked in battle
    else if(item.getEffectType() == "def boost")  unit.getDef() *= item.getEffectAmount();
    else if(item.getEffectType() == "atkPrio boost")  unit.getatkPrio() *= item.getEffectAmount(); // I still have to make sure the stats can be reverted before using the item
  } // this method is still incomplete pero this is not really needed pa for 3rd quarter proposal. so that's fine
  */
  public void onePull(){
    if(gems>0){
      //does some RNG shit I don't know how to implement... help me Jansen lol
      gems--;
    }
    else {}//throw new InsufficientGemsException("Insufficient gems to pull.";
  }
}
