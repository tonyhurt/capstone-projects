package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.dao.ActorDao;
import com.techelevator.dao.model.Actor;

@RestController
@RequestMapping("/api/actor")
@CrossOrigin
public class ActorSearchRestController {

	@Autowired
	private ActorDao actorDao;
	
	@GetMapping
	public List<Actor> getActors(@RequestParam String name) {
		return actorDao.getMatchingActors(name);
	}
}
