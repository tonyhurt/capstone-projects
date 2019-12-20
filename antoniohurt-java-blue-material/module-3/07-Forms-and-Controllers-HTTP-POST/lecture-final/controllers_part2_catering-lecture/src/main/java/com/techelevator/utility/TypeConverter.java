package com.techelevator.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TypeConverter {
	
	public String[] stringListToArray(List<String> list) {
		if (list == null) {
			return new String[0];
		}
		String[] array = list.toArray(new String[0]);
		return array;		
	}

	public String intMonthToString(int month) {
		String strMonth = "";
		switch (month) {
			case 1: 
				strMonth = "Jan.";
				break;
			case 2:
				strMonth = "Feb.";
				break;
			case 3:
				strMonth = "Mar.";
				break;
			case 4:
				strMonth = "Apr.";
				break;
			case 5:
				strMonth = "May";
				break;
			case 6:
				strMonth = "Jun.";
				break;
			case 7:
				strMonth = "Jul.";
				break;
			case 8:
				strMonth = "Aug.";
				break;
			case 9:
				strMonth = "Sep.";
				break;
			case 10:
				strMonth = "Oct.";
				break;
			case 11:
				strMonth = "Nov.";
				break;
			case 12:
				strMonth = "Dec.";
				break;
		}
		return strMonth;
	}
	
	public LocalDate stringToDate(String inputDate) {
		LocalDate date = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/uuuu").withResolverStyle(ResolverStyle.STRICT);
		try {
			date = LocalDate.parse(inputDate, dtf);
		}
		catch (DateTimeParseException e) {
			return null;
		}	
		return date;
	}
	
	public LocalDate getEndDate(LocalDate startDate, int numDays) {
		LocalDate endDate = startDate.plusDays((long)numDays);
		return endDate;
	}
	
	public String dateToString(LocalDate inputDate) {
		String stringDate = inputDate.getMonthValue() + "/" + inputDate.getDayOfMonth() + "/" + inputDate.getYear();
		return stringDate;
	}

	
}
