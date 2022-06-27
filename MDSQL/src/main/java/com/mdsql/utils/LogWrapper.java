package com.mdsql.utils;

import org.slf4j.Logger;

import lombok.experimental.UtilityClass;

/**
 * @author federico
 *
 */
@UtilityClass
public class LogWrapper {
	
	/**
	 * @param log
	 * @param msg
	 * @param args
	 */
	public void debug(Logger log, String msg, Object... args) {
		log.info(String.format(msg, args));
	}
	
	/**
	 * @param log
	 * @param msg
	 */
	public void debug(Logger log, String msg) {
		log.info(msg);
	}
	
	/**
	 * @param log
	 * @param msg
	 * @param cause
	 */
	public void error(Logger log, String msg, Throwable cause) {
		log.error(msg, cause);
	}
	
	/**
	 * @param log
	 * @param msg
	 * @param cause
	 */
	public void error(Logger log, String msg, Object... args) {
		log.error(String.format(msg, args));
	}
	
	/**
	 * @param log
	 * @param msg
	 */
	public void error(Logger log, String msg) {
		log.error(msg);
	}
	
	/**
	 * @param log
	 * @param msg
	 * @param cause
	 */
	public void warn(Logger log, String msg, Throwable cause) {
		log.warn(msg, cause);
	}
	
	/**
	 * @param log
	 * @param msg
	 * @param cause
	 */
	public void warn(Logger log, String msg, Object... args) {
		log.warn(String.format(msg, args));
	}
	
	/**
	 * @param log
	 * @param msg
	 */
	public void warn(Logger log, String msg) {
		log.warn(msg);
	}
}
