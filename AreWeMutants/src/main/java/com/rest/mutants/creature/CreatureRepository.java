package com.rest.mutants.creature;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface CreatureRepository extends JpaRepository<Creature, Long> {
	Creature findByDNA(String DNA);

	@Query(value = "SELECT COUNT(c.id) FROM creature c WHERE c.creature_class = 'Mutant'", nativeQuery = true)
	Integer getNumberofMutants();

	@Query(value = "SELECT COUNT(c.id) FROM creature c WHERE c.creature_class = 'Human'", nativeQuery = true)
	Integer getNumberofHumans();
	
	List<Creature>findByCreatureClass (String creatureClass);

}