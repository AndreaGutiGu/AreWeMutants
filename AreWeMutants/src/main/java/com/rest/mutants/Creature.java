package com.rest.mutants;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREATURE")
public class Creature {
	
	  private @Id @GeneratedValue Integer ID;
	  private String DNA;
	  private String CREATURE_CLASS;
	  
	  Creature(){}

	  public Creature(String dnaSequence, String creatureClass) {
		  this.DNA = dnaSequence;
		  this.CREATURE_CLASS = creatureClass;
	  }

	  public Integer getId() {
		  return ID;
	  }
	  public void setId(Integer id) {
		  this.ID = id;
	  }
	  
	  public String getDnaSequence() {
		  return DNA;
	  }
	  
	  public void setDnaSequence(String dnaSequence) {
		  this.DNA = dnaSequence;
	  }
	  public String getCreatureClass() {
		  return CREATURE_CLASS;
	  }
	  public void setCreatureClass(String creatureClass) {
		  this.CREATURE_CLASS = creatureClass;
	  }
	  
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (!(o instanceof Creature))
	      return false;
	    Creature creature = (Creature) o;
	    return Objects.equals(this.DNA, creature.DNA) && Objects.equals(this.CREATURE_CLASS, creature.CREATURE_CLASS);
	  }	  
}
