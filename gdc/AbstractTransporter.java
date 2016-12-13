package gdc;

import java.util.ArrayList;
import java.util.Objects;

abstract class AbstractTransporter<T> {

	private final ArrayList<T> transportables;
	private final ArmyKind army;
	
	public AbstractTransporter(ArmyKind army){
		this.army = Objects.requireNonNull(army);
		if(army.equals(ArmyKind.NONE)){
			throw new IllegalArgumentException("ArmyKind is NONE");
		}
		this.transportables = new ArrayList<>();
	}
	
	/* (non-Javadoc)
	 * @see gdc.Unit#speed()
	 */
	public int speed() {
		// TODO Auto-generated method stub
		return 10;
	}

	/* (non-Javadoc)
	 * @see gdc.Unit#fire()
	 */
	public int fire() {
		// TODO Auto-generated method stub
		return transportables
				.stream()
				.filter(soldier -> soldier.army() == army)
				.mapToInt(Transportable::fire)
				.sum();
	}

	/* (non-Javadoc)
	 * @see gdc.Unit#health()
	 */
	public int health() {
		// TODO Auto-generated method stub
		return transportables.stream().mapToInt(Transportable::health).sum();
	}

	public void add(Soldier soldier) {
		// TODO Auto-generated method stub
		Objects.requireNonNull(soldier);
		transportables.add(soldier);
	}

}
