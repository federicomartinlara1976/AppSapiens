package com.mdval.bussiness.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mdval.exceptions.ServiceException;

/**
 * @author federico
 *
 */
public class ServiceSupport {
	
	/**
	 * @param array
	 * @return
	 * @throws SQLException
	 */
	protected ServiceException buildException(Object[] array) throws SQLException {
		ServiceException exception = new ServiceException();
		
		List<Object[]> errors = new ArrayList<>();
		for (Object row : array) {
			Object[] cols = ((oracle.jdbc.OracleStruct) row).getAttributes();
			errors.add(cols);
		}
		
		exception.setErrors(errors);
		return exception;
	}
}
