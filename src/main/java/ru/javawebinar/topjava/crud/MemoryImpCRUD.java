package ru.javawebinar.topjava.crud;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
//
//import java.util.List;
//
//import static org.slf4j.LoggerFactory.getLogger;
//
//public class MemoryImpCRUD implements CRUD {
//	private static final Logger log = getLogger(MemoryImpCRUD.class);
//
//	@Override
//	public void add(Meal meal) {
//		log.debug("add meal " + meal);
//
//		MealServlet.meals.add(meal);
//	}
//
//	@Override
//	public void update(Meal meal) {
//		log.debug("update meal " + meal);
//
//		int index = MealServlet.meals.indexOf(meal);
//		MealServlet.meals.set(index, meal);
//	}
//
//	@Override
//	public void remove(int id) {
//		log.debug("remove meal with " + id);
//
//		MealServlet.meals.remove(id);
//	}
//
//	@Override
//	public Meal getById(int id) {
//		log.debug("get meal with id " + id);
//		for (Meal m : MealServlet.meals) {
//			if (m.getId() == id)
//				return m;
//		}
//		return null;
//	}
//
//	@Override
//	public List<Meal> list() {
//		log.debug("get list meals");
//		return MealServlet.meals;
//	}
//}
