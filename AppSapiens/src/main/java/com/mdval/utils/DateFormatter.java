package com.mdval.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author hcarreno
 */
public class DateFormatter {

    /**
     * Utility to parse Date to String
     *
     * @param date date to format
     * @return formated date in string
     */
    public static String dateToString(Date date){
        DateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        return format.format(date);
    }

    /**
     * Utility to parse String to Date
     *
     * @param date date to format
     * @return formatted date to Date
     */
    public static Date stringToDate(String date){
        DateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
        Date parsedDate = null;
        try {
            parsedDate = format.parse(date);
        } catch (ParseException e) {

        }
        return parsedDate;
    }
}
