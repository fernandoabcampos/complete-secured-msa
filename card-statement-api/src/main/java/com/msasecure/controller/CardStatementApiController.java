package com.msasecure.controller;

import java.net.URI;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CardStatementApiController {
	
    @Autowired
    private LoadBalancerClient loadBalancer;
	
    private RestTemplate restTemplate = new RestTemplate();
    
    @RequestMapping("/{cardId}")
    @HystrixCommand(fallbackMethod = "defaultProductStatement")
    public ResponseEntity<String> getProductComposite(@PathVariable int cardId, @RequestHeader(value="Authorization") String authorizationHeader, Principal currentUser) {

    	System.out.println("CSApi - User= " + currentUser.getName() + ", Auth= "+authorizationHeader+", called with card= "+cardId);
        URI uri = loadBalancer.choose("card-extract-integration").getUri();
        String url = uri.toString() + "/product/" + cardId;

        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        System.out.println("card-extract-integration http-status: "+ result.getStatusCode());
        System.out.println("card-extract-integration body: {}"+ result.getBody());

        return result;
    }

    public ResponseEntity<String> defaultProductStatement(@PathVariable int cardId, @RequestHeader(value="Authorization") String authorizationHeader, Principal currentUser) {

    	System.out.println("FALLBACK CSApi - User= " + currentUser.getName() + ", Auth= "+authorizationHeader+", called with card= "+cardId);
        return new ResponseEntity<String>("", HttpStatus.BAD_GATEWAY);
    }

}
