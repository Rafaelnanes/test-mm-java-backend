package br.com.mm.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.mm.config.GlobalConstants;
import br.com.mm.config.exceptions.MMException;
import br.com.mm.service.MovieService;
import br.com.mm.service.RequestService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RequestService requestService;

    @Autowired
    private Environment environment;

    @Override
    public String getMoviesFromAPi() throws MMException {
	String response = "";
	try {
	    response = requestService.sendSimpleGet(environment.getProperty(GlobalConstants.API_URL));
	} catch (IOException e) {
	    throw new MMException(String.format("Error sending request to Main Api, cause: %s", e.getMessage()));
	}
	return response;
    }

}
