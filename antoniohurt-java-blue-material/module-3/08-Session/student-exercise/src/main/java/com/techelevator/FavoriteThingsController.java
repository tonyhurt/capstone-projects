package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "colour", "season", "food" })

public class FavoriteThingsController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showStepOne() {
		return "Wizard/GreetingStep1";

	}

	@RequestMapping(path = "/greetingOne", method = RequestMethod.POST)
	public String doStepOne(@RequestParam String colour, ModelMap map) {

		System.out.println("step one");
		map.addAttribute("colour", colour);

		return "Wizard/GreetingStep2";
	}

	@RequestMapping(path = "/greetingTwo", method = RequestMethod.POST)
	public String doStepTwo(@RequestParam String food, ModelMap map) {

		System.out.println("step two");
		map.addAttribute("food", food);

		return "Wizard/GreetingStep3";
	}

	@RequestMapping(path = "/greetingThree", method = RequestMethod.POST)
	public String doStepThree(@RequestParam String season, ModelMap map) {

		System.out.println("step three");
		map.addAttribute("season", season);

		return "Wizard/Confirm";
	}

	@RequestMapping(path = "/confirm", method = RequestMethod.GET)
	public String showConfirmation() {
		return "Wizard/Confirm";
	}

	@RequestMapping(path = "/confirm", method = RequestMethod.POST)
	public String addCity(ModelMap map) {

		return "redirect:/";
	}
}