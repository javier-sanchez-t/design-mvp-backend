package com.design.mvp.error;

public class NameServiceNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1586242798597920462L;

	public NameServiceNotFoundException(Long id) {
        super("Not found : " + id);
    }

}