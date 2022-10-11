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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.slf4j.LoggerFactory.getLogger;

@WebServlet("/meals/delete")
public class DeleteMeal extends HttpServlet {
	private static final Logger log = getLogger(DeleteMeal.class);
	private List<Meal> meals;

	@Override
	public void init() throws ServletException {
		final Object meals = getServletContext().getAttribute("meals");

		if (meals == null || !(meals instanceof CopyOnWriteArrayList)) {
			throw new IllegalStateException("Repo doesn't initialize");
		} else {
			this.meals = (CopyOnWriteArrayList<Meal>) meals;
		}
		log.debug("init DeleteMeal");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		log.debug("doDelete");

		if (Utils.idIsNumber(req)) {
			for (Meal m : meals) {
				if (m.getId() == Integer.parseInt(req.getParameter("id"))) {
					meals.remove(m);
				}
			}
			log.debug("meal Deleted");
		}

		resp.sendRedirect(req.getContextPath() + "/meals");
	}
}
