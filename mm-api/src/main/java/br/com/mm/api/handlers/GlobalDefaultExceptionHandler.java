package br.com.mm.api.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.mm.config.exceptions.MMException;

@ControllerAdvice
class GlobalDefaultExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MMException.class)
    @ResponseBody
    public String handleError400(MMException ex) {
	return String.format("Error, cause: %s", ex.getMessages().toString());
    }

}