package com.rest.mutants.creature;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface CreatureRepository extends JpaRepository<Creature, Long> {
	Creature findByDNA(String DNA);

	List<Creature>findByCreatureClass (String creatureClass);

}