import java.util.ArrayList;

public class Character extends Unit{
    private final int charUUID;
    private static ArrayList<Character> characterList = new ArrayList<>();
    
    public Character(String n, int eid, int cuuid, int r, int l, int h, int a, int d, int ap, Weapon equip){
        super(n, eid, r, l, h, a, d, ap, equip);
        charUUID = cuuid;
        characterList.add(this);
    }
    public int getCharUUID(){
        return charUUID;
    }
    public static Character getCharacter(int id){
        return characterList.get(id);
    }
}
