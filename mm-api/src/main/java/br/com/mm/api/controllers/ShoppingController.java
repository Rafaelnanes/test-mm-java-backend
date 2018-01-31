package br.com.mm.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mm.config.exceptions.MMException;
import br.com.mm.service.ShoppingService;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    private ShoppingService shoppingService;

    @RequestMapping(method = RequestMethod.GET)
    public String get() throws MMException {
	return shoppingService.getMoviesFromAPi();
    }

}
