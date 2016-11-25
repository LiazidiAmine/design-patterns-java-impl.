package tp3_equilibrium;

public class Monster implements Action {
	private final int damage;

	public Monster(int damage) {
		this.damage = requireValidBounds(damage, 1, 5);
	}

	private static int requireValidBounds(int value, int min, int max) {
		if (value < min || value > max) {
			throw new IllegalArgumentException("" + value);
		}
		return value;
	}
	
	@Override
	public void apply(Player player, Player other) {
		other.beingHit(damage);
	}
	
	public int getDamage() {
		return damage;
	}
}
