package com.spring.breweryclient.web.client;

import com.spring.breweryclient.web.model.Beer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
//Adding property externally with application.properties
//ignoreUnknownFields = false means apihost is mandatory
@ConfigurationProperties(value = "brewery.client", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1="api/v1/beer";
    private String apihost;
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Beer getBeerById(UUID id){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+id.toString(),Beer.class);
    }

    public void setApiHost(String apiHost){
        this.apihost = apiHost;
    }
}
