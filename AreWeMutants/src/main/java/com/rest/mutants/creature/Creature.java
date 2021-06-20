package com.rest.mutants.creature;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREATURE")
public class Creature {
	
	  private @Id @GeneratedValue Integer ID;
	  @Column(name = "dna")
	  private String DNA;
	  @Column(name = "creatureclass")
	  private String creatureClass;
	  
	  Creature(){}

	  public Creature(String dnaSequence, String creatureClass) {
		  this.DNA = dnaSequence;
		  this.creatureClass = creatureClass;
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
		  return creatureClass;
	  }
	  public void setCreatureClass(String creatureClass) {
		  this.creatureClass = creatureClass;
	  }
	  
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (!(o instanceof Creature))
	      return false;
	    Creature creature = (Creature) o;
	    return Objects.equals(this.DNA, creature.DNA) && Objects.equals(this.creatureClass, creature.creatureClass);
	  }	  
}
