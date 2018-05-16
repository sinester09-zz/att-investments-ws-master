package br.com.attinvestments.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1063424789288984833L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
