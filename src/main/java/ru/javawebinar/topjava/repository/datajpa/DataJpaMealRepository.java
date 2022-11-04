package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DataJpaMealRepository implements MealRepository {

	private final CrudMealRepository crudRepository;

	public DataJpaMealRepository(CrudMealRepository crudRepository) {
		this.crudRepository = crudRepository;
	}

	@Override
	public Meal save(Meal meal, int userId) {
		return meal.getUser().getId() == userId ? crudRepository.save(meal) : null;
	}

	@Override
	public boolean delete(int id, int userId) {
		Meal meal = crudRepository.getReferenceById(id);
		if (meal.getUser().getId() == userId) {
			crudRepository.delete(meal);
			return true;
		}
		return false;
	}

	@Override
	public Meal get(int id, int userId) {
		Meal meal = crudRepository.getReferenceById(id);
		return meal.getUser().getId() == userId ? meal : null;
	}

	@Override
	public List<Meal> getAll(int userId) {
		return crudRepository.findAll().stream()
				.filter(m -> m.getUser().getId() == userId).collect(Collectors.toList());
	}

	@Override
	public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
		return crudRepository.findAll().stream()
				.filter(m -> m.getUser().getId() == userId).collect(Collectors.toList());
	}
}