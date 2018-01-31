package br.com.mm.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import br.com.mm.config.exceptions.MMException;
import br.com.mm.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

    @Override
    public String sendSimpleGet(String url) throws Exception {
	String response = "";
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	int responseCode = con.getResponseCode();
	if (responseCode == HttpURLConnection.HTTP_OK) {
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuilder sb = new StringBuilder();

	    while ((inputLine = in.readLine()) != null) {
		sb.append(inputLine);
	    }
	    in.close();
	    response = sb.toString();

	} else {
	    throw new MMException("Invalid Status");
	}

	return response;
    }

}
