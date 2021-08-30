package com.mdval.bussiness.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mdval.exceptions.ServiceException;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
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
	
	/**
	 * @param runSP
	 * @param objects
	 */
	protected void logProcedure(String runSP, Object... objects) {
		LogWrapper.debug(log, "%s", runSP);
		StringBuilder sbArgumentos = new StringBuilder("Parámetros de entrada: \n");
		for (Object o : objects) {
			String value = (StringUtils.isBlank(o.toString())) ? "vacío" : o.toString();
			sbArgumentos.append("\t").append(value).append("\n");
		}
		LogWrapper.debug(log, "%s", sbArgumentos.toString());
	}
}
