package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.slf4j.LoggerFactory.getLogger;

public class UpdateMeal extends HttpServlet {
	private static final Logger log = getLogger(UpdateMeal.class);
	private List<Meal> meals;

	@Override
	public void init() throws ServletException {
		final Object meals = getServletContext().getAttribute("meals");

		if (meals == null || !(meals instanceof CopyOnWriteArrayList)) {
			throw new IllegalStateException("Repo doesn't initialize");
		} else {
			this.meals = (CopyOnWriteArrayList<Meal>) meals;
		}
		log.debug("init UpdateMeal");
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		log.debug("doGet run");
//
//		String id = req.getParameter("id");
//
//		if (Utils.idIsValid(id, meals))
//
//	}
}
