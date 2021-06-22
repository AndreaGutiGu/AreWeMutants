package com.rest.mutants.validators;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class DNAValidatorTest {

    /**
     * Validation of DNA with incorrect length elements 
     */
	@Test
	public void isValidTestNotValidLength()
	{
		String [] dna = {"AAAAAA", "CGGTGC", "TTAT", "AGTAAG", "GTTATA", "GCCCTG"};

		assertTrue(!DNAValidator.isValid(dna));
	}

    /**
     * Validation of DNA with incorrect elements 
     */
	@Test
	public void isValidTestNotValidElement()
	{
		String [] dna = {"AAAAAA", "CGxTGC", "TTATAA", "AGTAAG", "GTTATA", "GCCCTG"};

		assertTrue(!DNAValidator.isValid(dna));
	}

    /**
     * Validation of empty DNA  
     */
	@Test
	public void isValidTestEmptyDNA()
	{
		String [] dna = {};

		assertTrue(!DNAValidator.isValid(dna));
	}
	
    /**
     * Validation of Mutant DNA in row and \
     */
	@Test
	public void isMutantTrue()
	{
		String [] dna = {"ATGCGA", "CAGGGC", "TTGTCT","AGACGG","CCCCTA","TCACTG"};

		assertTrue(DNAValidator.isMutant(dna));
	}

    /**
     * Validation of Mutant DNA in column
     */
	@Test
	public void isMutantColumnTrue()
	{
		String [] dna = {"ATGC", "AAGG", "ATGT","AGGC"};

		assertTrue(DNAValidator.isMutant(dna));
	}

    /**
     * Validation of Human DNA 
     */
	@Test
	public void isMutantFalse()
	{
		String [] dna = {"ATGCA", "CAGGGA", "TTGTCT","AGACGG","CACCTA","TCACTG"};

		assertTrue(!DNAValidator.isMutant(dna));
	}
	
}

