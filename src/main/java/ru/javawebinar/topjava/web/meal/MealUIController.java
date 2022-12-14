package ru.javawebinar.topjava.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/ui/meals", produces = MediaType.APPLICATION_JSON_VALUE)
public class MealUIController extends AbstractMealController {

	@Override
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		super.delete(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Meal create(
			@RequestParam LocalDateTime dateTime,
			@RequestParam String description,
			@RequestParam int calories
	) {
		return super.create(new Meal(null, dateTime, description, calories));
	}

	@GetMapping("/filter")
	public List<MealTo> getBetween(
			@RequestParam @Nullable LocalDate startDate,
			@RequestParam @Nullable LocalDate endDate,
			@RequestParam @Nullable LocalTime startTime,
			@RequestParam @Nullable LocalTime endTime,
			@RequestParam @Nullable String unused
	) {
		return super.getBetween(startDate, startTime, endDate, endTime);
	}
}
