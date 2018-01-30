package br.com.mm.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mm.service.MovieService;
import br.com.mm.service.RequestService;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RequestService requestService;

    @Override
    public String getMoviesFromAPi() {
	String response = "";
	try {
	    response = requestService.sendSimpleGet("http://sonaesodetapi.herokuapp.com/api/v2/movie?shoppingId=1");
	} catch (IOException e) {
	    System.out.println(e.getMessage());
	    // TODO
	}
	return response;
    }

}
