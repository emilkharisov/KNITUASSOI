package ru.knitu.controller.rest;

import lombok.experimental.var;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;


@Controller
public class TestRest {

    @GetMapping("/hello2")
    public String hello(){

        Map<String, String> parameter = new HashMap<>();

        parameter.put("engine", "google_scholar");
        parameter.put("q", "biology");
        parameter.put("api_key", "secret_api_key");

        /*
        GoogleSearchResults client = new GoogleSearchResults(parameter);

        try
        {
            JsonObject results = client.getJson();
            var organic_results = results.get("organic_results");
        }
        catch (SerpApiClientException ex)
        {
            Console.WriteLine("Exception:");
            Console.WriteLine(ex.ToString());
        }
        */
        return null;
    }

}
