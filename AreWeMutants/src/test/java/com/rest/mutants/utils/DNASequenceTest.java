package com.rest.mutants.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class DNASequenceTest {
	
	@Test
	public void setterTest(){
		DNASequence sequence = new DNASequence();

		String[] dna = {"A", "B", "C"};
		sequence.setDna(dna);

		assertTrue(sequence.getDna().length == 3);
	}
	
	@Test
	public void toStringTest(){
		DNASequence sequence = new DNASequence();

		String[] dna = {"A", "B", "C"};
		sequence.setDna(dna);

		assertTrue(sequence.toString().equals("A|B|C|"));
	}
	
	@Test
	public void equalsTestTrue() {
		DNASequence sequence1 = new DNASequence();
		DNASequence sequence2 = new DNASequence();

		String[] dna = {"A", "B", "C"};
		sequence1.setDna(dna);
		sequence2.setDna(dna);
		
		assertTrue(sequence1.equals(sequence2));
	}

	@Test
	public void equalsTestFalse() {
		DNASequence sequence1 = new DNASequence();
		DNASequence sequence2 = new DNASequence();

		String[] dna1 = {"A", "B", "C"};
		sequence1.setDna(dna1);
		
		String[] dna2 = {"A", "B"};
		sequence2.setDna(dna2);
		
		assertTrue(!sequence1.equals(sequence2));
	}
}
