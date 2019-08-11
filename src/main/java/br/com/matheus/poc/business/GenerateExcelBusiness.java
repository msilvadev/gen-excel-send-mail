package br.com.matheus.poc.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.matheus.poc.entitie.PersonEntitie;
import br.com.matheus.poc.entitie.Status;
import br.com.matheus.poc.repository.jpa.PersonJpaRepository;

@Component
public class GenerateExcelBusiness {
	
	@Autowired
	private PersonJpaRepository personJpaRepository;
	
	@Value("${excel.path}")
	private String pathExcel;
	
	private int rowNum;
	
	public void generate() {
		this.mockPeople();
		
		List<PersonEntitie> people = personJpaRepository.findAll();
		
		this.generateExcel(people);
	}
	
	private void generateExcel(List<PersonEntitie> people) {
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheetPerson = workbook.createSheet("Person");
        
        rowNum = 0;
        
        createHeader(sheetPerson);
        
        people.forEach(person -> {
        	Row row = sheetPerson.createRow(rowNum++);
            int cellnum = 0;
            
            Cell cellId = row.createCell(cellnum++);
            cellId.setCellValue(person.getId());
            
            Cell cellName = row.createCell(cellnum++);
            cellName.setCellValue(person.getName());

            Cell cellDocument = row.createCell(cellnum++);
            cellDocument.setCellValue(person.getDocument());

            Cell cellBirthday = row.createCell(cellnum++);
            cellBirthday.setCellValue(person.getBirthday().toString());

            Cell cellStatus = row.createCell(cellnum++);
            cellStatus.setCellValue(person.getStatus().getValue());
        });
        
        saveFile(workbook);
	}

	private void saveFile(HSSFWorkbook workbook) {
		try {
            FileOutputStream out = 
                    new FileOutputStream(new File(this.pathExcel));
            workbook.write(out);
            out.close();
            System.out.println("Arquivo Excel criado com sucesso!");
              
        } catch (FileNotFoundException e) {
            e.printStackTrace();
               System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
               System.out.println("Erro na edição do arquivo!");
        }
	}

	private void createHeader(HSSFSheet sheetPerson) {
		Row row0 = sheetPerson.createRow(rowNum++);
        int cellnum0 = 0;
        Cell cellHeaderId = row0.createCell(cellnum0++);
        cellHeaderId.setCellValue(HeaderExcel.ID.getValue());
        Cell cellHeaderName = row0.createCell(cellnum0++);
        cellHeaderName.setCellValue(HeaderExcel.NOME.getValue());
        Cell cellHeaderCPFCNPJ = row0.createCell(cellnum0++);
        cellHeaderCPFCNPJ.setCellValue(HeaderExcel.CPF_CNPJ.getValue());
        Cell cellHeaderBirthday = row0.createCell(cellnum0++);
        cellHeaderBirthday.setCellValue(HeaderExcel.ANIVERSARIO.getValue());
        Cell cellHeaderStatus = row0.createCell(cellnum0++);
        cellHeaderStatus.setCellValue(HeaderExcel.STATUS.getValue());
	}
	
	private void mockPeople() {
		List<PersonEntitie> people = new ArrayList<PersonEntitie>();
		
		people.add(new PersonEntitie("Soteldo", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		people.add(new PersonEntitie("Marinho", "721.239.100-07", LocalDate.now(), Status.INATIVO));
		people.add(new PersonEntitie("Sasha", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		people.add(new PersonEntitie("Alison", "721.239.100-07", LocalDate.now(), Status.INATIVO));
		people.add(new PersonEntitie("Carlos Sanches", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		people.add(new PersonEntitie("Gustavo Henrique", "721.239.100-07", LocalDate.now(), Status.INATIVO));
		people.add(new PersonEntitie("Derliz", "721.239.100-07", LocalDate.now(), Status.ATIVO));
		
		personJpaRepository.saveAll(people);
	}
}
