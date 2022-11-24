package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.meal.MealRestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Controller
public class JspMealController {
	private static final Logger log = LoggerFactory.getLogger(JspMealController.class);

	@Autowired
	private MealRestController controller;

	@GetMapping("/meals/create")
	public String createMeal(Model model, HttpServletRequest request) {
		final Meal meal = new Meal(
				LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000);
		model.addAttribute("meal", meal);
		return "redirect:mealForm.jsp";
	}

	@GetMapping("/meals/update")
	public String updateMeal(Model model, HttpServletRequest request) {
		final Meal meal = controller.get(getId(request));
		return "redirect:mealForm.jsp";
	}

	private int getId(HttpServletRequest request) {
		String paramId = Objects.requireNonNull(request.getParameter("id"));
		return Integer.parseInt(paramId);
	}

//	@GetMapping("meals/")
//	public String meals(Model model) {
//		Meal meal = new Meal(
//				(LocalDateTime) model.getAttribute("dateTime"),
//				(String) model.getAttribute("description"),
//				(Integer) model.getAttribute("calories")
//		);
//
//
//	}
}
