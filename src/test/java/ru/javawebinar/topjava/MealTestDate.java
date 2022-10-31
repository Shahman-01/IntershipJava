package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class MealTestDate {

	public static final int USER_ID = 100000;
	public static Meal getNew() {
		return new Meal(LocalDateTime.now(), "Завтрак", 1000);
	}

	public static void assertMatch(Meal actual, Meal expected) {
		assertThat(actual).usingRecursiveComparison().ignoringFields("registered", "roles").isEqualTo(expected);
	}

	public static void assertMatch(Iterable<Meal> actual, Meal ... expected) {
		assertMatch(actual, Arrays.asList(expected));
	}

	public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
		assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("registered", "roles").isEqualTo(expected);
	}
}
