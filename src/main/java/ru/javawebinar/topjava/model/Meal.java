package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {
	private int id;
	private LocalDateTime dateTime;

	private String description;

	private int calories;

	public Meal(int id, LocalDateTime dateTime, String description, int calories) {
		this.id = id;
		this.dateTime = dateTime;
		this.description = description;
		this.calories = calories;
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

	public LocalDate getDate() {
		return dateTime.toLocalDate();
	}

	public LocalTime getTime() {
		return dateTime.toLocalTime();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getId() {
		return id;
	}
}