package br.com.matheus.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matheus.poc.business.GenerateExcelBusiness;

@RestController
@RequestMapping("generate")
public class GenerateExcelController {
	
	@Autowired
	GenerateExcelBusiness ge;
	
	@GetMapping
	public ResponseEntity<?> generateExcel(){
		ge.generate();
		return ResponseEntity.ok(null);
	}
}
