package com.rest.mutants;
import org.springframework.data.jpa.repository.JpaRepository;

interface CreatureRepository extends JpaRepository<Creature, Long> {

}