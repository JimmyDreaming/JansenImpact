public class Main {
    public static void main(String[] args) {
        new Weapon("Basic dagger", 1, 0, 15, 5, 10);
        new Weapon("Basic sword", 1, 0, 10, 10, 10);
        new Weapon("Basic gun", 1, 0, 10, 5, 15);
        new Weapon("Basuc shield", 1, 0, 5, 10, 5);
        
        Unit dummy1 = new Unit("Dummy Boss 1", 1000, 0, 1, 720, 60, 60, 60, Weapon.getWeaponList().get(3));
        Unit.addEnemy(dummy1);
        
        new Character("Aaron the Silent Vanquisher", 0, 0, 3, 1, 360, 70, 50, 60, Weapon.getWeaponList().get(0));
        new Character("Serge the Heroic Swordsman", 0, 1, 3, 1, 360, 60, 70, 55, Weapon.getWeaponList().get(1));
        new Character("Xyrus the Quickdrawer", 0, 2, 3, 1, 360, 55, 55, 70, Weapon.getWeaponList().get(2));
        
        new Player("JimmyDreaming", 0);
        new Player("Jansen4269", 1);
        new Player("Xx_Shirou_xX", 2);
        
        new HomeScreenGUI(Player.getPlayerList().get(0));
    }
}
