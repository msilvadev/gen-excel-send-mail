package br.com.matheus.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.matheus.poc.business.GenerateExcelBusiness;

@Service
public class GenerateExcelService {
	
	@Autowired
	GenerateExcelBusiness generateExcelBusiness;
	
	public void generateExcel() {
		//TODO criar chamada para business criar o excel
		generateExcelBusiness.generate();
	}
}
