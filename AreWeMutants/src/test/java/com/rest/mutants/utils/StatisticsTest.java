package com.rest.mutants.utils;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class StatisticsTest {
	
	@Test
	public void constructorTest(){
		Statistics stats = new Statistics(10, 5, (float) 3);
		
		assertTrue(stats.getCount_human_dna() == 5
				&& stats.getCount_mutant_dna() == 10
				&& stats.getRatio() == 3);
	}

	@Test
	public void settersTest(){
		Statistics stats = new Statistics(0,0,(float) 0);
		
		stats.setCount_human_dna(5);
		stats.setCount_mutant_dna(10);
		stats.setRatio((float) 3);
		
		assertTrue(stats.getCount_human_dna() == 5
				&& stats.getCount_mutant_dna() == 10
				&& stats.getRatio() == 3);
	}
}
