package com.design.mvp.error;

import java.util.Set;

public class NameServiceUnSupportedFieldPatchException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7696867817627458967L;

	public NameServiceUnSupportedFieldPatchException(Set<String> keys) {
        super("Field " + keys.toString() + " update is not allow.");
    }

}
