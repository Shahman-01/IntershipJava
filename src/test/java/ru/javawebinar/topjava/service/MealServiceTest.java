package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;

import static ru.javawebinar.topjava.MealTestDate.*;

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

	@Test
	public void create() {
		Meal created = service.create(getNew(), USER_ID);
		Integer newId = created.getId();
		Meal newMeal = getNew();
		newMeal.setId(newId);
		assertMatch(created, newMeal);
		assertMatch(service.get(newId, USER_ID), newMeal);
	}
}
