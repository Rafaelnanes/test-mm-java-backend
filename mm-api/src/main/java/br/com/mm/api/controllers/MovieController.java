package br.com.mm.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mm.config.exceptions.MMException;
import br.com.mm.model.virtual.Movie;
import br.com.mm.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Movie getById(@PathVariable("id") int id) throws MMException {
	return movieService.getById(id);
    }

}
