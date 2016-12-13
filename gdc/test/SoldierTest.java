package gdc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import gdc.ArmyKind;
import gdc.Soldier;

public class SoldierTest {

	@Test(expected = NullPointerException.class)
	public void testNullKind() {
		@SuppressWarnings("unused")
		Soldier soldier = new Soldier(null);
	}
	
	@Test
	public void testSpeed() {
		assertEquals(
				new Soldier(Soldier.SoldierKind.Medic).speed(), 2);
		assertEquals(
				new Soldier(Soldier.SoldierKind.InfantryMan).speed(),3);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Marine).speed(),3);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Aviator).speed(),3);
		assertEquals(
				new Soldier(Soldier.SoldierKind.FlameThrower).speed(),2);
	}

	@Test
	public void testHealth() {
		assertEquals(
				new Soldier(Soldier.SoldierKind.Medic).health(), 10);
		assertEquals(
				new Soldier(Soldier.SoldierKind.InfantryMan).health(),20);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Marine).health(),20);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Aviator).health(),20);
		assertEquals(
				new Soldier(Soldier.SoldierKind.FlameThrower).health(),20);
	}

	@Test
	public void testFire() {
		assertEquals(
				new Soldier(Soldier.SoldierKind.Medic).fire(), 0);
		assertEquals(
				new Soldier(Soldier.SoldierKind.InfantryMan).fire(),30);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Marine).fire(),30);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Aviator).fire(),10);
		assertEquals(
				new Soldier(Soldier.SoldierKind.FlameThrower).fire(),40);
	}
	
	@Test
	public void testArmyKind(){
		assertEquals(
				new Soldier(Soldier.SoldierKind.Medic).army(), ArmyKind.NONE);
		assertEquals(
				new Soldier(Soldier.SoldierKind.InfantryMan).army(),ArmyKind.GROUND);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Marine).army(),ArmyKind.NAVY);
		assertEquals(
				new Soldier(Soldier.SoldierKind.Aviator).army(),ArmyKind.AIR);
		assertEquals(
				new Soldier(Soldier.SoldierKind.FlameThrower).army(),ArmyKind.GROUND);
	}

}
