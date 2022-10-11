package ru.javawebinar.topjava.crud;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface CRUD {
	public void add(Meal meal);

	public void update(Meal meal);

	public void remove(int id);

	public Meal getById(int id);

	public List<Meal> list();
}
