package com.rest.mutants;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Creature {
	
	  private @Id @GeneratedValue Long id;
	  private String dnaSequence;
	  private String creatureClass;
	  
	  Creature(){}

	  public Creature(String dnaSequence, String creatureClass) {
		  this.dnaSequence = dnaSequence;
		  this.creatureClass = creatureClass;
	  }

	  public Long getId() {
		  return id;
	  }
	  public void setId(Long id) {
		  this.id = id;
	  }
	  
	  public String getDnaSequence() {
		  return dnaSequence;
	  }
	  
	  public void setDnaSequence(String dnaSequence) {
		  this.dnaSequence = dnaSequence;
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
	    return Objects.equals(this.dnaSequence, creature.dnaSequence) && Objects.equals(this.creatureClass, creature.creatureClass);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.dnaSequence, this.dnaSequence);
	  }

	  @Override
	  public String toString() {
	    return "Creature{" + "id=" + this.id + ", dnaSequence='" + this.dnaSequence + '\'' + ", class='" + this.creatureClass + '\'' + '}';
	  }
	  
}
