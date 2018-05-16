package br.com.attinvestments.domain.enums;

public enum Person_type {
	
	PHYSICAL_PERSON('F', "Pessoa Física"),
	LEGAL_PERSON('J', "Pessoa Jurídica");
	
	private char cod;
	private String description;
	
	private Person_type(char cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public char getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static Person_type toEnum(char cod) {
		if(cod == ' ') {
			return null;
		}
		
		for(Person_type x : Person_type.values()) {
			if(cod == x.getCod()) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
