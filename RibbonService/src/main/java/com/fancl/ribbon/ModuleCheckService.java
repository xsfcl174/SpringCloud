package com.fancl.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @version 1.0.0
 * @Description: 验证模块服务的功能service
 * @auther fanchengliang
 * @create 2017/11/6
 * @since 1.6
 */
@Service
public class ModuleCheckService {
    @Autowired
    private RestTemplate template;

    @HystrixCommand(defaultFallback = "failWork")
    public String check(String serviceName) {
        String res = null;
        res = template.getForObject(String.format("http://%s/check", serviceName), String.class);
        return res;
    }

    private String failWork(){
        return "fail visit";
    }
}
