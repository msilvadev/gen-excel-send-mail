package br.com.matheus.poc.business;

import java.util.stream.Stream;

public enum HeaderExcel {
	
	ID("ID"),
	NOME("NOME"),
	CPF_CNPJ("CPF_CNPJ"),
	ANIVERSARIO("ANIVESÁRIO"),
	STATUS("STATUS");
	
	private final String value;

	private HeaderExcel(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static HeaderExcel fromString(final String value) {
		return Stream.of(HeaderExcel.values()) //
				.filter(e -> e.value.equalsIgnoreCase(value)) //
				.findFirst() //
				.orElseThrow(() -> new EnumConstantNotPresentException(HeaderExcel.class, value));
	}
}
