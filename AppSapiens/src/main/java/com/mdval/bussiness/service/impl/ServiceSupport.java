package com.mdval.bussiness.service.impl;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

import com.mdval.exceptions.ServiceException;
import com.mdval.utils.ConfigurationSingleton;
import com.mdval.utils.Constants;
import com.mdval.utils.DateFormatter;
import com.mdval.utils.LogWrapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * @author federico
 *
 */
@Slf4j
public class ServiceSupport {
	
	protected DateFormatter dateFormatter;
	
	protected DateFormatter oracleDateFormatter;
	
	private ConfigurationSingleton configuration;
	
	@SneakyThrows
	public ServiceSupport() {
		dateFormatter = new DateFormatter();
		oracleDateFormatter = new DateFormatter(Constants.ORACLE_OBJECT_DATE_FORMAT_FOR_PROCEDURES);
		configuration = ConfigurationSingleton.getInstance();
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
	
	/**
	 * @param procedure
	 * @param callFormat
	 * @return
	 */
	@SneakyThrows
	protected String createCall(String procedure, String callFormat) {
		String proc = configuration.getConfig(procedure);
		String paquete = configuration.getConfig(Constants.PAQUETE);
		String llamada = String.format(Constants.FORMATO_LLAMADA, paquete, proc).toUpperCase();
		return String.format(callFormat, llamada);
	}
	
	/**
	 * @return
	 */
	@SneakyThrows
	protected String createCallTypeError() {
		String paquete = configuration.getConfig(Constants.PAQUETE);
		return String.format(Constants.FORMATO_LLAMADA, paquete, Constants.T_T_ERROR).toUpperCase();
	}
	
	/**
	 * @return
	 */
	@SneakyThrows
	protected String createCallType(String type) {
		String paquete = configuration.getConfig(Constants.PAQUETE);
		return String.format(Constants.FORMATO_LLAMADA, paquete, type).toUpperCase();
	}
}
