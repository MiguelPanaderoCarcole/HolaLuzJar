package com.hola.luz.exception;

public class ExceptionRead extends Exception {

	private static final long serialVersionUID = -2940486484946830651L;

	public ExceptionRead(String message) {
        super(message);
    }
	
	public ExceptionRead(String message, Throwable cause) {
        super(message, cause);
    }
}
