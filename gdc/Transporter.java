package gdc;

public class Transporter extends AbstractTransporter<Transportable> implements Unit{
	
	private Transporter(ArmyKind armyKind){
		super(armyKind);
	}
	
	public static Transporter createDestroyer(){
		return new Transporter(ArmyKind.NAVY);
	}
	
	public static Transporter aircraftCarrier(){
		return new Transporter(ArmyKind.AIR);
	}

}
