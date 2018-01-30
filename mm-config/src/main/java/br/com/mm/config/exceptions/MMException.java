package br.com.mm.config.exceptions;

import java.util.ArrayList;
import java.util.List;

public class MMException extends Exception {

    private static final long serialVersionUID = -6845610310422875419L;
    private List<String> errorMessage;

    public MMException() {
	errorMessage = new ArrayList<String>();
    }

    public MMException(String message) {
	this();
	errorMessage.add(message);
    }

    public MMException(List<String> message) {
	this();
	errorMessage.addAll(message);
    }

    @Override
    public String getMessage() {
	return errorMessage.toString();
    }

    public List<String> getMessages() {
	return errorMessage;
    }

}
