package com.mdval.utils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.log4j.Log4j;

/**
 * @author hcarreno
 */
@Log4j
public class DateFormatter {

	private SimpleDateFormat dateFormat;

	public DateFormatter() {
		try {
			ConfigurationSingleton instance = ConfigurationSingleton.getInstance();
			String format = instance.getConfig("dateTimeFormat");
			dateFormat = new SimpleDateFormat(format);
		} catch (IOException e) {
			LogWrapper.error(log, "ERROR:", e);
		}
	}

	/**
	 * Utility to parse Date to String
	 *
	 * @param date date to format
	 * @return formated date in string
	 */
	public String dateToString(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * Utility to parse String to Date
	 *
	 * @param date date to format
	 * @return formatted date to Date
	 * @throws ParseException 
	 */
	public Date stringToDate(String date) throws ParseException {
		return dateFormat.parse(date);
	}
}
