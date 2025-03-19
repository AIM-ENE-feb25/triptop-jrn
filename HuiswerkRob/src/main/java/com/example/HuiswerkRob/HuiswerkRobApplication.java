package com.example.HuiswerkRob;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HuiswerkRobApplication {
	public static void main(String[] args) throws UnirestException {
		HttpResponse<String> response = Unirest.get("https://weatherapi-com.p.rapidapi.com/alerts.json?q=elst")
				.header("x-rapidapi-key", "a7b69bc686msh68ba58f492aa838p19463djsn64a146bb579d")
				.header("x-rapidapi-host", "weatherapi-com.p.rapidapi.com")
				.asString();

		// {"location":{"name":"Elst","region":"Gelderland","country":"Netherlands","lat":51.89,"lon":5.9}
		System.out.println(response.getBody());

	}
}
