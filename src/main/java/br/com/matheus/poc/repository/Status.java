package br.com.matheus.poc.repository;

import java.util.stream.Stream;

public enum Status {
	
	ATIVO("ativo"),
	INATIVO("inativo");

	private final String value;

	private Status(final String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static Status fromString(final String value) {
		return Stream.of(Status.values()) //
				.filter(e -> e.value.equalsIgnoreCase(value)) //
				.findFirst() //
				.orElseThrow(() -> new EnumConstantNotPresentException(Status.class, value));
	}
}
