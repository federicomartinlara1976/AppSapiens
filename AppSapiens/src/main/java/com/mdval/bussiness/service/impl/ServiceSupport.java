package com.mdval.bussiness.service.impl;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.mdval.exceptions.ServiceException;
import com.mdval.utils.DateFormatter;
import com.mdval.utils.LogWrapper;

import lombok.extern.log4j.Log4j;

/**
 * @author federico
 *
 */
@Log4j
public class ServiceSupport {
	
	protected DateFormatter dateFormatter;
	
	public ServiceSupport() {
		dateFormatter = new DateFormatter();
	}
	
	/**
	 * @param array
	 * @return
	 * @throws SQLException
	 */
	protected ServiceException buildException(Array array) throws SQLException {
		return buildException((Object[]) array.getArray());
	}
	
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
		
		if (!Objects.isNull(objects)) {
			StringBuilder sbArgumentos = new StringBuilder("Parámetros de entrada: \n");
			for (Object o : objects) {
				String value = (!Objects.isNull(o) && !StringUtils.isBlank(o.toString())) ? o.toString() : "NULL";
				sbArgumentos.append("\t").append(value).append("\n");
			}
			LogWrapper.debug(log, "%s", sbArgumentos.toString().trim());
		}
	}
}
