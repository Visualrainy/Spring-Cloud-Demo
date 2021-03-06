package com.spring.cloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeHystrixService {
    // Ribbon can automatically be configured by
    // registering RestTemplate as a bean and annotating it with @LoadBalanced
    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome() {
        return restTemplate.getForObject("http://some/getsome", String.class);
    }

    public String fallbackSome() {
        return "some service 模块故障";
    }
}
