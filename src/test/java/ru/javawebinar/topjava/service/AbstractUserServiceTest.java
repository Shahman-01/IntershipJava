package ru.javawebinar.topjava.service;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.dao.DataAccessException;
import ru.javawebinar.topjava.UserTestData;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThrows;
import static org.slf4j.LoggerFactory.getLogger;
import static ru.javawebinar.topjava.UserTestData.*;
import static ru.javawebinar.topjava.UserTestData.user;

public abstract class AbstractUserServiceTest extends AbstractServiceTest{

	protected static final Logger log = getLogger("result");

	protected static final StringBuilder results = new StringBuilder();

	@Rule
	// http://stackoverflow.com/questions/14892125/what-is-the-best-practice-to-determine-the-execution-time-of-the-bussiness-relev
	public final Stopwatch stopwatch = new Stopwatch() {
		@Override
		protected void finished(long nanos, Description description) {
			String result = String.format("\n%-25s %7d", description.getMethodName(), TimeUnit.NANOSECONDS.toMillis(nanos));
			results.append(result);
			log.info(result + " ms\n");
		}
	};

	@Autowired
	protected UserService service;

	@Autowired
	protected CacheManager cacheManager;

	@Before
	public void setup() {
		cacheManager.getCache("users").clear();
	}

	@AfterClass
	public static void printResult() {
		log.info("\n---------------------------------" +
				"\nTest                 Duration, ms" +
				"\n---------------------------------" +
				results +
				"\n---------------------------------");
	}

	@Test
	public abstract void create();

	@Test
	public abstract void duplicateMailCreate();

	@Test
	public abstract void delete();

	@Test
	public abstract void deletedNotFound();

	@Test
	public abstract void get();

	@Test
	public abstract void getNotFound();

	@Test
	public abstract void getByEmail();

	@Test
	public abstract void update();

	@Test
	public abstract void getAll();
}
