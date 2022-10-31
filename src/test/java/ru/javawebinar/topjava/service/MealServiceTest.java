package ru.javawebinar.topjava.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
		"classpath:spring/spring-app.xml",
		"classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

	static {
		SLF4JBridgeHandler.install();
	}

	@Autowired
	private MealService service;

	private MealRepository repository;

	@Test
	public void delete() {
		service.delete(MEAL1_ID, USER_ID);
		assertThrows(NotFoundException.class, () -> service.get(MEAL1_ID, USER_ID));
	}

	@Test
	public void deleteNotFound() {
		assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND, USER_ID));
	}

	@Test
	public void deleteNotOwn() {
		assertThrows(NotFoundException.class, () -> service.delete(MEAL1_ID, ADMIN_ID));
	}

	@Test
	public void duplicateDateTimeCreate() {
		assertThrows(DataAccessException.class, () ->
				service.create(new Meal(null, meal1.getDateTime(), "duplicate", 100), USER_ID));
	}

	@Test
	public void get() {
		Meal actual = service.get(ADMIN_MEAL_ID, ADMIN_ID);
		assertMatch(actual, adminMeal1);
	}

	@Test
	public void getAll() {
		assertMatch(service.getAll(USER_ID), meals);
	}
}
