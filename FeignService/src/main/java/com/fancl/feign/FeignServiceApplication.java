package com.fancl.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class FeignServiceApplication {

    @Autowired
    private ModuleCheckService moduleCheckService;

    public static void main(String[] args) {
        SpringApplication.run(FeignServiceApplication.class, args);
    }

    @RequestMapping("/check")
    public String check() {
        return moduleCheckService.check();
    }
}
