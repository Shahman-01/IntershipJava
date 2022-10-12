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

@WebServlet("/meals/update")
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doPost run");

		req.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(req.getParameter("id"));

		log.debug("id :" + id);
		LocalDateTime date = LocalDateTime.parse(req.getParameter("dateTimeStr"),
				Utils.FORMATTER);
		String descr = req.getParameter("description");
		int calories = Integer.parseInt(req.getParameter("calories"));

		meals.get(id).setCalories(calories);
		meals.get(id).setDateTime(date);
		meals.get(id).setDescription(descr);

		log.debug("meal Updated");

		resp.sendRedirect(req.getContextPath() + "/meals");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet run");

		int id = Integer.parseInt(req.getParameter("id"));

		log.debug("id :" + id);

		if (Utils.idIsInvalid(id + "", meals))
			resp.sendRedirect(req.getContextPath() + "/meals");

		final Meal meal = meals.get(id);
		req.setAttribute("meal", meal);

		req.getRequestDispatcher("/update.jsp").forward(req, resp);
	}
}
