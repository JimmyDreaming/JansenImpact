public class Item {
  private final String name, effectType; //di ko ginawang subclasses yung different type of items... dapat ko bang gawin yun?
  private final int itemID, rarity, effectAmount, effectDuration;
  
  public Item(String n, String et, int iid, int r, int ea, int ed){ //all items are consumable
    name = n;
    effectType = et;
    itemID = iid;
    rarity = r;
    effectAmount = ea;
    effectDuration = ed;
  }
  
  public String getName(){
    return name;
  }
  public String getEffectType(){
    return effectType;
  }
  public int getItemID(){
    return itemID;
  }
  public int getRarity(){
    return rarity;
  }
  public int getEffectAmount(){
    return effectAmount;
  }
  public int getEffectDuration(){
    return effectDuration;
  }
}
