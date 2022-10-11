package ru.javawebinar.topjava.utils;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.ContextListener;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Utils {
	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	public static boolean requestIsValid(HttpServletRequest req) {
		LocalDateTime date = LocalDateTime.parse(req.getParameter("dateTimeStr"),
				Utils.FORMATTER);
		String descr = req.getParameter("description");
		int calories = Integer.parseInt(req.getParameter("calories"));

		return descr != null && descr.length() > 0
				&& date != null && calories > 0;
	}

	public static boolean idIsNumber(HttpServletRequest req) {
		final String id = req.getParameter("id");
		return id != null &&
				(id.length() > 0) &&
				id.matches("[+]?\\d+");
	}

//	public static boolean idIsValid(String id, List<Meal> meals) {
//
//	}
}
