package br.com.mm.service;

import br.com.mm.config.exceptions.MMException;
import br.com.mm.model.virtual.Movie;

public interface MovieService {

    Movie getById(int id) throws MMException;

}
