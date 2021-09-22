package com.mdval.utils;

import java.math.BigDecimal;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

import lombok.SneakyThrows;

/**
 * @author federico
 *
 */
/**
 * @author federico
 *
 */
public class AppHelper {

	/**
	 * Para usar el bean después de obtenerlo, hacer un cast del bean concreto.
	 * 
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		AppGlobalSingleton appGlobalSingleton = AppGlobalSingleton.getInstance();
		ApplicationContext context = (ApplicationContext) appGlobalSingleton.getProperty(Constants.SPRING_CONTEXT);

		return context.getBean(name);
	}

	/**
	 * Normaliza el valor de SI y NO a S y N
	 * 
	 * @param value
	 * @return
	 */
	public static String normalizeCmbSiNoValue(String value) {
		return "SI".equals(value) ? "S" : "N";
	}

	/**
	 * Normaliza el valor de S y N a SI y NO
	 * 
	 * @param value
	 * @return
	 */
	public static String normalizeSiNoValueToCmb(String value) {
		return "S".equals(value) ? "SI" : "NO";
	}

	/**
	 * Normaliza el valor de S y N a true y false
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean normalizeCheckValue(String value) {
		return "S".equals(value) ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * Normaliza el valor de true y false a S y N
	 * 
	 * @param value
	 * @return
	 */
	public static String normalizeValueToCheck(Boolean value) {
		return Boolean.TRUE.equals(value) ? "S" : "N";
	}

	/**
	 * @param sCodigo
	 * @return
	 */
	@SneakyThrows
	public static BigDecimal toBigDecimal(String sCodigo, String errMessage) {
		try {
			if (StringUtils.isNotBlank(sCodigo)) {
				Long valor = Long.parseLong(sCodigo);
				return new BigDecimal(valor);
			}
	
			return null;
		} catch (NumberFormatException e) {
			throw new Exception(errMessage);
		}
	}
	
	/**
	 * @param num
	 * @return
	 */
	public static String toString(BigDecimal num) {
		return (!Objects.isNull(num)) ? num.toString() : StringUtils.EMPTY;
	}
	
	/**
	 * @param s
	 * @return
	 */
	public static String toValidString(String s) {
		return (StringUtils.isNotBlank(s)) ? s : StringUtils.EMPTY;
	}
}
