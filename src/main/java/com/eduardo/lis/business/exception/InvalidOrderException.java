package com.eduardo.lis.business.exception;

public class InvalidOrderException extends Exception {

	private static final long serialVersionUID = 1040566091987799682L;

	public InvalidOrderException() {
		super();
	}

	public InvalidOrderException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public InvalidOrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidOrderException(String arg0) {
		super(arg0);
	}

	public InvalidOrderException(Throwable arg0) {
		super(arg0);
	}

}
