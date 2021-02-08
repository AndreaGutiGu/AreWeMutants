package com.rest.mutants;

import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;


@Component
public class CreatureModelAssembler implements RepresentationModelAssembler<Creature, EntityModel<Creature>> {

  @Override
  public EntityModel<Creature> toModel(Creature creature) {
	  
    return EntityModel.of(creature);
  }
  
  @Bean
  public CreatureModelAssembler assembler() {
      return new CreatureModelAssembler();
  }

}