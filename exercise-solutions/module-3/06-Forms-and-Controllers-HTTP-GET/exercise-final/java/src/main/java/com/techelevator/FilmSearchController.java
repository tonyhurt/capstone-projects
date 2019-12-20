package com.techelevator;

import com.techelevator.dao.FilmDao;
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

    @RequestMapping(path = "/filmForm", method = RequestMethod.GET)
    public String showFilmSearchForm() {
        return "filmList";
    }

    @RequestMapping(path = "/filmSearch", method = RequestMethod.GET)
    public String searchFilms(@RequestParam(defaultValue = "0") int minimumLength,
            @RequestParam(defaultValue = "1000") int maximumLength, @RequestParam String genre, ModelMap modelHolder) {
        modelHolder.put("films", filmDao.getFilmsBetween(genre, minimumLength, maximumLength));
        return "filmList";
    }

}