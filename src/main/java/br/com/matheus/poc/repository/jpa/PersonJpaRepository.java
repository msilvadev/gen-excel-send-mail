package br.com.matheus.poc.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.matheus.poc.repository.PersonRepository;

public interface PersonJpaRepository extends JpaRepository<PersonRepository, Long>{

}
