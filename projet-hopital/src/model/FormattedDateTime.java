package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormattedDateTime {

	private static LocalDateTime dateTime;
	private static DateTimeFormatter formatDateTime;
	private static String formattedDateTime;

	public static String getFormattedDateTime() {
		dateTime = LocalDateTime.now();
		formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		formattedDateTime = dateTime.format(formatDateTime);
		return formattedDateTime;
	}

}
