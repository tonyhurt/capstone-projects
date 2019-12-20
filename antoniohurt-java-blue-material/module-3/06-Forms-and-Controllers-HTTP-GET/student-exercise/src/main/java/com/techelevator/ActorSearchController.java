package com.techelevator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.techelevator.dao.ActorDao;

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

	@RequestMapping(path = "/requestActors", method = RequestMethod.GET)
	public String showActorList(HttpServletRequest request) {
		String search = request.getParameter("lastName");
		request.setAttribute("listOfActors", actorDao.getMatchingActors(search));
		return "actorList";
	}

}
