package com.mdsql.exceptions;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author federico
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8287632943709257608L;
	
	@Getter
	@Setter
	private transient List<Object[]> errors;
	
	@Getter
	@Setter
	private String type;

	/**
	 * 
	 */
	public ServiceException() {
		super();
	}
	
	/**
	 * 
	 */
	public ServiceException(String type) {
		super();
		this.type = type;
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}
	
	

}
