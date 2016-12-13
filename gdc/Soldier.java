package gdc;

public class Soldier implements Unit, Transportable {
    public enum SoldierKind {
      InfantryMan  (30, 3, 20, ArmyKind.GROUND), 
      Medic        (0,  2, 10, ArmyKind.NONE),
      Marine       (30, 3, 20, ArmyKind.NAVY),
      Aviator      (10, 3, 20, ArmyKind.AIR),
      FlameThrower (40, 2, 20, ArmyKind.GROUND),
      ;
      
      final int fire;
      final int speed;
      final int health;
      final ArmyKind armyKind;
      
      private SoldierKind(int fire,int speed, int health, ArmyKind army){
        this.fire = fire;
        this.speed = speed;
        this.health = health;
        this.armyKind = army;
      }
    }
    
    private final SoldierKind kind;
    private int health;
    
    public Soldier(SoldierKind kind){
      this.health = kind.health;  // implicit null check
      this.kind = kind;
    }
    
    public int speed() {
      return kind.speed;
    }
    
    public int health() {
      return health;
    }
    
    public int fire() {
      return kind.fire;
    }
    
    public SoldierKind kind() {
      return kind;
    }
    
    public ArmyKind army(){
    	return kind.armyKind;
    }
    
    @Override
    public String toString() {
      return kind.name();
    }
  }