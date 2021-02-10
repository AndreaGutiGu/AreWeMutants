package com.rest.mutants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.powermock.api.mockito.PowerMockito.when;



@RunWith(SpringRunner.class)
@WebMvcTest(QueryController.class)
public class QueryControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private CreatureRepository repository;

    @Test
    public void getStatisticsTest()
      throws Exception 
    {
    	when(repository.getNumberofHumans()).thenReturn(5);
    	when(repository.getNumberofMutants()).thenReturn(5);
    	
    	mvc.perform(get("/stats")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.ratio").value("1.0"));
    }
    
}
