package com.rest.mutants.creature;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CreatureTest {
	
    /**
     * Validates the empty constructor and set methods
     */
	@Test
	public void emptyConstructorTest() {
		Creature creature = new Creature();
		
		creature.setDnaSequence("ABC");
		creature.setCreatureClass("ZZZ");
		
		assertTrue(creature.getDnaSequence().equals("ABC") && creature.getCreatureClass().equals("ZZZ"));
	}

    /**
     * Validates equality for two objects with the same contents
     */
	@Test
	public void equalsTestTrue() {
		Creature creature_1 = new Creature("ABCD", "XXX");
		Creature creature_2 = new Creature("ABCD", "XXX");
		
		assertTrue(creature_2.equals(creature_1));
	}

    /**
     * Validates equality for the same object
     */
	@Test
	public void equalsTestSame() {
		Creature creature_1 = new Creature("ABCD", "XXX");
		
		assertTrue(creature_1.equals(creature_1));
	}

    /**
     * Validates equality for a Creature and an object with a different class
     */
	@Test
	public void equalsTestOtherObject() {
		Creature creature_1 = new Creature("ABCD", "XXX");
		
		assertTrue(!creature_1.equals(new String()));
	}

    /**
     * Validates equality for objects with different DNA
     */
	@Test
	public void equalsTestFalseSameClass() {
		Creature creature_1 = new Creature("UUUU", "XXX");
		Creature creature_2 = new Creature("ABCD", "XXX");
		
		assertTrue(!creature_2.equals(creature_1));
	}

    /**
     * Validates equality objects with different creature class
     */
	@Test
	public void equalsTestFalseDifferentClass() {
		Creature creature_1 = new Creature("UUUU", "XXX");
		Creature creature_2 = new Creature("UUUU", "YYY");
		
		assertTrue(!creature_2.equals(creature_1));
	}

}
