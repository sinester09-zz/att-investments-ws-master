package br.com.attinvestments.domain.enums;

public enum Phone_type {
	
	PHONE_COML(1, "Telefone Comercial"),
	PHONE_PRIV(2, "Telefone Residencial"),
	CELL_COML(3, "Celular Comercial"),
	CELL_PRIV(4, "Celular Pessoal");
	
	private int cod;
	private String type;
	
	private Phone_type(int cod, String type) {
		this.cod = cod;
		this.type = type;
	}

	public int getCod() {
		return cod;
	}

	public String getType() {
		return type;
	}
	
	public static Phone_type toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(Phone_type x : Phone_type.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + cod);
	}

}
