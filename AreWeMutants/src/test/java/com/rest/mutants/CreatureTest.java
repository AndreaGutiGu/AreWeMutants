package com.rest.mutants;


import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class CreatureTest {

	@Test
	public void equalsTestTrue() {
		Creature creature_1 = new Creature("ABCD", "XXX");
		Creature creature_2 = new Creature("ABCD", "XXX");
		
		assertTrue(creature_2.equals(creature_1));
	}

	@Test
	public void equalsTestSame() {
		Creature creature_1 = new Creature("ABCD", "XXX");
		
		assertTrue(creature_1.equals(creature_1));
	}

	@Test
	public void equalsTestOtherObject() {
		Creature creature_1 = new Creature("ABCD", "XXX");
		
		assertTrue(creature_1.equals(new String()));
	}

	@Test
	public void equalsTestFalse() {
		Creature creature_1 = new Creature("UUUU", "XXX");
		Creature creature_2 = new Creature("ABCD", "XXX");
		
		assertTrue(!creature_2.equals(creature_1));
	}
}
