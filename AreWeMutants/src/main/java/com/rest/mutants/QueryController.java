package com.rest.mutants;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.DNAValidator;

@RestController
public class QueryController {

  private final CreatureRepository repository;

  QueryController(CreatureRepository repository) {
    this.repository = repository;
  }
  
  
  @PostMapping("/mutant")
  String isMutant(@RequestBody DNASequence sequence, HttpServletResponse response) {
	  Creature creature = repository.findByDNA(sequence.toString());
	  boolean result = false;
	  
	  if(creature != null)
	  {
		  result = creature.getCreatureClass().equals("Mutant") ? true : false;
	  }
	  else
	  {
		  result = DNAValidator.isMutant(sequence.getDna());
		  creature = new Creature(sequence.toString(), result?"Mutant":"Human");
		  repository.save(creature);
	  }
	  
	  if(!result)
		  response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	  else
		  response.setStatus(HttpServletResponse.SC_OK);

	  return result ? "Mutant!!" : "Not mutant";
  }
  
  @GetMapping("/stats")
  Statistics getStatistics() {
	  Integer humans = repository.getNumberofHumans();
	  Integer mutants = repository.getNumberofMutants();
	  Float ratio = humans > 0 ?
			  (float)mutants/(float)humans
			  : 0;
	  
	  Statistics stats = new Statistics(mutants,
			  humans,
			  ratio);
	  
	  return stats;
  }
}