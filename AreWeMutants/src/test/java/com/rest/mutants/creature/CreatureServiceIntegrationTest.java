package com.rest.mutants.creature;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.List;

import com.rest.mutants.utils.DNASequence;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreatureServiceIntegrationTest {
	@Mock
    private CreatureRepository creatureRepository;
    
    @Mock
    private DNASequence mockDNASequence;
    
    @Mock
    private List<Creature> mockHumanList;

    @Mock
    private List<Creature> mockMutantList;

    @Mock
    private Creature mockCreature;

    private CreatureService service;

    /**
     * Validates a Mutant DNA already in the database
     */
    @Test
    public void isMutantCreatedTestTrue(){

    	service = new CreatureService();
    	Whitebox.setInternalState(service, "repository", creatureRepository);
    	
    	DNASequence sequence = new DNASequence();
    	String[]dna = {"AAAA", "AAAA", "AAAA", "AAAA"};
    	sequence.setDna(dna);

    	when(creatureRepository.findByDNA(sequence.toString())).thenReturn(mockCreature);
    	when(mockCreature.getCreatureClass()).thenReturn("Mutant");
    	
    	assertTrue(service.isMutant(sequence));
    }

    /**
     * Validates a Human DNA already in the database
     */
    @Test
    public void isMutantCreatedTestFalse(){

    	service = new CreatureService();
    	Whitebox.setInternalState(service, "repository", creatureRepository);
    	
    	DNASequence sequence = new DNASequence();
    	String[]dna = {"AAAA", "AAAA", "AAAA", "AAAA"};
    	sequence.setDna(dna);

    	when(creatureRepository.findByDNA(sequence.toString())).thenReturn(mockCreature);
    	when(mockCreature.getCreatureClass()).thenReturn("Human");
    	
    	assertTrue(!service.isMutant(sequence));
    }
    
    /**
     * Validates a Mutant DNA not in the database
     */
    @Test
    public void isMutantTestTrue(){

    	service = new CreatureService();
    	Whitebox.setInternalState(service, "repository", creatureRepository);
    	
    	DNASequence sequence = new DNASequence();
    	String[]dna = {"AAAA", "AAAA", "AAAA", "AAAA"};
    	sequence.setDna(dna);

    	when(creatureRepository.findByDNA(sequence.toString())).thenReturn(null);
    	when(creatureRepository.save(Mockito.any(Creature.class))).thenReturn(mockCreature);
    	
    	
    	assertTrue(service.isMutant(sequence));
    }
    
    /**
     * Validates a Human DNA not in the database
     */
    @Test
    public void isMutantTestFalse(){
    	service = new CreatureService();
    	Whitebox.setInternalState(service, "repository", creatureRepository);
    	
    	DNASequence sequence = new DNASequence();
    	String[]dna = {"ACGT", "TGCA", "ACGT", "TGCA"};
    	sequence.setDna(dna);

    	when(creatureRepository.findByDNA(sequence.toString())).thenReturn(null);
    	when(creatureRepository.save(Mockito.any(Creature.class))).thenReturn(mockCreature);
    	
    	assertTrue(!service.isMutant(sequence));
    }
    
    /**
     * Tests a valid DNA sequence
     */
    @Test
    public void isValidDNATestTrue(){
    	service = new CreatureService();

    	DNASequence sequence = new DNASequence();
    	String[]dna = {"AAAA", "AAAA", "AAAA", "AAAA"};
    	sequence.setDna(dna);

    	assertTrue(service.isValidDNA(sequence));
    }

    /**
     * Tests a DNA sequence, invalid because of the number of lines
     */
    @Test
    public void isValidDNATestFalse(){
    	service = new CreatureService();

    	DNASequence sequence = new DNASequence();
    	String[]dna = {"AAAA", "AAAA"};
    	sequence.setDna(dna);

    	assertTrue(!service.isValidDNA(sequence));
    }

    /**
     * Validates the ratio gotten from the given number of humans and mutants
     */
    @Test
    public void getStatisticsTest(){
    	service = new CreatureService();
    	Whitebox.setInternalState(service, "repository", creatureRepository);

    	when(creatureRepository.findByCreatureClass("Human")).thenReturn(mockHumanList);
    	when(creatureRepository.findByCreatureClass("Mutant")).thenReturn(mockMutantList);
    	when(mockHumanList.size()).thenReturn(5);
    	when(mockMutantList.size()).thenReturn(5);

    	assertTrue(service.getStatistics().getRatio() == 1);
    }

    /**
     * Validates the ratio gotten from the given number of humans and mutants, when number of humans is 0
     */
    @Test
    public void getStatisticsNoHumansTest(){
    	service = new CreatureService();
    	Whitebox.setInternalState(service, "repository", creatureRepository);

    	when(creatureRepository.findByCreatureClass("Human")).thenReturn(mockHumanList);
    	when(creatureRepository.findByCreatureClass("Mutant")).thenReturn(mockMutantList);
    	when(mockHumanList.size()).thenReturn(0);
    	when(mockMutantList.size()).thenReturn(5);

    	assertTrue(service.getStatistics().getRatio() == 0);
    }
}
