package com.design.mvp.error;

public class BusinessLogicException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9172427019708405804L;
	
	public BusinessLogicException() {
		super();
	}

	public BusinessLogicException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public BusinessLogicException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BusinessLogicException(String arg0) {
		super(arg0);
	}

	public BusinessLogicException(Throwable arg0) {
		super(arg0);
	}

}
