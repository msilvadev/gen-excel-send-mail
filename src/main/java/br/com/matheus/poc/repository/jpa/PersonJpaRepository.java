package br.com.matheus.poc.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheus.poc.entitie.PersonEntitie;

public interface PersonJpaRepository extends JpaRepository<PersonEntitie, Long>{

}
