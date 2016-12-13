package gdc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import gdc.ArmyKind;
import gdc.ArmyTruck;
import gdc.Soldier;
import gdc.Soldier.SoldierKind;

public class ArmyTruckTest {

	@Test
	public void testSpeed() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.AIR);
		assertEquals(armyTruck.speed(), 10);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testArmyTruckNone() {
		@SuppressWarnings("unused")
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.NONE);
	}
	
	@Test(expected = NullPointerException.class)
	public void testArmyTruckNull() {
		@SuppressWarnings("unused")
		ArmyTruck armyTruck = new ArmyTruck(null);
	}
	
	@Test
	public void testFireEmpty() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.GROUND);
		assertEquals(armyTruck.fire(), 0);
	}
	
	@Test
	public void testFire() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.GROUND);
		armyTruck.add(new Soldier(Soldier.SoldierKind.InfantryMan));
		armyTruck.add(new Soldier(Soldier.SoldierKind.FlameThrower));
		assertEquals(armyTruck.fire(), 70);
	}
	
	@Test
	public void testFireZero() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.GROUND);
		armyTruck.add(new Soldier(Soldier.SoldierKind.Marine));
		assertEquals(armyTruck.fire(), 0);
	}
	
	@Test
	public void testHealthEmpty() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.NAVY);
		assertEquals(armyTruck.health(), 0);
	}
	
	@Test
	public void testHealth() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.NAVY);
		armyTruck.add(new Soldier(SoldierKind.Marine));
		assertEquals(armyTruck.health(), new Soldier(SoldierKind.Marine).health());
	}
	
	@Test
	public void testHealthTwoSoldiers() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.NAVY);
		armyTruck.add(new Soldier(SoldierKind.Aviator));
		armyTruck.add(new Soldier(SoldierKind.Aviator));
		assertEquals(armyTruck.health(), new Soldier(SoldierKind.Aviator).health()*2);
	}
	
	@Test(expected = NullPointerException.class)
	public void addNull() {
		ArmyTruck armyTruck = new ArmyTruck(ArmyKind.AIR);
		armyTruck.add(null);
	}

}
