package ru.javawebinar.topjava.repository.jdbc.forHsqldb;

import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.jdbc.AbstractJdbcMealRepository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Profile("hsqldb")
public class JdbcMealRepositoryForHsqldb extends AbstractJdbcMealRepository {
	public JdbcMealRepositoryForHsqldb(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super(jdbcTemplate, namedParameterJdbcTemplate);
	}

	@Override
	public boolean delete(int id, int userId) {
		return jdbcTemplate.update("DELETE FROM meals WHERE id=? AND user_id=?", id, userId) != 0;
	}

	@Override
	public Meal save(Meal meal, int userId) {
		return null;
	}

	@Override
	public List<Meal> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId) {
		return null;
	}


}
