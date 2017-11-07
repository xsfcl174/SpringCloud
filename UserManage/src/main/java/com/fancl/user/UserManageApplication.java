package com.fancl.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class UserManageApplication {

    @Value("${server.port}")
    private int serverPort;
    @Value("${spring.application.name}")
    private String serverName;

    public static void main(String[] args) {
        SpringApplication.run(UserManageApplication.class, args);
    }

    @RequestMapping(value = "check")
    public String check() {
        return serverName + " in port[" + serverPort + "] check ok";
    }
}
