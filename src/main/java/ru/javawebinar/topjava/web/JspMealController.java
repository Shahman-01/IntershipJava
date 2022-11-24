package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.javawebinar.topjava.web.meal.MealRestController;

@Controller
public class JspMealController {
	private static final Logger log = LoggerFactory.getLogger(JspMealController.class);

	@Autowired
	private MealRestController controller;

	@GetMapping("meals/")
	public String meals() {

	}
}
