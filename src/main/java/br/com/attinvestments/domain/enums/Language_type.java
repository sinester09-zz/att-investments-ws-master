package br.com.attinvestments.domain.enums;

public enum Language_type {
	
	PORTUGUESE_BR(1, "br", "Portugues Brasil"),
	ENGLESH(2, "en", "Inglês"),
	SPANISH(3, "es", "Espanhol");
	
	private int cod;
	private String type;
	private String description;
	
	private Language_type(int cod, String type, String description) {
		this.cod = cod;
		this.type = type;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}
	
	public static Language_type toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Language_type x : Language_type.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
