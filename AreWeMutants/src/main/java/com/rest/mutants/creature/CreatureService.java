package com.rest.mutants.creature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.mutants.utils.DNASequence;
import com.rest.mutants.utils.Statistics;
import com.rest.mutants.validators.DNAValidator;

@Service
public class CreatureService {
	
	@Autowired
	private CreatureRepository repository;

	public boolean isMutant(DNASequence sequence) {
		Creature creature = repository.findByDNA(sequence.toString());
		boolean result = false;
		  
		if(creature != null){
			  result = creature.getCreatureClass().equals("Mutant");
		}
		else
		{
			result = DNAValidator.isMutant(sequence.getDna());
			creature = new Creature(sequence.toString(), result ? "Mutant" : "Human" );
			repository.save(creature);
		}

		return result;
	}
	
	public boolean isValidDNA(DNASequence sequence) {
		return DNAValidator.isValid(sequence.getDna());
	}
	
	public Statistics getStatistics() {
		Integer humans = repository.findByCreatureClass("Human").size();
		Integer mutants = repository.findByCreatureClass("Mutant").size();
		
		Float ratio = humans > 0 ?
				(float)mutants/(float)humans
				: 0;
		  
		Statistics stats = new Statistics(mutants,
				humans,
				ratio);
		  
		return stats;
	}
}
