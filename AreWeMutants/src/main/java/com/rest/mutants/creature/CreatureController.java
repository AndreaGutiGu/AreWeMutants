package com.rest.mutants.creature;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.mutants.utils.DNASequence;
import com.rest.mutants.utils.Statistics;

@RestController
public class CreatureController {

  @Autowired
  private CreatureService service;

  @RequestMapping(method=RequestMethod.POST, value="/mutant")
  String isMutant(@RequestBody DNASequence sequence, HttpServletResponse response) {
	  
	  if(!service.isValidDNA(sequence)) 
	  {
		  response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		  return "Not valid entry";
	  }
		  
	  boolean result = service.isMutant(sequence);
	  
	  if(result)
		  response.setStatus(HttpServletResponse.SC_OK);
	  else
		  response.setStatus(HttpServletResponse.SC_FORBIDDEN);

	  return result ? "Mutant" : "Not Mutant";
  }
  
  @RequestMapping("/mutant/stats")
  Statistics getStatistics() {
	  return service.getStatistics();
  }
}