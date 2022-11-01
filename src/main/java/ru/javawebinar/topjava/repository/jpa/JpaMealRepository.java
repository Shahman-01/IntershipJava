package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaMealRepository implements MealRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Meal save(Meal meal, int userId) {
		User user = em.find(User.class, userId);
		meal.setUser(user);
		if (meal.isNew()) {
			em.persist(meal);
			return meal;
		} else {
			return em.merge(meal);
		}
	}

	@Override
	@Transactional
	public boolean delete(int id, int userId) {
		Query query = em.createQuery("DELETE FROM Meal m WHERE m.id=:id AND m.user.id = " + userId);
		return query.setParameter("id", id)
				.executeUpdate() != 0;
	}

	@Override
	public Meal get(int id, int userId) {
		Meal meal = em.find(Meal.class, id);
		if (meal != null &&
				meal.getUser().getId().equals(userId))
			return meal;
		throw new NotFoundException("not found meal whit id = " + id);
//		return (Meal) em.createQuery("SELECT m FROM Meal m WHERE m.id = " + id + " AND m.user.id =" + userId)
//				.getResultList().get(0);
	}

	@Override
	public List<Meal> getAll(int userId) {
		return em.createQuery("SELECT m FROM Meal m WHERE m.user.id = " + userId + " ORDER BY m.dateTime DESC")
				.getResultList();
	}

	@Override
	public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
		List<Meal> meals = em.createQuery("SELECT m FROM Meal m WHERE m.user.id = " + userId + " ORDER BY m.dateTime DESC")
				.getResultList();

		List<Meal> finalList = new ArrayList<>();
		for (Meal m : meals) {
			if (m.getDateTime().isAfter(startDateTime) &&
					m.getDateTime().isBefore(endDateTime))
				finalList.add(m);
		}

		return finalList;
	}
}