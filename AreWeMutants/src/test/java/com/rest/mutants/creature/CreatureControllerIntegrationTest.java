package com.rest.mutants.creature;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.rest.mutants.utils.DNASequence;
import com.rest.mutants.utils.Statistics;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(CreatureController.class)
public class CreatureControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private CreatureRepository repository;

    @MockBean
    private CreatureService service;
    
    @Mock
    private List<Creature> mockListHuman;
    
    @Mock
    private List<Creature> mockListMutant;

    @Mock
    private DNASequence mockSequence;
    
    @Mock
    private Statistics mockStatistics;

    /**
     * Validates the response status given by GET method /mutant/stats
     * @throws Exception
     */
    @Test
    public void getStatisticsTest()
      throws Exception 
    {
    	Statistics stats = new Statistics(10,5,(float)2);
    	when(service.getStatistics()).thenReturn(stats);

    	mvc.perform(MockMvcRequestBuilders
    	  .get("/mutant/stats")
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk());
    }
    
    /**
     * Validates the response status given by POST method /mutant when it is a Mutant
     * @throws Exception
     */
    @Test
    public void isMutantTrueTest()
      throws Exception 
    {
    	JSONArray jsonDNA = new JSONArray();
    	jsonDNA.put("A");
    	jsonDNA.put("C");

    	JSONObject json = new JSONObject();
    	json.put("dna",jsonDNA);

    	String[] dna = {"A", "C"};
    	DNASequence sequence = new DNASequence();
    	sequence.setDna(dna);
    	
    	when(service.isValidDNA(sequence)).thenReturn(true);
    	when(service.isMutant(sequence)).thenReturn(true);
    	
    	mvc.perform(MockMvcRequestBuilders
    			.post("/mutant")
  	      		.content(json.toString())
    			.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    /**
     * Validates the response status given by POST method /mutant when it is a Human
     * @throws Exception
     */
    @Test
    public void isMutantFalseTest()
      throws Exception 
    {
    	JSONArray jsonDNA = new JSONArray();
    	jsonDNA.put("A");
    	jsonDNA.put("C");

    	JSONObject json = new JSONObject();
    	json.put("dna",jsonDNA);

    	String[] dna = {"A", "C"};
    	DNASequence sequence = new DNASequence();
    	sequence.setDna(dna);

    	when(service.isValidDNA(sequence)).thenReturn(true);
    	when(service.isMutant(sequence)).thenReturn(false);
    	
    	mvc.perform(MockMvcRequestBuilders
    			.post("/mutant")
  	      		.content(json.toString())
    			.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    /**
     * Validates the response status given by POST method /mutant when it is a not valid entry
     * @throws Exception
     */
    @Test
    public void isMutantNotValidTest()
      throws Exception 
    {
    	JSONArray jsonDNA = new JSONArray();
    	jsonDNA.put("A");
    	jsonDNA.put("C");

    	JSONObject json = new JSONObject();
    	json.put("dna",jsonDNA);

    	String[] dna = {"A", "C"};
    	DNASequence sequence = new DNASequence();
    	sequence.setDna(dna);

    	when(service.isValidDNA(sequence)).thenReturn(false);
    	
    	mvc.perform(MockMvcRequestBuilders
    			.post("/mutant")
  	      		.content(json.toString())
    			.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

}
