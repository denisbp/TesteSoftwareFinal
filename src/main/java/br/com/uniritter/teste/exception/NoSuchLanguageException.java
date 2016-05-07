package br.com.uniritter.teste.exception;

public class NoSuchLanguageException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchLanguageException(String msg) {
		super(msg);
	}
}
