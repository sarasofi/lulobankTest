package com.lulobank.certificacion.exceptions;

public class SomethingWhentWrong extends AssertionError{

	private static final long serialVersionUID = 1L;
	
	public SomethingWhentWrong(String mString,Throwable cause) {
		super(mString,cause);
	}

}
