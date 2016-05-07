package br.com.uniritter.teste.exception;

public class NoSuchMenuException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoSuchMenuException(String msg) {
		super(msg);
	}
}
