package com.psl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Client {

	public int findAge(String birthDate) throws InvalidDateFormatException {
		if(birthDate==null || birthDate.isEmpty())
			throw new InvalidDateFormatException();
		LocalDate date;
		long years;
		try{
				date = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
				if(date.isAfter(LocalDate.now()))
				{
					return 0;
				}
				years = ChronoUnit.YEARS.between(date, LocalDate.now());
				if(years<0)
					throw new InvalidDateFormatException();
		}
		catch(DateTimeParseException exception)
		{
			throw new InvalidDateFormatException();
		}
		return (int)years;		
	}

	public static void main(String[] args) {
		
	}

}
