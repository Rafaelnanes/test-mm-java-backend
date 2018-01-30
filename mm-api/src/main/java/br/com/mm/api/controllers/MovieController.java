package br.com.mm.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
	return "Alow";
    }

}
