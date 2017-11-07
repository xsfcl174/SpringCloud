package com.fancl.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0.0
 * @Description: TODO
 * @auther fanchengliang
 * @create 2017/11/6
 * @since 1.6
 */
@FeignClient(value = "UserManage", fallback = ModuleCheckFailService.class)
public interface ModuleCheckService {
    @RequestMapping("/check")
    String check();
}
