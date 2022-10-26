package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

	private final MealRepository repository;

	public MealService(MealRepository repository) {
		this.repository = repository;
	}

	public Meal create(Meal meal) {
		return repository.save(meal, SecurityUtil.authUserId());
	}

	public void delete(int id) {
		checkNotFoundWithId(repository.delete(id, SecurityUtil.authUserId()), id);
	}

	public Meal get(int id) {
		return checkNotFoundWithId(repository.get(id, SecurityUtil.authUserId()), id);
	}

	public Collection<Meal> getAll() {
		return repository.getAll(SecurityUtil.authUserId());
	}

	public void update(Meal meal) {
		checkNotFoundWithId(repository.save(meal, SecurityUtil.authUserId()), meal.getId());
	}

}