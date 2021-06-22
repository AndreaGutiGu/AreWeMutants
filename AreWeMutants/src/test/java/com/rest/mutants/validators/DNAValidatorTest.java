package com.rest.mutants.validators;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DNAValidatorTest {
	@Test
	public void isValidTestNotValidLength()
	{
		String [] dna = {"AAAAAA", "CGGTGC", "TTAT", "AGTAAG", "GTTATA", "GCCCTG"};

		assertTrue(!DNAValidator.isValid(dna));
	}

	@Test
	public void isValidTestNotValidElement()
	{
		String [] dna = {"AAAAAA", "CGxTGC", "TTATAA", "AGTAAG", "GTTATA", "GCCCTG"};

		assertTrue(!DNAValidator.isValid(dna));
	}

	@Test
	public void isValidTestEmptyDNA()
	{
		String [] dna = {};

		assertTrue(!DNAValidator.isValid(dna));
	}
	
	@Test
	public void isMutantTrue()
	{
		String [] dna = {"ATGCGA", "CAGGGC", "TTGTCT","AGACGG","CCCCTA","TCACTG"};

		assertTrue(DNAValidator.isMutant(dna));
	}

	@Test
	public void isMutantColumnTrue()
	{
		String [] dna = {"ATGCT", "AAGGG", "ATGTG","AGACG","GGACG"};

		assertTrue(DNAValidator.isMutant(dna));
	}

	@Test
	public void isMutantFalse()
	{
		String [] dna = {"ATGCA", "CAGGGA", "TTGTCT","AGACGG","CACCTA","TCACTG"};

		assertTrue(!DNAValidator.isMutant(dna));
	}
	
}

