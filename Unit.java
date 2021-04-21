import java.util.ArrayList;

public class Unit{ //superclass, can stand for mobs and playable characters (the latter is in a subclass)
  private final String name;
  private final int elementID, rarity;
  private int level, maxHP, hp, atk, def, atkPrio;
  private Weapon equippedWeapon;
  private static ArrayList<Unit> enemyList = new ArrayList<>();

  public Unit(String n, int eid, int r, int l, int h, int a, int d, int ap, Weapon equip){ 
    name = n;
    elementID = eid;
    rarity = r;
    level = l;
    maxHP = h;
    hp = h;
    atk = a;
    def = d;
    atkPrio = ap;
    equippedWeapon = equip;
  }
  
  public String getName(){
    return name;
  }
  public int getElementID(){
    return elementID;
  }
  public int getRarity(){
    return rarity;
  }
  public int getLevel(){
    return level;
  }
  public int getMaxHP(){
    return maxHP;
  }
  public int getHP(){
    return hp;
  }
  public int getAtk(){
    return atk;
  }
  public int getDef(){
    return def;
  }
  public int getAtkPrio(){
    return atkPrio;
  }
  public Weapon getEquippedWeapon(){
    return equippedWeapon;
  }
  public static ArrayList<Unit> getEnemyList(){
    return enemyList;
  }

  public static void addEnemy(Unit e){
    enemyList.add(e);
  } 
  public void restoreHP(){
    hp = maxHP;
  }
  
  public void changeWeapon(Weapon wpon){
    equippedWeapon.changeEquipper(null);
    equippedWeapon = wpon;
    wpon.changeEquipper(this);
  }
  
  public void attack(Unit enemy){
    int unitAtk = atk + equippedWeapon.getAtk();
    int unitAtkPrio = atkPrio + equippedWeapon.getAtkPrio();
    int enemyDef = enemy.getDef() + enemy.getEquippedWeapon().getDef();
    int enemyAtkPrio = enemy.getAtkPrio() + enemy.getEquippedWeapon().getAtkPrio();
    
    int damage = (int) ((10 + level*0.5 + 0.2*(level - enemy.getLevel())) * ((unitAtk/enemyDef) + 0.5*(unitAtkPrio/enemyAtkPrio))) ;
    enemy.hp -= damage;
    System.out.println(name + " dealt " + damage + " damage to " + enemy.getName() + ". " + enemy.getHP() + "HP left.");
    if(enemy.getHP() <= 0){
      hp = 0;
      System.out.println(enemy.getName() + " has been defeated.");
    }
  }
}
