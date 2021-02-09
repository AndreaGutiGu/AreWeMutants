package com.rest.mutants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface CreatureRepository extends JpaRepository<Creature, Long> {
	Creature findByDNA(String DNA);

	@Query(value = "SELECT COUNT(c.ID) FROM CREATURE c WHERE c.CREATURE_CLASS = 'Mutant'", nativeQuery = true)
	Integer getNumberofMutants();

	@Query(value = "SELECT COUNT(c.ID) FROM CREATURE c WHERE c.CREATURE_CLASS = 'Human'", nativeQuery = true)
	Integer getNumberofHumans();

}