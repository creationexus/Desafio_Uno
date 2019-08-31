package com.previred.periodos.tools;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Procesador de fechas
 * @author mgonzalez@previred.com
 */
public class ProcessDate {
	
	public static LocalDate ld2LD(org.threeten.bp.LocalDate localDate){
		return LocalDate.of(localDate.getYear(),localDate.getMonthValue(),localDate.getDayOfMonth());
	}
	
	public static List<LocalDate> datesRange(LocalDate start, LocalDate end){
		long numOfMonthsBetween = ChronoUnit.MONTHS.between(start.plusMonths(1), end);
		
	    return numOfMonthsBetween>0 ? Stream.iterate(start.plusMonths(1), date -> date.plusMonths(1))
	    .limit(numOfMonthsBetween)
	    .collect(Collectors.toList()) : new ArrayList<LocalDate>();
	}
	
}