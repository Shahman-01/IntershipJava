package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.meal.MealRestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Controller
public class JspMealController {
	private static final Logger log = LoggerFactory.getLogger(JspMealController.class);

	@Autowired
	private MealRestController controller;

	@GetMapping("/meals")
	public String meals(Model model) {
		model.addAttribute("meals", controller.getAll());
		return "meals";
	}

	@GetMapping("/meals/create")
	public String create(Model model) {
		final Meal meal = new Meal(
				LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000);
		model.addAttribute("meal", meal);
		return "mealForm";
	}

	@GetMapping("/meals/update")
	public String update(Model model) {
		final Meal meal = controller.get(getId(model));
		return "mealForm";
	}

	@GetMapping("/meals/delete")
	public String delete(Model model) {
		int id = getId(model);
		controller.delete(id);
		return "redirect:meals";
	}

	@GetMapping("/meals/filter")
	public String filter(Model model) {
		LocalDate startDate = (LocalDate) model.getAttribute("startDate");
		LocalDate endDate = (LocalDate) model.getAttribute("endDate");
		LocalTime startTime = (LocalTime) model.getAttribute("startTime");
		LocalTime endTime = (LocalTime) model.getAttribute("endTime");

		model.addAttribute("meals", controller. getBetween(
				startDate, startTime, endDate, endTime
		));
		return "meals";
	}

	private int getId(Model model) {
		String paramId = Objects.requireNonNull(model.addAttribute("id")).toString();
		return Integer.parseInt(paramId);
	}

	@PostMapping("meals/")
	public String setMeal(Model model) {
		Meal meal = new Meal(
				(LocalDateTime) model.getAttribute("dateTime"),
				(String) model.getAttribute("description"),
				(Integer) model.getAttribute("calories")
		);

		if (StringUtils.hasLength((CharSequence) model.getAttribute("id"))) {
			controller.update(meal, getId(model));
		} else {
			controller.create(meal);
		}
		return "redirect:meals";
	}
}
