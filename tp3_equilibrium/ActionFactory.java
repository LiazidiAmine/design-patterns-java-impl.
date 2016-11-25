package tp3_equilibrium;

public class ActionFactory {
	public static Action createMonster(int damage){
		requireValidBounds(damage, 1, 5);
		return (player, other) -> other.beingHit(damage);
	}
	
	public static Action createLigntning(int damage){
		if(damage != 2 && damage != 4){
			throw new IllegalArgumentException("damage not authorized "+damage);
		}
		return (player, other) -> {
			other.beingHit(damage);
			player.beingHit(damage / 2);
		};
	}
	
	private static int requireValidBounds(int value, int min, int max) {
		if (value < min || value > max) {
			throw new IllegalArgumentException("" + value);
		}
		return value;
	}

}
