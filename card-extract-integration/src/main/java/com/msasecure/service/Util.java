package com.msasecure.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;

@Component
public class Util {

    @Autowired
    private LoadBalancerClient loadBalancer;
	
	public URI getServiceUrl(String serviceId, String fallback) {
        URI uri = null;
        try {
            ServiceInstance instance = loadBalancer.choose(serviceId);
            uri = instance.getUri();
        } catch (RuntimeException e) {
            uri = URI.create(fallback);
        }

        return uri;
    }
}
