package com.techelevator;

import java.util.List;
import java.util.Map;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActorSearchController {

	@Autowired
	private ActorDao actorDao;

	@RequestMapping("/actor")
	public String showSearchActorForm() {
		return "actorList";
	}

	@RequestMapping("/actorSearch")
	public String searchActors(@RequestParam String name, ModelMap map) {
		
		List<Actor> actors = actorDao.getMatchingActors(name.toUpperCase());
		map.addAttribute("actors", actors);
		
		return "actorList";
	}
}
