package ru.javawebinar.topjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MealTo {
	private final int id;
	private final LocalDateTime dateTime;

	private final String description;

	private final int calories;

	private final boolean excess;

	private String dateTimeStr;

	public MealTo(int id, LocalDateTime dateTime, String description, int calories, boolean excess) {
		this.id = id;
		this.dateTime = dateTime;
		this.description = description;
		this.calories = calories;
		this.excess = excess;
	}

	@Override
	public String toString() {
		return "MealTo{" +
				"dateTime=" + dateTime +
				", description='" + description + '\'' +
				", calories=" + calories +
				", excess=" + excess +
				'}';
	}

	public String getDateTimeStr() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		dateTimeStr = dateTime.format(formatter);
		return dateTimeStr;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public String getDescription() {
		return description;
	}

	public int getCalories() {
		return calories;
	}

	public boolean isExcess() {
		return excess;
	}

	public int getId() {
		return id;
	}
}