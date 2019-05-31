package com.spring.cloud.some;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient //similar as @EnableEurekaClient
@RestController
public class SomeApplication {
    //通过@Value注入来自config server的值
    @Value("${my.message}")
    private String message;

    @RequestMapping(value = "/getsome")
    public String getSome() {
        return message;
    }

    public static void main(String[] args) {
        SpringApplication.run(SomeApplication.class, args);
    }
}
