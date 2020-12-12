package com.spring.breweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//Adding property externally with application.properties
//ignoreUnknownFields = false means apihost is mandatory
@ConfigurationProperties(value = "brewery.client", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1="api/v1/beer";
    private String apihost;

    public void setApiHost(String apiHost){
        this.apihost = apiHost;
    }
}
