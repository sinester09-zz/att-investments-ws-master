package br.com.attinvestments.services.exceptions;

public class DataIntegrityException extends RuntimeException {
	private static final long serialVersionUID = 442195739554775470L;

	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
