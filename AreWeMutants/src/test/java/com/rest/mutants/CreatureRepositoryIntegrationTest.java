package com.rest.mutants;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
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

    @Test
    public void findByDNATest(){
    	Creature creature = new Creature("AAAA", "Mutant");
        entityManager.persist(creature);
        entityManager.flush();

        Creature found = creatureRepository.findByDNA("AAAA");

        assertTrue(found.equals(creature));
    }

    @Test
    public void getNumberOfHumansTest(){
    	Creature creature = new Creature("ABCD", "Mutant");
        entityManager.persist(creature);

        creature = new Creature("XXXX", "Mutant");
        entityManager.persist(creature);
        creature = new Creature("YYYY", "Human");
        entityManager.persist(creature);
        
        entityManager.flush();
        
        int count = creatureRepository.getNumberofHumans();
        
        assertTrue(count == 1);
    }
    
    @Test
    public void getNumberOfMutantsTest(){
    	
    	Creature creature = new Creature("ABCD", "Mutant");
        entityManager.persist(creature);

        creature = new Creature("XXXX", "Mutant");
        entityManager.persist(creature);
        creature = new Creature("YYYY", "Human");
        entityManager.persist(creature);
        
        entityManager.flush();
        
        int count = creatureRepository.getNumberofMutants();
        
        assertTrue(count == 2);
    }
    
}
