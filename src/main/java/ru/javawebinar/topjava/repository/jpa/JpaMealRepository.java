package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.MealRepository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JpaMealRepository implements MealRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public Meal save(Meal meal, int userId) {
//		Query query = em.createQuery("SELECT u FROM User u WHERE u.id = " + userId);
//		User user = (User) query.getResultList().get(0);
//		meal.setUser(user);
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
		return null;
//        Meal m = em.find(Meal.class, id);
//        if (m.getUser().equals(userId))
//            return null;
//        return m;
	}

	@Override
	public List<Meal> getAll(int userId) {
		return em.createQuery("SELECT m FROM Meal m WHERE m.user.id = " + userId + " ORDER BY m.dateTime DESC")
				.getResultList();
	}

	@Override
	public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
		return em.createQuery("SELECT m FROM Meal m WHERE m.user.id=" + userId +
						" AND m.dateTime >= " + startDateTime + " AND m.dateTime < " + endDateTime + " ORDER BY m.dateTime DESC")
				.getResultList();
	}
}