import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Weapon {
  private final String name;
  private final int rarity, weaponUUID;
  private int baseAtk, baseDef, baseAtkPrio;
  private Unit equipper;
  private static ArrayList<Weapon> weaponList = new ArrayList<>();
  
  public Weapon(String n, int r, int uuid, int a, int d, int ap){
    name = n;
    rarity = r;
    weaponUUID = uuid;
    baseAtk = a;
    baseDef = d;
    baseAtkPrio = ap;
    equipper = null;
    weaponList.add(this);
  }
  public Weapon(String n, int r, int uuid, int a, int d, int ap, Unit eq){
    name = n;
    rarity = r;
    weaponUUID = uuid;
    baseAtk = a;
    baseDef = d;
    baseAtkPrio = ap;
    equipper = eq;
    weaponList.add(this);
  }
  
  public String getName(){
    return name;
  }
  public int getRarity(){
    return rarity;
  }
  public int getWeaponUUID(){
    return weaponUUID;
  }
  public int getAtk(){
    return baseAtk;
  }
  public int getDef(){
    return baseDef;
  }
  public int getAtkPrio(){
    return baseAtkPrio;
  }
  public Unit getEquipper(){
    return equipper;
  }
  public static ArrayList<Weapon> getWeaponList(){
      return weaponList;
  }
  public void changeEquipper(Unit eq){
    equipper = eq;
  }
  
  public boolean isItEquipped(){
    if(equipper==null) return false;
    else return true;
  }
}
