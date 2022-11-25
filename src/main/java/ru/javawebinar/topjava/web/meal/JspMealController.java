package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Controller
@RequestMapping("/meals")
public class JspMealController extends AbstractMealController {

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("meal", new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), "", 1000));
		return "mealForm";
	}

	@GetMapping("/update")
	public String update(Model model, HttpServletRequest request) {
		model.addAttribute("meal", super.get(getId(request)));
		return "mealForm";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request) {
		super.delete(getId(request));
		return "mealForm";
	}

	@GetMapping("/filter")
	public String filter(Model model, HttpServletRequest request) {
		LocalDate startDate = (LocalDate) model.getAttribute("startDate");
		LocalDate endDate = (LocalDate) model.getAttribute("endDate");
		LocalTime startTime = (LocalTime) model.getAttribute("startTime");
		LocalTime endTime = (LocalTime) model.getAttribute("endTime");

		model.addAttribute("meal", super.getBetween(startDate, startTime, endDate, endTime));
		return "redirect:/meals";
	}

	private int getId(HttpServletRequest request) {
		String paramId = Objects.requireNonNull(request.getParameter("id"));
		return Integer.parseInt(paramId);
	}

	public String setMeal(HttpServletRequest request) {
		Meal meal = new Meal(LocalDateTime.parse(request.getParameter("dateTime")),
				request.getParameter("description"),
				Integer.parseInt(request.getParameter("calories"))
		);

		if (request.getParameter("id").isEmpty()) {
			super.create(meal);
		} else {
			super.update(meal, getId(request));
		}
		return "redirect:meals";
	}
}
