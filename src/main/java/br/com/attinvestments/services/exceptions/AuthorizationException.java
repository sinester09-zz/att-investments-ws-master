package br.com.attinvestments.services.exceptions;

public class AuthorizationException extends RuntimeException {
	private static final long serialVersionUID = 8907407958278481297L;

	public AuthorizationException(String msg) {
		super(msg);
	}
	
	public AuthorizationException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
