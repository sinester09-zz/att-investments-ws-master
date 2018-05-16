package br.com.attinvestments.services.exceptions;

public class FileException extends RuntimeException {
	private static final long serialVersionUID = -5791802132733364197L;

	public FileException(String msg) {
		super(msg);
	}
	
	public FileException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
