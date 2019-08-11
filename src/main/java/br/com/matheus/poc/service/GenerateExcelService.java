package br.com.matheus.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.matheus.poc.business.GenerateExcelBusiness;

@Service
public class GenerateExcelService {
	
	@Autowired
	GenerateExcelBusiness generateExcelBusiness;
	
	@Scheduled(cron = "0 0/1 * * * *")
	public void generateExcel() {
		System.out.println("Starting generation excel");
		generateExcelBusiness.generate();
		System.out.println("End generation excel");
	}
}
