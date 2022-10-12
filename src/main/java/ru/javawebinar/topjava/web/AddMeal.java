package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/meals/add")
public class AddMeal extends HttpServlet {
	private static final Logger log = getLogger(AddMeal.class);
	private List<Meal> meals;

	@Override
	public void init() throws ServletException {
		final Object meals = getServletContext().getAttribute("meals");

		if (meals == null || !(meals instanceof CopyOnWriteArrayList)) {
			throw new IllegalStateException("Repo doesn't initialize");
		} else {
			this.meals = (CopyOnWriteArrayList<Meal>) meals;
		}
		log.debug("init addMealServ");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost run");

		req.setCharacterEncoding("UTF-8");

		if (Utils.requestIsValid(req)) {
			LocalDateTime date = LocalDateTime.parse(req.getParameter("dateTimeStr"),
					Utils.FORMATTER);
			String descr = req.getParameter("description");
			int calories = Integer.parseInt(req.getParameter("calories"));

			meals.add(new Meal(ContextListener.id.getAndIncrement(), date, descr, calories));
			log.debug("add new meal");
		}

		resp.sendRedirect(req.getContextPath() + "/meals");
	}
}
