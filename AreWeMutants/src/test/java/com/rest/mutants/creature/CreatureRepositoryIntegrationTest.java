package com.rest.mutants.creature;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CreatureRepositoryIntegrationTest {
	
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CreatureRepository creatureRepository;

    /**
     * Validates a DNA already present in the database
     */
    @Test
    public void findByDNATest(){
    	Creature creature = new Creature("AAAA|CAGT|GCTA|CTAG", "Mutant");
        entityManager.persist(creature);
        entityManager.flush();

        Creature found = creatureRepository.findByDNA("AAAA|CAGT|GCTA|CTAG");

        assertTrue(found.equals(creature));
    }
    
    /**
     * Validates the number of Human DNAs in the database
     */
    @Test
    public void findByCreatureClassTestHuman(){
    	Creature creature = new Creature("A|A|A|C", "Human");
        entityManager.persist(creature);
        
        creature = new Creature("C|C|C|C", "Human");        
        entityManager.persist(creature);
        
        creature = new Creature("AAAA|CAGT|GCTA|CTAG", "Mutant");        
        entityManager.persist(creature);
        
        entityManager.flush();

        assertTrue(creatureRepository.findByCreatureClass("Human").size()==2);
    }
    
    /**
     * Validates the number of Mutant DNAs in the database
     */
    @Test
    public void findByCreatureClassTestMutant(){
    	Creature creature = new Creature("A|A|A|C", "Human");
        entityManager.persist(creature);
        
        creature = new Creature("C|C|C|C", "Human");        
        entityManager.persist(creature);
        
        creature = new Creature("AAAA|CAGT|GCTA|CTAG", "Mutant");        
        entityManager.persist(creature);
        
        entityManager.flush();

        assertTrue(creatureRepository.findByCreatureClass("Mutant").size()==1);
    }
    
}
