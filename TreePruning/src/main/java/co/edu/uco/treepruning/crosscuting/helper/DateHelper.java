package co.edu.uco.treepruning.crosscuting.helper;

import java.sql.Date;
import java.time.LocalDate;

public final class DateHelper {
	
	private static final DateHelper INSTANCE = new DateHelper ();
	
	private DateHelper() {
	}
	
	public static DateHelper getDateHelper() {
		return INSTANCE;
	}
	
	public LocalDate getDefault() {
		return LocalDate.of(1, 1, 1);
	}
	
	public LocalDate getDefault (final LocalDate value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
	public LocalDate generateCurrentDate() {
		return LocalDate.now();
	}
	
	public boolean isDefaultDate(final LocalDate date) {
		return getDefault().equals(date);
	}
	
	public LocalDate toLocalDate(final Date value) {
		return value.toLocalDate();
		
	}

}
