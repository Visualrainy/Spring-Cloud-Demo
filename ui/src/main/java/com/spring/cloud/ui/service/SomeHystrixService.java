package com.spring.cloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeHystrixService {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackSome")
    public String getSome() {
        return restTemplate.getForObject("http://some/getSome", String.class);
    }

    public String fallbackSome() {
        return "some service 模块故障";
    }
}
