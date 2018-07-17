package com.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Pavan
 *
 */
@ResponseStatus(value=HttpStatus.EXPECTATION_FAILED,reason="No Language Exists in System, Please enter valid Language.")
public class LanguageNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}