package br.com.matheus.poc.business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.matheus.poc.repository.PersonRepository;
import br.com.matheus.poc.repository.Status;
import br.com.matheus.poc.repository.jpa.PersonJpaRepository;

@Component
public class GenerateExcelBusiness {
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	public void generate() {
		this.mockPeople();
		
		List<PersonRepository> people = personJpaRepository.findAll();
		
		this.generateExcel(people);
	}
	
	private void generateExcel(List<PersonRepository> people) {
		//TODO criar excel e gravar a partir da lista de pessoas que este metodo recebe
	}
	
	private void mockPeople() {
		List<PersonRepository> people = new ArrayList<PersonRepository>();
		
		people.add(new PersonRepository("Soteldo", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		people.add(new PersonRepository("Marinho", "721.239.100-07", LocalDate.now(), Status.INATIVO));
		people.add(new PersonRepository("Sasha", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		people.add(new PersonRepository("Alison", "721.239.100-07", LocalDate.now(), Status.INATIVO));
		people.add(new PersonRepository("Carlos Sanches", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		people.add(new PersonRepository("Gustavo Henrique", "721.239.100-07", LocalDate.now(), Status.INATIVO));
		people.add(new PersonRepository("Derliz", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		
		personJpaRepository.saveAll(people);
	}
}
