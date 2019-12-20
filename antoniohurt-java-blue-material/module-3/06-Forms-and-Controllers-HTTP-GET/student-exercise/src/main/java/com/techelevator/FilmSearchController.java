package com.techelevator;

import com.techelevator.dao.FilmDao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;

    @RequestMapping("/film")
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping(path="/requestFilms", method = RequestMethod.GET)
    public String searchFilms(HttpServletRequest request) {
    	int minLength = 0;
    	int maxLength = 0;
    	String genre = request.getParameter("genre");
    	if (request.getParameter("minLength").length() > 0) {
        	 minLength = Integer.parseInt(request.getParameter("minLength"));
    	}
    	if (request.getParameter("maxLength").length() > 0) {
        	 maxLength = Integer.parseInt(request.getParameter("maxLength"));
    	}
    	request.setAttribute("listOfFilms", filmDao.getFilmsBetween(genre, minLength, maxLength));
    	
        return "filmList";
    }

}