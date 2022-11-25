package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> 020cb3b (add JspMealController, but in's not works yet)
import org.springframework.web.bind.annotation.RequestMapping;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

<<<<<<< HEAD
=======
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;

>>>>>>> 020cb3b (add JspMealController, but in's not works yet)
@Controller
@RequestMapping("/meals")
public class JspMealController extends AbstractMealController {

<<<<<<< HEAD
=======
	@GetMapping("/delete")
	public String delete(HttpServletRequest request) {
		super.delete(getId(request));
		return "redirect:/meals";
	}

	@GetMapping("/update")
	public String update(HttpServletRequest request, Model model) {
		model.addAttribute("meal", super.get(getId(request)));
		return "mealForm";
	}

>>>>>>> 020cb3b (add JspMealController, but in's not works yet)
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("meal", new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS), "", 1000));
		return "mealForm";
	}

<<<<<<< HEAD
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
=======
	@PostMapping
	public String updateOrCreate(HttpServletRequest request) {
		Meal meal = new Meal(LocalDateTime.parse(request.getParameter("dateTime")),
				request.getParameter("description"),
				Integer.parseInt(request.getParameter("calories")));
>>>>>>> 020cb3b (add JspMealController, but in's not works yet)

		if (request.getParameter("id").isEmpty()) {
			super.create(meal);
		} else {
			super.update(meal, getId(request));
		}
<<<<<<< HEAD
		return "redirect:meals";
	}
}
=======
		return "redirect:/meals";
	}

	@GetMapping("/filter")
	public String getBetween(HttpServletRequest request, Model model) {
		LocalDate startDate = parseLocalDate(request.getParameter("startDate"));
		LocalDate endDate = parseLocalDate(request.getParameter("endDate"));
		LocalTime startTime = parseLocalTime(request.getParameter("startTime"));
		LocalTime endTime = parseLocalTime(request.getParameter("endTime"));
		model.addAttribute("meals", super.getBetween(startDate, startTime, endDate, endTime));
		return "meals";
	}

	private int getId(HttpServletRequest request) {
		String paramId = Objects.requireNonNull(request.getParameter("id"));
		return Integer.parseInt(paramId);
	}
}
>>>>>>> 020cb3b (add JspMealController, but in's not works yet)
