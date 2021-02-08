package com.rest.mutants;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mutants.DNAValidator;

@RestController
public class QueryController {

  private final CreatureRepository repository;
  private final CreatureModelAssembler assembler;

  QueryController(CreatureRepository repository, CreatureModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }
  
  @PostMapping("/mutant")
  boolean isMutant(@RequestBody DNASequence sequence, HttpServletResponse response) {
	  boolean result = DNAValidator.isMutant(sequence.getDna());
	  
	  if(!result)
		  response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	  else
		  response.setStatus(HttpServletResponse.SC_OK);
	  
	  return result;
  }
}