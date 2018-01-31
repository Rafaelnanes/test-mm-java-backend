package br.com.mm.service.impl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.mm.config.exceptions.MMException;
import br.com.mm.model.virtual.Movie;
import br.com.mm.service.MovieService;
import br.com.mm.service.ShoppingService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private ShoppingService shoppingService;

    @Override
    @Cacheable("movies")
    public Movie getById(int id) throws MMException {
	Movie movie = null;
	String response = shoppingService.getMoviesFromAPi();
	if (!StringUtils.isEmpty(response)) {
	    Type listType = new TypeToken<ArrayList<Movie>>() {
	    }.getType();
	    List<Movie> movies = new Gson().fromJson(response, listType);
	    for (Movie obj : movies) {
		if (id == obj.getId().intValue()) {
		    movie = obj;
		    break;
		}
	    }
	}
	return movie;
    }

}
