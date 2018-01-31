package br.com.mm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.mm.config.GlobalConstants;
import br.com.mm.config.exceptions.MMException;
import br.com.mm.dao.ShoppingDAO;
import br.com.mm.model.Shopping;
import br.com.mm.service.RequestService;
import br.com.mm.service.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    private RequestService requestService;

    @Autowired
    private Environment environment;

    @Autowired
    private ShoppingDAO shoppingDAO;

    @Override
    public String getMoviesFromAPi() throws MMException {
	Shopping shopping = shoppingDAO.get();
	if (shopping == null) {
	    shopping = new Shopping();
	    try {
		String response = requestService.sendSimpleGet(environment.getProperty(GlobalConstants.API_URL));
		shopping.setApiResponse(response);
		shoppingDAO.add(shopping);
	    } catch (Exception e) {
		throw new MMException(String.format("Error sending request to Main Api, cause: %s", e.getMessage()));
	    }
	}
	return shopping.getApiResponse();
    }

}
